package Controller;

import java.sql.*;
import java.util.ArrayList;
import Model.Exercise;
import Model.Member;
import Model.Set;

public class DatabaseController {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "luksok8";
	private static final String URL = "jdbc:mysql://localhost:3306/mytrainingapp?useTimezone=true&serverTimezone=UTC";

	private PreparedStatement getAllMembers;
	private PreparedStatement deleteMember;
	private PreparedStatement addMember;

	private Connection myConn;

	public DatabaseController() {
		try {
			myConn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			getAllMembers = myConn.prepareStatement("SELECT * FROM appmember");

			addMember = myConn.prepareStatement("INSERT INTO appmember VALUES (?, ?, ?, ?, ?)");

			deleteMember = myConn.prepareStatement("DELETE FROM appmember WHERE (userName = ?)");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Member> getAllMembers() {
		ArrayList<Member> members = new ArrayList<Member>();
		try {
			ResultSet myRs = getAllMembers.executeQuery();

			while (myRs.next()) {
				members.add(new Member(myRs.getString("username"), myRs.getString("firstName"),
						myRs.getString("lastName"), myRs.getInt("age"), myRs.getString("email")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return members;
	}

	public void deleteMember(String username) {
		try {
			deleteMember.setString(1, username);
			deleteMember.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addMember(String username, String firstName, String lastName, int age, String email) {
		try {

			addMember.setString(1, username);
			addMember.setString(2, firstName);
			addMember.setString(3, lastName);
			addMember.setInt(4, age);
			addMember.setString(5, email);

			addMember.executeUpdate();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
