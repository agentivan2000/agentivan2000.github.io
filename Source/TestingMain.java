//Use imwanja,12345x as username,password to test the code. 

import java.awt.EventQueue;
//import java.io.*;
import java.util.*;

public class TestingMain {

	public static void main(String[] args) {
		try
		{
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						LogInScreen window = new LogInScreen();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
			Scanner input = new Scanner(System.in);
			String[] user_input = input.next().split(",");	
			String user = user_input[0];
			String pass = user_input[1];

			Student new_student = new Student(user);

			//testing the sign in process
			if(!new_student.authentication(user,pass)) {
				System.out.println("Wrong Username/Password combination. Please try again or reset your password.");
				System.exit(0);
			}
			input.close();

			System.out.println(new_student.getFirstName()+","+new_student.getLastName()+","+new_student.getStudentId());

			Course c = new Course(new_student);

			//registering for a course

			int x = c.register("2017X01");
			if (x == 0) {
				System.out.println("Successfully Registered");
			} else if (x == 1) {
				System.out.println("You are already registered");
			} else {
				System.out.println("Sorry. The class is already full. Please try again next term.");
			}


			//unregistering for a course

			int x1 = c.unRegister("2017Xcc01");
			if (x1 == 0) {
				System.out.println("Successfully UnRegistered");
			} else {
				System.out.println("You are Not Registered for this course.");
			} 

			//String[] list = {"sdfsfds","sdfds","4534","323rr"};
			//new_student.saveDetails(list,"students_details.txt");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}	
}
