package taggr;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
//import javax.swing.SwingConstants;


public class UI1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	//private JTable filesAndTagsTable;
	static UI1 frame1 = new UI1();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
						
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame1.setVisible(true);
					
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI1() {
		this.setSize(200, 200);
		
		setFont(new Font("Consolas", Font.PLAIN, 14));
		setTitle("Taggr");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 632);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("file");
		lblNewLabel.setFont(new Font("·s²Ó©úÅé", Font.PLAIN, 16));
		lblNewLabel.setBounds(23, 22, 46, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(46, 20, 96, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u641C\u5C0B");
		btnNewButton.setBounds(33, 63, 87, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u7DE8\u8F2F");
		btnNewButton_1.setBounds(33, 96, 87, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u79FB\u9664\u6A19\u7C64");
		btnNewButton_2.setBounds(33, 129, 87, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u8B8A\u66F4\u76EE\u9304");
		btnNewButton_3.setBounds(33, 162, 87, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u79FB\u9664\u8A18\u9304");
		btnNewButton_4.setBounds(33, 195, 87, 23);
		contentPane.add(btnNewButton_4);
		
		/*
		table = new JTable();
		table.setBounds(166, 31, 308, 187);
		contentPane.add(table);
		*/
		//filesAndTagsTable = createTable(new GradesModel());
		
		JLabel label = new JLabel("\u6A94\u6848\u8DEF\u5F91");
		label.setBounds(176, 10, 57, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u6A19\u7C64");
		label_1.setBounds(309, 10, 46, 15);
		contentPane.add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u72C0\u614B");
		lblNewLabel_1.setBounds(428, 10, 46, 15);
		contentPane.add(lblNewLabel_1);
	}
}
