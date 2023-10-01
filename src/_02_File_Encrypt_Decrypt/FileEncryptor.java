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
		String m = JOptionPane.showInputDialog("Enter a message.");
		String k = JOptionPane.showInputDialog("Enter a key.");
		int key = Integer.parseInt(k);
		String message ="";
	
	
	FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test.txt", true);
	String[] letters = m.split("");
	for(int i = 0; i<letters.length; i++) {
char ch = letters[i].charAt(0);
if((char)((char)ch)>31 && (char)((char)ch)<48) {			//If it is a space/symbol/punctuation...
	message = (message +ch);
}else if((char)((char)ch+key)>90 && (char)((char)ch+key)<97) {   //If the capital letter goes past Z.
	int diff = (((char)((char)ch+key))-90);
	ch = (char) (65+diff-1);
	message = (message +ch);
}else if((char)((char)ch+key)>122) {	 //If the lowercase letter goes past z.
	int diff = (((char)((char)ch+key))-122);
	ch = (char) (97+diff-1);
	message = (message +ch);
}else {
ch =  (char)((char)ch+key);
message = (message +ch);
}
	}
	fw.write(message);
	fw.close();
	
	
} catch (IOException e) {
	e.printStackTrace();
}

}
	
}

//Copyright © 2023 Ashay M