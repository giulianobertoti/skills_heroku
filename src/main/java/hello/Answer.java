package hello;

import java.util.List;


public class Answer {
	
	private int code;
	private String answer;
	private List<Competency> competencies;
	
	
	
	public Answer(int code, String answer, List<Competency> competencies) {

		this.code = code;
		this.answer = answer;
		this.competencies = competencies;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public List<Competency> getCompetencies() {
		return competencies;
	}
	public void setCompetencies(List<Competency> competencies) {
		this.competencies = competencies;
	}

	
	
	
}
