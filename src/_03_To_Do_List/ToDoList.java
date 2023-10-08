package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton b1 = new JButton("Add Task");
	JButton b2 = new JButton("View Tasks");
	JButton b3 = new JButton("Remove Task");
	JButton b4 = new JButton("Save List");
	JButton b5 = new JButton("Load List");
	ArrayList<String> list = new ArrayList<String>();


	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task and
	 * add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt the
	 * user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the user
	 * for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	public static void main(String[] args) {
		ToDoList td = new ToDoList();
		td.setup();
	}

	private void setup() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/todo.txt"));	
			String line = br.readLine();
			while(line != null){
				list.add(line);
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setSize(200, 200);
		frame.add(panel);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		frame.setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		frame.pack();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b1) {
			String task = JOptionPane.showInputDialog("Please enter a task to add.");
			list.add(task);
		} else if (e.getSource() == b2) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} else if (e.getSource() == b3) {
String str = JOptionPane.showInputDialog("Enter the name of the task that you would like to remove.");
for (int i = 0; i < list.size(); i++) {
	if(str.equals(list.get(i))) {
		list.remove(i);
	}
}
		} else if (e.getSource() == b4) {
			String file = JOptionPane.showInputDialog("Create a file name to save your list into.");
			
		
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/"+ file+".txt");
				FileWriter save = new FileWriter("src/_03_To_Do_List/todo.txt", true);
				for (int i = 0; i < list.size(); i++) {
					fw.write(list.get(i) + "\n");
					save.write(list.get(i) + "\n");
				}					 
				fw.close();
				save.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	
			
		} else if (e.getSource() == b5) {
String name = JOptionPane.showInputDialog("What is the name of your file?");
String file = "src/_03_To_Do_List/" +name+ ".txt";
try {
	BufferedReader br = new BufferedReader(new FileReader(file));	
	String line = br.readLine();
	while(line != null){
		System.out.println(line);
		line = br.readLine();
	}
	br.close();
} catch (FileNotFoundException e1) {
	e1.printStackTrace();
} catch (IOException e1) {
	e1.printStackTrace();
}
		}

	}
}

//Copyright © 2023 Ashay M
//Copyright © 2023 Ashay M
// Only one Copyright © 2023 Ashay M
// Only one Copyright © 2023 Ashay M