package Model;

import java.util.ArrayList;

public class Exercise {
private char type;
private String name;
private String description;
private ArrayList<Set> totalSets;

/**
 * 
 * @param type What type of exercise, S - strength, H - hypertrophy, O - other
 * @param name 
 */
public Exercise(char type, String name) {
	this.type = type;
	this.name = name;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public char getType() {
	return type;
}

public void setType(char type) {
	this.type = type;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
	

}
