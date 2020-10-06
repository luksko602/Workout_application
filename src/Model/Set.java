package Model;

public class Set {
private int weight;
private int reps;

/**
 * 
 * @param weight how much weight the exercise was performed with
 * @param reps how many repetiton the set consist of
 */
public Set(int weight, int reps) {
	this.weight = weight;
	this.reps = reps;
}

public int getWeight() {
	return weight;
}

public void setWeight(int weight) {
	this.weight = weight;
}

public int getReps() {
	return reps;
}

public void setReps(int reps) {
	this.reps = reps;
}


}
