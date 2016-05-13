package hello;



import java.util.LinkedList;
import java.util.List;

public class Student {
	
	private String userName;
	private String password;
	private String name;
	private int ra;
	private String institution;
	private String course;
	private int year;
	private int period;
	private List<Competency> competencies;
	private int question;
	private boolean completed;
	private String psychologistComment;
	private boolean statusComment;
	
	public Student(String userName, String password, String name, int ra,
			String institution, String course, int year, int period) {

		this.userName = userName;
		this.password = password;
		this.name = name;
		this.ra = ra;
		this.institution = institution;
		this.course = course;
		this.year = year;
		this.period = period;
		this.competencies = new LinkedList<Competency>();
		this.question = 1;
		this.completed = false;
		this.psychologistComment = "";
		this.statusComment = false;
		
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getRa() {
		return ra;
	}


	public void setRa(int ra) {
		this.ra = ra;
	}


	public String getInstitution() {
		return institution;
	}


	public void setInstitution(String institution) {
		this.institution = institution;
	}


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public int getPeriod() {
		return period;
	}


	public void setPeriod(int period) {
		this.period = period;
	}


	public List<Competency> getCompetencies() {
		return competencies;
	}


	public void setCompetencies(List<Competency> competencies) {
		this.competencies = competencies;
	}
	
	
	public int getQuestion(){
		return question;
	}
	
	public void setQuestion(int question){
		this.question = question;
	}

	public boolean getCompleted(){
		return completed;
	}
	
	public void setCompleted(boolean completed){
		this.completed = completed;
	}


	public String getPsychologistComment() {
		return psychologistComment;
	}


	public void setPsychologistComment(String psychologistComment) {
		this.psychologistComment = psychologistComment;
	}


	public boolean getStatusComment() {
		return statusComment;
	}


	public void setStatusComment(boolean statusComment) {
		this.statusComment = statusComment;
	}
	
	
	
	
	
}
