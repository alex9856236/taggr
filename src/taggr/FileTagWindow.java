package taggr;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Font;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.JLabel;
import javax.swing.DropMode;

public class FileTagWindow {

	//Globals
	private JFrame frame;
	private JTextField addNewTagTxtField;
	private final Action action = new SwingAction();
	String newTag;
	//database connection
	DBConnection dbconnect = new DBConnection();
	//Filechooser
	final static JFileChooser fileChooser = new JFileChooser();
	static FileHandler fh;
	//Make the logger global to access it everywhere
	static Logger logger = Logger.getLogger("MyLog");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
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
				
				try {
					FileTagWindow window = new FileTagWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FileTagWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.getContentPane().setLayout(null);
		
		addNewTagTxtField = new JTextField();
		addNewTagTxtField.setLocation(64, 34);
		frame.getContentPane().add(addNewTagTxtField);
		addNewTagTxtField.setColumns(10);
		addNewTagTxtField.setSize(168, 37);
		
		newTag = addNewTagTxtField.getText();
		
//	"addNewTagButton" starts here			
		JButton addNewTagButton = new JButton("+");
		addNewTagButton.addActionListener(new ActionListener() {
			//The + button has been pressed, add the newTag to our database
			public void actionPerformed(ActionEvent arg0) {
				try {
					//send newTag string to dbconnect and add it to the database
					dbconnect.addNewTag(newTag);
					//print all tags
					dbconnect.getAllTags();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}
		});
		addNewTagButton.setAction(action);
		addNewTagButton.setBounds(10, 33, 55, 38);
		frame.getContentPane().add(addNewTagButton);
//		"addNewTagButton" ends here
		
		final JTextPane showTagNamesTxtPane = new JTextPane();
		showTagNamesTxtPane.setFont(new Font("Tahoma", Font.PLAIN, 12));
		showTagNamesTxtPane.setBounds(10, 184, 721, 279);
		frame.getContentPane().add(showTagNamesTxtPane);
		
//	"addNewFileButton" starts here
		//Button to add a new file into taggr
		JButton addNewFileButton = new JButton("+");
		//If the + to add files is clicked
		addNewFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Open the filechooser

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
						
						//Print the file's info to the table
						
						showTagNamesTxtPane.setText("Abs path: " + files[i].getAbsolutePath() + "\nName: " + files[i].getName() + "\nHash code: " + files[i].hashCode());
						
						System.out.println("Abs path: " + files[i].getAbsolutePath());
						System.out.println("Name: " + files[i].getName());
						System.out.println("Hash code: " + files[i].hashCode());
						//System.out.println(files[i].setLastModified(time));
						System.out.println("Time: " + time);
					}
					
					
				} else {
					System.out.println("Action cancelled by user.");
				}
			}
		});
		addNewFileButton.setBounds(10, 116, 55, 38);
		frame.getContentPane().add(addNewFileButton);
//	"addNewFileButton" starts here
		
// "lblTags" starts here
		JLabel lblTags = new JLabel("Tags");
		lblTags.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTags.setBounds(10, 11, 48, 22);
		frame.getContentPane().add(lblTags);
		
		JLabel lblAddFiles = new JLabel("Add New File(s)");
		lblAddFiles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddFiles.setBounds(10, 83, 156, 22);
		frame.getContentPane().add(lblAddFiles);
// "lblTags" ends here
		
		//Frame bounds
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "+");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
