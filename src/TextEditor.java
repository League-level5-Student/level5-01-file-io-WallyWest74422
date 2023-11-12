import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextEditor implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton save;
	JButton load;
	JTextArea area;
    String text;
	public static void main(String[] args) {
		TextEditor te = new TextEditor();
		te.setup();
	}
public void setup() {
	frame = new JFrame();
	panel = new JPanel();
	save = new JButton("SAVE");
	load = new JButton("LOAD");
	area = new JTextArea(50,50);
	frame.add(panel);
	panel.add(save);
	panel.add(load);
	panel.add(area);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	save.addActionListener(this);
	load.addActionListener(this);
	frame.pack();
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==save) {
		System.out.println("Saving...");
	String file = JOptionPane.showInputDialog("Enter a file in which to save the text.");
String text = area.getText();
System.out.println(text);
try {
	FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/"+file);

	fw.write(text);
		
	fw.close();
} catch (IOException e1) {
	e1.printStackTrace();
}
	}else if(e.getSource()==load) {
		System.out.println("Loading...");
		String loaded = "";
		String filed = JOptionPane.showInputDialog("Enter a file name from which to receive the text to load.");
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_00_Intro_To_File_Input_and_Output/"+filed));			
			String line = br.readLine();
			while(line != null){
				System.out.println(line);
loaded+= line + "\n";
				line = br.readLine();
			}
			area.setText(loaded);
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

}
