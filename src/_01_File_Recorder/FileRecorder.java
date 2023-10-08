package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	public static void main(String[] args) {
		
	
	try {
	// Create a program that takes a message from the user and saves it to a file.
	String message = JOptionPane.showInputDialog("Enter a message.");
	
	FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);
	fw.write(message);
	fw.close();
	
	
} catch (IOException e) {
	e.printStackTrace();
}

}
}

//Copyright © 2023 Ashay M
//Copyright © 2023 Ashay M
// Only one Copyright © 2023 Ashay M
// Only one Copyright © 2023 Ashay M