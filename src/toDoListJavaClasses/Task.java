package toDoListJavaClasses;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Task extends JPanel {
    
    JLabel index;
    JTextField taskName;
    JButton done;
    
    private boolean checked;
    
    Task() {
        // Set the preferred size of the task item panel
        this.setPreferredSize(new Dimension(400, 50)); // Slightly taller task item
        this.setBackground(Color.white); // White background
        
        this.setLayout(new BorderLayout());
        
        checked = false;
        
        // Create and configure the index label
        index = new JLabel("");
        index.setPreferredSize(new Dimension(20, 50)); // Match the height
        index.setHorizontalAlignment(JLabel.CENTER);
        this.add(index, BorderLayout.WEST);

        // Create and configure the task name text field
        taskName = new JTextField("Add your Task here");
        taskName.setBorder(BorderFactory.createEmptyBorder());
        taskName.setBackground(Color.white); // White background
        this.add(taskName, BorderLayout.CENTER);
        
        // Create and configure the "Done" button
        done = new JButton("Done");
        done.setPreferredSize(new Dimension(50, 50)); // Larger button
        done.setBorder(BorderFactory.createEmptyBorder());
        done.setFocusPainted(false);
        done.setBackground(new Color(0x4CAF50)); // Light green background
        done.setForeground(Color.white); // White text
        this.add(done, BorderLayout.EAST);
    }
    
    // Method to change the task index (number)
    public void changeIndex(int num) {
        this.index.setText(num + "");
        this.revalidate();
    }
    
    // Getter method to access the "Done" button
    public JButton getDone() {
        return done;
    }
    
    // Getter method to check the state of the task (completed or not)
    public boolean getState() {
        return checked;
    }
    
    // Method to change the state of the task to completed
    public void changeState() {
        this.setBackground(new Color(0x4CAF50)); // Change to light green when completed
        taskName.setBackground(new Color(0x4CAF50)); // Change text field background
        checked = true;
        revalidate();
    }
}
