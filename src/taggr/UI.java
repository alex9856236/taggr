package taggr;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField accountTxtField;
	private JTextField passwordTxtField;
	JLabel textArea_1 = new JLabel();
	JButton btnNewButton_1 = new JButton("\u767B\u5165");
	JButton btnNewButton = new JButton("\u7B2C\u4E00\u6B21\u767B\u5165");

	static UI frame = new UI();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel textArea_1 = new JLabel();
		textArea_1.setBounds(125, 165, 118, 23);
		contentPane.add(textArea_1);
		
		JLabel lblNewLabel = new JLabel("\u4F7F\u7528\u8005\u767B\u5165");
		lblNewLabel.setFont(new Font("·s²Ó©úÅé", Font.PLAIN, 18));
		lblNewLabel.setBounds(137, 20, 90, 23);
		contentPane.add(lblNewLabel);
		
		JLabel accountLabel = new JLabel("\u5E33\u865F");
		accountLabel.setBounds(88, 60, 46, 15);
		contentPane.add(accountLabel);
		
		JLabel passwordLabel = new JLabel("\u5BC6\u78BC");
		passwordLabel.setBounds(88, 95, 46, 15);
		contentPane.add(passwordLabel);
		
		accountTxtField = new JTextField();
		accountTxtField.setBounds(144, 57, 111, 21);
		contentPane.add(accountTxtField);
		accountTxtField.setColumns(10);
		
		passwordTxtField = new JTextField();
		passwordTxtField.setBounds(144, 92, 111, 21);
		contentPane.add(passwordTxtField);
		passwordTxtField.setColumns(10);
		
		JRadioButton fileManagerRdButton = new JRadioButton("\u6A94\u6848\u7BA1\u7406\u54E1");
		fileManagerRdButton.setBounds(83, 130, 107, 23);
		contentPane.add(fileManagerRdButton);
		
		JRadioButton programmerRdButton = new JRadioButton("\u8A2D\u8A08\u5E2B");
		programmerRdButton.setBounds(191, 130, 107, 23);
		contentPane.add(programmerRdButton);
		
		JButton firstLogButton = new JButton("\u7B2C\u4E00\u6B21\u767B\u5165");
		firstLogButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UI1.frame1.setVisible(true);
				UI.this.dispose();
				
				}
			
		});
		
		firstLogButton.setBounds(65, 198, 100, 23);
		contentPane.add(firstLogButton);
		
		JButton loginButton = new JButton("\u767B\u5165");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(accountTxtField.getText().equals("group") && passwordTxtField.getText().equals("abc")){
					UI1.frame1.setVisible(true);
					UI.this.dispose();
					System.out.print("login button pressed");
				}else{
					textArea_1.setText("not possible ");
					
				}
			}
		});
		loginButton.setBounds(191, 198, 107, 23);
		contentPane.add(loginButton);
	}	
	
}

