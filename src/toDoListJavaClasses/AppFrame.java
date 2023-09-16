package toDoListJavaClasses;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AppFrame extends JFrame{
	
	private TitleBar title;
	private List list;
	private ButtonPanel btnPanel;
	
	private JButton addTask;
	private JButton clearTask;
	
	// Constructor 
	AppFrame(){
		this.setSize(400,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		title = new TitleBar();
		list = new List();
		btnPanel = new ButtonPanel();
		
		this.add(title,BorderLayout.NORTH);
		this.add(btnPanel,BorderLayout.SOUTH);
		this.add(list,BorderLayout.CENTER);
		
		addTask = btnPanel.getAddTask();
		clearTask = btnPanel.getClearTask();
		
		addListeners();
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
		
		
//		clear.addMouseListener(new MouseAdapter()
//		{
//			@override
//			public void mousePressed(MouseEvent e)
//			{
//				list.removeCompletedTasks();
//				repaint();
//			}
//		});
	}
}
