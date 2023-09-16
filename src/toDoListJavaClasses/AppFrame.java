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
        title = new TitleBar();
        list = new List();
        btnPanel = new ButtonPanel();
        
        // Add padding and spacing to components
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btnPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        this.add(title, BorderLayout.NORTH);
        this.add(btnPanel, BorderLayout.SOUTH);
        this.add(list, BorderLayout.CENTER);
        
        addTask = btnPanel.getAddTask();
        clearTask = btnPanel.getClearTask();

        addListeners();

        this.pack(); // Pack the frame to size it based on the preferred sizes of components
        this.setSize(600, 800); // Set an initial size
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My To-Do List"); // Set a more descriptive window title
        this.setLocationRelativeTo(null); // Center the frame
        this.setVisible(true);
    }

	
	public void addListeners()
	{
		addTask.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				Task task = new Task();
				list.add(task);
				list.updateNumbers();
				revalidate();
				
				
				task.getDone().addMouseListener(new MouseAdapter()
				{
					@Override
					public void mousePressed(MouseEvent e)
					{
						
						task.changeState();
						list.updateNumbers();
						revalidate();
						
					}
				});
			}
			
		});
		
		
		clearTask.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				list.removeCompletedTasks();
				repaint();
			}
		});
	}
}
