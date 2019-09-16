package gui;

public class Zombie {
	
	private int overallBrains;
	
	private int id;
	
	public Zombie() {}
	
	public Zombie(int index, int brains) {
		overallBrains = brains;
		id = index;
	}
	
	public void setBrains(int numBrains) {
		overallBrains = numBrains;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public int getBrains() {
		return overallBrains;
	}
	public int getID() {
		return id;
	}
	
	public void print() {
		System.out.println(overallBrains);
		System.out.println(id);
	}
}