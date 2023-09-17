package _02_File_Encrypt_Decrypt;

import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	public static void main(String[] args) {
StringBuilder str = new StringBuilder("");
		try {
			FileReader fr = new FileReader("src/_00_Intro_To_File_Input_and_Output/test.txt");
			int c = fr.read();
			while(c != -1){
				if((c)>31 && (c)<48) {			//If it is a space/symbol/punctuation...
					str.append((char)c);
					System.out.println(c);
				}else if((c-4)>47 && (c-4)<65) {
					int diff = 65-(((char)c)-4);
					c = 90-diff;
					str.append((char)c);
					System.out.println(c);
				}else if((c-4)>90 && (c-4)<97) {

					c+=22;
					System.out.println(c);
					str.append((char)c);
				}else {
					str.append((char)(c-4));
					System.out.println(c-4);
				}
				c = fr.read();
			}
			JOptionPane.showMessageDialog(null, str.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		}
}
