package toDoListJavaClasses;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class List extends JPanel{
	
	List(){
		GridLayout layout = new GridLayout(10,1);
		layout.setVgap(5);
		this.setLayout(layout);
//		this.setBackground(Color.black);
	}
	public void updateNumbers() {
		Component[] listItems = this.getComponents();	}
}
