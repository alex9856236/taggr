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
		// TODO Auto-generated method stub
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

	}
	
	public static void actionPerformed(int num){
		//Handle open button
		System.out.println("Entered actionPerformed");
		if(num < 5){
			System.out.println("Entered if");
//			int returnVal = fileChooser.showOpenDialog(MainActivity.this);
			int returnVal = fileChooser.showOpenDialog(fileChooser);
			
			if(returnVal == JFileChooser.APPROVE_OPTION){
				System.out.println("Entered second if");
				File file = fileChooser.getSelectedFile();
				long time = System.currentTimeMillis();
				String s;
				
				logger.info("Abs path: " + file.getAbsolutePath());
				logger.info("Name: " + file.getName());
				logger.info("Hash code: " + file.hashCode());
				s = String.valueOf(file.lastModified());
				logger.info(s);
				logger.info("Time: " + time);
				
				System.out.println("Abs path: " + file.getAbsolutePath());
				System.out.println("Name: " + file.getName());
				System.out.println("Hash code: " + file.hashCode());
				System.out.println(file.setLastModified(time));
				System.out.println("Time: " + time);
				
			} else {
				System.out.println("Action cancelled by user.");
			}
		}else{
			System.out.print("else");
		}
	}

}
