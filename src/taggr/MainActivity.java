package taggr;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.JFileChooser;

public class MainActivity {
	final static JFileChooser fileChooser = new JFileChooser();
	static //Make the logger global to access it everywhere
	Logger logger = Logger.getLogger("MyLog");
	static FileHandler fh;

	public static void main(String[] args) {

		try{
			if((fh = new FileHandler("C:/Temp/MyLogFile.log")) == null)
				System.out.println("File not found");
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			
			//first log message
			logger.info("My first log");
			
		} catch(SecurityException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		};
		
		Scanner input = new Scanner(System.in);
		int num;
		boolean flag = false;
		do{
			System.out.print("Number> ");
			num = input.nextInt();
			actionPerformed(num);
			if(num < 5)
				flag = true;
			else
				flag = false;
		} while(flag);

		input.close();
	}
	
	public static void actionPerformed(int num){
		//Handle open button
		System.out.println("Entered actionPerformed");
		if(num < 5){
			//System.out.println("Entered if");

			//Set the fileChooser's multiSelect to true
			fileChooser.setMultiSelectionEnabled(true);
			
			//Show the dialog; wait until dialog is closed
			int returnVal = fileChooser.showOpenDialog(fileChooser);

			//Retrieve the selected files
			File[] files = fileChooser.getSelectedFiles();

			if(returnVal == JFileChooser.APPROVE_OPTION){
				//System.out.println("Entered second if");
				long time = System.currentTimeMillis();
				
				for(int i = 0; i < fileChooser.getSelectedFiles().length; i++){
					logger.info("Abs path: " + files[i].getAbsolutePath());
					logger.info("Name: " + files[i].getName());
					logger.info("Hash code: " + files[i].hashCode());
					//s = String.valueOf(file.lastModified());
					//logger.info(s);
					logger.info("Time: " + time);
					
					System.out.println("Abs path: " + files[i].getAbsolutePath());
					System.out.println("Name: " + files[i].getName());
					System.out.println("Hash code: " + files[i].hashCode());
					//System.out.println(files[i].setLastModified(time));
					System.out.println("Time: " + time);
				}
				
				
			} else {
				System.out.println("Action cancelled by user.");
			}
		}else{
			System.out.print("else");
		}
	}

}
