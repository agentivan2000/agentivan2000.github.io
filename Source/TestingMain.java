import java.util.*;

public class TestingMain {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String[] user_input = input.next().split(",");	
		String user = user_input[0];
		String pass = user_input[1];

		Student new_student = new Student(user);

		if(!new_student.authentication(user,pass)) {
			System.out.println("Wrong Username/Password combination. Please try again or reset your password.");
			System.exit(0);
		}
		input.close();
		
		System.out.print(new_student.getFirstName()+","+new_student.getLastName());
		
		//String[] list = {"sdfsfds","sdfds","4534","323rr"};
		//new_student.saveDetails(list,"students_details.txt");
	}	
}
