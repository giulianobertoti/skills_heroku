package hello;

import java.util.List;


public class Question {
	
	private int number;
	private String introduction;
	private String introductionMediaType;
	private String question;
	private List<Answer> answers;
	
	
	
	public Question(int number, String introduction, String introductionMediaType, String question,
			List<Answer> answers) {
		this.number = number;
		this.introduction = introduction;
		this.introductionMediaType = introductionMediaType;
		this.question = question;
		this.answers = answers;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	public String getIntroductionMediaType(){
		return introductionMediaType;
	}
	
	public void setIntroductionMediaType(String introductionMediaType){
		this.introductionMediaType = introductionMediaType;
	}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	
	
}
