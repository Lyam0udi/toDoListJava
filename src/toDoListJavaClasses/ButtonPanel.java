package toDoListJavaClasses;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ButtonPanel extends JPanel {
	
	private JButton addTask;
	private JButton clearTask;
	
	Border emptyBorder = BorderFactory.createEmptyBorder();
	
	//Constructor 
	ButtonPanel(){
		this.setPreferredSize(new Dimension(400,60));
		//this.setBackground(Color.BLUE);
		
		addTask = new JButton("Add Task");
		addTask.setBorder(emptyBorder);
		addTask.setFont(new Font("Sans-serif",Font.PLAIN, 20));
		this.add(addTask);
		
		this.add(Box.createHorizontalStrut(20));
		
		clearTask = new JButton("Clear Task");
		clearTask.setBorder(emptyBorder);
		clearTask.setFont(new Font("Sans-serif",Font.PLAIN, 20));	
		this.add(clearTask);
	}
	
	public JButton getAddTask(){
		return addTask;
	}
	
	public JButton getClearTask() {
		return clearTask;
	}
}
