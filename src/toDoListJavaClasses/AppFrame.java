package toDoListJavaClasses;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

public class AppFrame extends JFrame {
    
    private TitleBar title;
    private List list;
    private ButtonPanel btnPanel;
    
    private JButton addTask;
    private JButton clearTask;
    
    // Constructor 
    AppFrame() {
        // Create instances of the TitleBar, List, and ButtonPanel classes
        title = new TitleBar();
        list = new List();
        btnPanel = new ButtonPanel();
        
        // Add padding and spacing to components
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btnPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Set the layout of the frame and add components to it
        this.add(title, BorderLayout.NORTH);
        this.add(btnPanel, BorderLayout.SOUTH);
        this.add(list, BorderLayout.CENTER);
        
        // Get references to the "Add Task" and "Clear Task" buttons
        addTask = btnPanel.getAddTask();
        clearTask = btnPanel.getClearTask();

        // Attach event listeners to the buttons
        addListeners();

        // Set frame properties
        this.pack(); // Pack the frame to size it based on the preferred sizes of components
        this.setSize(600, 800); // Set an initial size
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My To-Do List"); // Set a more descriptive window title
        this.setLocationRelativeTo(null); // Center the frame
        this.setVisible(true);
    }

    // Method to attach event listeners to buttons
    public void addListeners() {
        addTask.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Create a new Task and add it to the list
                Task task = new Task();
                list.add(task);
                list.updateNumbers();
                revalidate();
                
                // Attach an event listener to the "Done" button of the task
                task.getDone().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        // Change the state of the task and update the list
                        task.changeState();
                        list.updateNumbers();
                        revalidate();
                    }
                });
            }
        });

        clearTask.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Remove completed tasks from the list and repaint
                list.removeCompletedTasks();
                repaint();
            }
        });
    }
}
