package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DirectoryIterator {
	public static void main(String[] args) {
		/* 
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
//		JFileChooser jfc = new JFileChooser();
//		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//		int returnVal = jfc.showOpenDialog(null);
//		if (returnVal == JFileChooser.APPROVE_OPTION) {
//			File directory = jfc.getSelectedFile();
//			File[] files = directory.listFiles();
//			if(files != null) {
//				for(File f : files) {
//				  System.out.println(f.getAbsolutePath());
//			}
//			}
//		} 
		
		/*
		 * Your task is to write a program that iterates through the src folder of this current Java Project. 
		 * For every .java file it finds, the program will add a (non-legally binding) copyright statement at the bottom.
		 * Be aware of possible directories inside of directories.
		 * (e.g //Copyright © 2019 FirstName LastName)
		 */
		
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		System.out.println(jfc.getCurrentDirectory());
	int i = jfc.getCurrentDirectory().toString().indexOf("src");
	String str = jfc.getCurrentDirectory().toString().substring(0, i+3);	
		System.out.println(str);
		jfc = new JFileChooser(str);
		File src = jfc.getCurrentDirectory();
			File[] files = src.listFiles();
			if(files != null) {
				for(File f : files)	{
					System.out.println(f.getName());
					String[] fFiles = f.list();
					for(String s : fFiles) {
						System.out.println("src/"+f.getName()+"/"+s);
						if(s.endsWith(".java")) {
							try {
						FileWriter fw = new FileWriter("src/"+f.getName()+"/"+s, true);					
							fw.write("\n//Copyright © 2023 Ashay M");						
							fw.close();
							System.out.println("Writing in "+s);
						} catch (IOException e) {
							e.printStackTrace();
	
					}

					}
					
					}
				}
	}
}
}
}

//Copyright © 2023 Ashay M

//Copyright © 2023 Ashay M
// Only one Copyright © 2023 Ashay M
// Only one Copyright © 2023 Ashay M