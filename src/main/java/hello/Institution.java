package hello;

import java.util.LinkedList;
import java.util.List;

public class Institution {
	
	private String institutionName;
	private List<Course> courses = new LinkedList<Course>();
	

	public Institution(String name) {
		this.institutionName = name;
	}



	public String getInstitutionName() {
		return institutionName;
	}



	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	
	

	public List<Course> getCourses() {
		return courses;
	}



	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}



	public void addCourse(String courseName){
		courses.add(new Course(courseName));
	}


}
