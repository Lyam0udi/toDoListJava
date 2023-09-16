package toDoListJavaClasses;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class List extends JPanel {
    
    List() {
        // Create a GridLayout with 1 column for vertically stacking task items
        GridLayout layout = new GridLayout(0, 1); // Use 0 rows for dynamic task items
        layout.setVgap(10); // Increased vertical gap for better spacing
        this.setLayout(layout);
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding
        
        // Remove the background color setting (commented out)
        // this.setBackground(Color.black);
    }

    // Method to update task numbers (indexes)
    public void updateNumbers() {
        Component[] listItems = this.getComponents();

        for (int i = 0; i < listItems.length; i++) {
            if (listItems[i] instanceof Task) {
                // Update the index of each task item
                ((Task) listItems[i]).changeIndex(i + 1);
            }
        }
    }

    // Method to remove completed tasks from the list
    public void removeCompletedTasks() {
        for (Component c : getComponents()) {
            if (c instanceof Task) {
                if (((Task) c).getState()) {
                    // Remove the completed task from the list
                    remove(c);
                    updateNumbers(); // Update task numbers after removal
                }
            }
        }
    }
}
