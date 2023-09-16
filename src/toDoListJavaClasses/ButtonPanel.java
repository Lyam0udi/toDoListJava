package toDoListJavaClasses;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
    
    private JButton addTask;
    private JButton clearTask;
    
    // Constructor 
    ButtonPanel() {
        this.setPreferredSize(new Dimension(400, 60));

        addTask = new JButton("Add Task");
        addTask.setBackground(new Color(0x4CAF50)); // Light green background
        addTask.setForeground(Color.WHITE); // White text
        addTask.setFont(new Font("Sans-serif", Font.PLAIN, 20));

        clearTask = new JButton("Clear Task");
        clearTask.setBackground(new Color(0x2196F3)); // Light blue background
        clearTask.setForeground(Color.WHITE); // White text
        clearTask.setFont(new Font("Sans-serif", Font.PLAIN, 20));

        this.add(addTask);
        this.add(clearTask);
    }

    public JButton getAddTask() {
        return addTask;
    }

    public JButton getClearTask() {
        return clearTask;
    }
}
