import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextEditor implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton save;
	JButton load;
	JTextArea area;
	public static void main(String[] args) {
		TextEditor te = new TextEditor();
		te.setup();
	}
public void setup() {
	frame = new JFrame();
	panel = new JPanel();
	save = new JButton("SAVE");
	load = new JButton("LOAD");
	area = new JTextArea();
	panel.setSize(500, 500);
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
	}else if(e.getSource()==load) {
		System.out.println("Loading...");
	}
}
}
