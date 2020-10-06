package Model;

import java.util.ArrayList;

public class Member {
private String username;
private String firstname;
private String lastname;
private int age;
private String email;
private ArrayList<Exercise> excercises;

/**
 * 
 * @param username The unique identifier for the account
 * @param firstname
 * @param lastname
 * @param age
 * @param email
 */
public Member(String username, String firstname, String lastname, int age, String email) {
	this.username = username;
	this.firstname = firstname;
	this.lastname = lastname;
	this.age = age;
	this.email = email;
}

public String getFirstName() {
	return firstname;
}

public void setFirstName(String firstname) {
	this.firstname = firstname;
}

public String getLastName() {
	return lastname;
}

public void setLastName(String lastname) {
	this.lastname = lastname;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getusername() {
	return username;
}

public String toString() {
return username +" " + firstname + " " + lastname + " " + age + " "+ email;
	
}

}
