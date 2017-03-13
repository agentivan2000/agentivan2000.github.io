import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.FlowLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JEditorPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LogInScreen {

	private JFrame frmTeamdCourseRegistration;
	private JPasswordField passwordField;
	private JLabel lblUserName;
	private Student new_student;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInScreen window = new LogInScreen();
					window.frmTeamdCourseRegistration.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogInScreen() {
		initialize();
	}

	public LogInScreen(Student student){
		new_student = new Student(textPane.getText());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTeamdCourseRegistration = new JFrame();
		frmTeamdCourseRegistration.setTitle("TeamD: Course Registration System");
		frmTeamdCourseRegistration.setBounds(100, 100, 754, 445);
		frmTeamdCourseRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTeamdCourseRegistration.getContentPane().setLayout(null);

		JLabel lblPleaseEnterYour = new JLabel("Please Enter Your Log In Details");
		lblPleaseEnterYour.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPleaseEnterYour.setBounds(10, 11, 313, 32);
		frmTeamdCourseRegistration.getContentPane().add(lblPleaseEnterYour);

		lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(45, 127, 89, 32);
		frmTeamdCourseRegistration.getContentPane().add(lblUserName);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(45, 170, 89, 50);
		frmTeamdCourseRegistration.getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(164, 172, 333, 32);
		frmTeamdCourseRegistration.getContentPane().add(passwordField);

		textPane = new JTextPane();
		textPane.setBounds(164, 127, 333, 32);
		frmTeamdCourseRegistration.getContentPane().add(textPane);

		JButton btnSubmit = new JButton("Log In");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new_student = new Student(textPane.getText());
				
				String userName = textPane.getText().trim();//
				String password = passwordField.getText().trim();

				if(!new_student.authentication(userName,password)) {
					JOptionPane.showMessageDialog(null,"Wrong Username/Password combination. Please try again or reset your password.");
				} else JOptionPane.showMessageDialog(null,"You've Successfully Logged In.");
			}
		});
		btnSubmit.setBounds(56, 266, 89, 23);
		frmTeamdCourseRegistration.getContentPane().add(btnSubmit);

		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Time to register..");
			}
		});
		btnNewButton.setBounds(56, 324, 89, 23);
		frmTeamdCourseRegistration.getContentPane().add(btnNewButton);
	}
}
