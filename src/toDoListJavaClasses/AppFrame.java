package toDoListJavaClasses;

import javax.swing.JFrame;

public class AppFrame extends JFrame{
	
	private TitleBar title;
	private List list;
	private ButtonPanel btnPanel;
	
	// Constructor 
	AppFrame(){
		this.setSize(400,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
