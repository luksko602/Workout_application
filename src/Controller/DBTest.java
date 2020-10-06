package Controller;

import java.util.ArrayList;
import Model.Member;

public class DBTest {

	public static void main(String[] args) {
		
		DatabaseController db = new DatabaseController();
		
		ArrayList<Member> test = db.getAllMembers();
		test.forEach((n) -> System.out.println(n.toString()));
		System.out.println();
		
		db.addMember("hej2", "niklas", "person", 34, "asdasdf");
		test = db.getAllMembers();
		test.forEach((n) -> System.out.println(n.toString()));
		System.out.println();
		
		db.deleteMember("hej2");
		test = db.getAllMembers();
		test.forEach((n) -> System.out.println(n.toString()));
		System.out.println();
		
	}
	
}
