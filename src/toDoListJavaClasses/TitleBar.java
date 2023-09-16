package toDoListJavaClasses;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitleBar extends JPanel {
    
    // Constructor 
    TitleBar() {
        this.setPreferredSize(new Dimension(400, 80));
        this.setBackground(new Color(0x2196F3)); // Light blue background
        
        JLabel titleText = new JLabel("To Do List");
        titleText.setPreferredSize(new Dimension(200, 80));
        titleText.setFont(new Font("Sans-serif", Font.BOLD, 24)); // Slightly larger and bolder font
        titleText.setForeground(Color.WHITE); // White text
        titleText.setHorizontalAlignment(JLabel.CENTER);

        this.add(titleText);
    }
}

