package hello;

public class Competency {
	
	private String name;
	private int value;
	
	public Competency(String name){
		this.name = name;
		this.value = 0;
	}
	
	public Competency(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	

}
