import java.io.*;
import java.io.IOException;
import java.util.*;

public class Student {
	private boolean authenticated = false;
	private String userName;
	private int password;
	private String studentId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String dateOfBirth;

	public Student() {
	}

	public Student(String user) {
		userName = user;
	}

	public void signUp(String[] registrationDetails) throws Exception{
		studentId = registrationDetails[0];
		firstName = registrationDetails[1];
		middleName = registrationDetails[2];
		lastName = registrationDetails[3];
		dateOfBirth = registrationDetails[4];
		userName = registrationDetails[5];
		password = registrationDetails[6].hashCode() * registrationDetails[5].hashCode();
		
		String[] students_details = {this.studentId,this.firstName,this.middleName,this.lastName,this.dateOfBirth};
		saveDetails(students_details,"students_details.txt");
			
		String[] authentication_details = {this.userName,this.password + "",this.studentId};
		saveDetails(authentication_details,"authentication.txt");
	}

	public void setStudent(String id, String fn, String mn, String ln, String dob) {
		studentId = id;
		firstName = fn;
		middleName = mn;
		lastName = ln;
		dateOfBirth = dob;
	}

	public String getStudentId() {
		return studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public boolean authentication(String user, String pass) {

		try {
			int loginhash = user.hashCode() * pass.hashCode();
			String login = loginhash+"";
			
			Scanner scan = new Scanner(new File("authentication.txt"));
			boolean stoploop = false;

			do {
				String[] inline = scan.nextLine().split(",");
				
				if (login.equals(inline[1])) {
					setStudentDetails(userName,login);
					authenticated = true;
					stoploop = true;
				}

			} while (scan.hasNext() && stoploop == false);

			scan.close();
		} catch (IOException ex) {
			System.out.println(ex);
		}
		return authenticated;
	}

	private void setStudentDetails(String user, String login) {
		try {
			File student_auth = new File("authentication.txt");
			Scanner scanner1 = new Scanner(student_auth);

			boolean end_loop1 = false;

			while (scanner1.hasNext() && end_loop1 == false) {
				String input_list = scanner1.nextLine();
				if (input_list.contains(user) && input_list.contains(login)) {
					String[] student_auth_array = input_list.split(",");
					studentId = student_auth_array[2];
					end_loop1 = true;
				}
			}
			scanner1.close();
			
			File student_details = new File("students_details.txt");
			Scanner scanner = new Scanner(student_details);
			
			boolean end_loop = false;

			while (scanner.hasNext() && end_loop == false) {
				String input_list = scanner.nextLine();
				if (input_list.contains(user) && input_list.contains(studentId)) {
					String[] student_records = input_list.split(",");

					studentId = student_records[1];
					firstName = student_records[2];
					middleName = student_records[3];
					lastName = student_records[4];
					dateOfBirth = student_records[5];
					end_loop = true;
				}
			}
			scanner.close();
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	public void saveDetails(String[] new_input,
			String fileName ) {
		try {
			String[] possibleFileNames = { "students_details.txt", "authentication.txt", "availableCourses.txt",
					"coursesRegisteredFor.txt" };

			if (Arrays.asList(possibleFileNames).contains(fileName)) {
				File student_details = new File(fileName);

				if (!student_details.exists()) {
					student_details.createNewFile();
				}

				// Append records to an existing file rather than overwrite it.
				FileWriter fw = new FileWriter(student_details, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw);

				out.print(new_input[0]);

				for (int i = 1; i < new_input.length; i++) {
					out.print("," + new_input[i]);
				}
				out.print("\n");
				out.close();
			}
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}
}
