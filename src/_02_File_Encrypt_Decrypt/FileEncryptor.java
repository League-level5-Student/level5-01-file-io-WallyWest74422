package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
	public static void main(String[] args) {
		
		
	try {
	// Create a program that takes a message from the user and saves it to a file.
		String message = JOptionPane.showInputDialog("Enter a message.");
		String key = JOptionPane.showInputDialog("Enter a key.");
	
	FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/encryption.txt");
	for(int i = 0; i<message.length(); i++) {
		
	}
	fw.write(message);
	fw.close();
	
	
} catch (IOException e) {
	e.printStackTrace();
}

}
	
}
