package hello;

import java.util.LinkedList;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Model{
	
	ObjectContainer students = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/students.db4o");
	ObjectContainer questions = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/questions.db4o");
	ObjectContainer competencies = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/competencies.db4o");
	ObjectContainer institutions = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/institutions.db4o");
	ObjectContainer psychologists = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/psychologists.db4o");
	ObjectContainer adms = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/adms.db4o");
	

	
	public boolean addStudent(Student student){
		
		if(isUserAvailable(student.getUserName())){
			List<Competency> studentsCompetencies = new LinkedList<Competency>();
			
			Query query = competencies.query();
			query.constrain(Competency.class);
		    ObjectSet<Competency> allCompetencies = query.execute();
		    
		    for(Competency competency:allCompetencies){
		    	studentsCompetencies.add(competency);
		    }
			
		    student.setCompetencies(studentsCompetencies);
		    
		    
			students.store(student);
			students.commit();
			
			return true;
		}
		
		return false;
		
	}
	
	public boolean addPsychologist(Psychologist psychologist){
		if(isPsychologistUserAvailable(psychologist.getUserName())){
			

		    psychologists.store(psychologist);
		    psychologists.commit();
			
			return true;
		}
		
		return false;
	}
	
	public boolean addADM(ADM adm){
		if(isADMUserAvailable(adm.getUserName())){
			

		    adms.store(adm);
		    adms.commit();
			
			return true;
		}
		
		return false;
	}
	
	public boolean isUserAvailable(String username){
		Query query = students.query();
		query.constrain(Student.class);
	    ObjectSet<Student> allStudents = query.execute();
	    
	    for(Student student:allStudents){
	    	if(student.getUserName().equals(username)) return false;
	    }
	    
	    return true;
	}
	
	public boolean isPsychologistUserAvailable(String username){
		Query query = psychologists.query();
		query.constrain(Psychologist.class);
	    ObjectSet<Psychologist> allPsychologists = query.execute();
	    
	    for(Psychologist psychologist:allPsychologists){
	    	if(psychologist.getUserName().equals(username)) return false;
	    }
	    
	    return true;
	}
	
	public boolean isADMUserAvailable(String username){
		Query query = adms.query();
		query.constrain(ADM.class);
	    ObjectSet<ADM> allADMs = query.execute();
	    
	    for(ADM adm:allADMs){
	    	if(adm.getUserName().equals(username)) return false;
	    }
	    
	    return true;
	}
	
	public void addQuestion(Question question){
		
		Query query = questions.query();
		query.constrain(Question.class);
	    List<Question> allQuestions = query.execute();
	    
	    question.setNumber(allQuestions.size()+1);
		
		
		questions.store(question);
	}
	
	public boolean addCompetency(Competency competency){
		
		if(isCompetencyNameAvailable(competency)){
			competencies.store(competency);
			competencies.commit();
			//competencies.close();
			return true;
		}
	    
	    return false;
		
	}
	
	public boolean isCompetencyNameAvailable(Competency competency){
		Query query = competencies.query();
		query.constrain(Competency.class);
	    List<Competency> allCompetencies = query.execute();
	    
	    for(Competency comp:allCompetencies){
	    	if(comp.getName().toLowerCase().equals(competency.getName().toLowerCase())) return false; 
	    }
	    
	    return true;
	}
	
	public void addInstitution(Institution institution){
		institutions.store(institution);
	}
	
	public boolean addCourse(String institutionName, String courseName){
		
		Query query = institutions.query();
		query.constrain(Institution.class);
	    List<Institution> allInstitutions = query.execute();
	    
	    for(Institution institution:allInstitutions){
	    	if(institution.getInstitutionName().toLowerCase().equals(institutionName.toLowerCase())){
	    		institution.addCourse(courseName);
	    		institutions.store(institution.getCourses());
	    		institutions.commit();
	    		return true;
	    	}
	    }
		return false;
	}
	
	public void deleteCourse(String courseName, String institutionName){
		Query query = institutions.query();
		query.constrain(Institution.class);
	    List<Institution> allInstitutions = query.execute();
		
	    for(Institution institution:allInstitutions){
	    	if(institution.getInstitutionName().toLowerCase().equals(institutionName.toLowerCase())){
				for(Course course:institution.getCourses()){
					if(course.getCourseName().toLowerCase().equals(courseName.toLowerCase())){
						institution.getCourses().remove(course);
						institutions.store(institution.getCourses()); //to update an array in DB4O you must reference it explicitly -> Object.List -> if you reference only the Object like you do with others attributes it does not work
		    			institutions.commit();
						break;
					}
				}
	    		
				
			}
		}
	}
	

	public Student login(String username, String password){
		
		Query query = students.query();
		query.constrain(Student.class);
	    ObjectSet<Student> allStudents = query.execute();
		
	    
	    for(Student student:allStudents){
	    	if(student.getUserName().equals(username) && student.getPassword().equals(password)){
	    		
	    		return student;
	    	}
	    	
	    }
	    
	    return null;

	}
	
	public Psychologist loginPsychologist(String username, String password){
		
		Query query = psychologists.query();
		query.constrain(Psychologist.class);
	    ObjectSet<Psychologist> allPsychologists = query.execute();
		
	    
	    for(Psychologist psychologist:allPsychologists){
	    	if(psychologist.getUserName().equals(username) && psychologist.getPassword().equals(password)){
	    		
	    		return psychologist;
	    	}
	    	
	    }
	    
	    return null;

	}
	
	public ADM loginADM(String username, String password){
		
		Query query = adms.query();
		query.constrain(ADM.class);
	    ObjectSet<ADM> allADMs = query.execute();
		
	    
	    for(ADM adm:allADMs){
	    	if(adm.getUserName().equals(username) && adm.getPassword().equals(password)){
	    		
	    		return adm;
	    	}
	    	
	    }
	    
	    return null;

	}
	
	public Student searchStudentbyRA(int ra){
		
		
		Query query = students.query();
		query.constrain(Student.class);
	    ObjectSet<Student> allStudents = query.execute();
		
	    for(Student student:allStudents){
	    	if(student.getRa()==ra){
	    		return student;
	    	}
	    	
	    }
	    
	    return null;

		
	}
	
	public Question searchQuestionByCode(int code){
		
		Query query = questions.query();
		query.constrain(Question.class);
	    ObjectSet<Question> allQuestions = query.execute();
		
	    for(Question question:allQuestions){
	    	if(question.getNumber() == code){
	    		return question;
	    	}
	    	
	    }
	    
	    return null;
		
	}
	

	public List<Student> searchStudentsByInstitutionCourseYearPeriod(String institution, String course, int year, int period){
		
		List<Student> result = new LinkedList<Student>();
		
		Query query = students.query();
		query.constrain(Student.class);
	    ObjectSet<Student> allStudents = query.execute();
		
	    for(Student student:allStudents){
	    	if(student.getInstitution().equals(institution) && student.getCourse().equals(course) && student.getYear()==year && student.getPeriod()==period) result.add(student);
	    
	    }
		
		return result;
		
	}
	
	
	public int recordAnswer(int ra, int questionNumber, int answerCode){
		
		
		
		Query queryStudents = students.query();
		queryStudents.constrain(Student.class);
	    ObjectSet<Student> allStudents = queryStudents.execute();
	    
	    Query queryQuestions = questions.query();
		queryQuestions.constrain(Question.class);
	    ObjectSet<Question> allQuestions = queryQuestions.execute();
		
	    for(Student student:allStudents){
	    	if(student.getRa()==ra){
	    		student.setQuestion(student.getQuestion()+1);
	    		for(Question question:allQuestions){
	    			if(question.getNumber()==questionNumber){
	    				for(Answer answer: question.getAnswers()){
	    					for(Competency competency:answer.getCompetencies()){
	    						for(Competency studentCompetency:student.getCompetencies()){
	    							if(studentCompetency.getName().equals(competency.getName())){
	    								studentCompetency.setValue(studentCompetency.getValue()+competency.getValue());
	    								students.store(student.getCompetencies()); //to update an array in DB4O you must reference it explicitly -> Object.List -> if you reference only the Object like you do with others attributes it does not work
	    				    			students.commit();
	    							}
	    						}
	    						
	    						
	    					}
	    				}
	    					
	    			}
	    		}
	    		
	    		
	    		if(allQuestions.toArray().length < student.getQuestion()){
	    			student.setCompleted(true);
	    			students.store(student);
	    			students.commit();
	    			
	    			
	    			
	    			
	    			return 1;
	    		} else {
	    			
	    			return 0; //continua
	    		}
	    		
	    	}
	    	
	    	
	    	
	    }
		
		
	    
	    
	    return 0;
	    
	    
	}
	
	
	public List<Institution> getAllInstitutions(){
		
		Query query = institutions.query();
		query.constrain(Institution.class);
	    List<Institution> allInstitutions = query.execute();
	    
	    return allInstitutions;
		
	}
	
	public List<Course> getCourses(String institutionName){
		
		Query query = institutions.query();
		query.constrain(Institution.class);
	    List<Institution> allInstitutions = query.execute();
	    
	    for(Institution institution:allInstitutions){
	    	if(institution.getInstitutionName().equals(institutionName)){
	    		return institution.getCourses();
	    	}
	    }
	    
	    return null;
	    
	}
	
	public boolean setComment(int ra, String comment){
		
		
		Query query = students.query();
		query.constrain(Student.class);
	    ObjectSet<Student> allStudents = query.execute();
		
	    for(Student student:allStudents){
	    	if(student.getRa()==ra){
	    		student.setPsychologistComment(comment);
	    		student.setStatusComment(true);
	    		students.store(student);
	    		students.commit();
	    		return true;
	    	}
	    	
	    }
	    
		return false;
	}
	


	public List<Competency> getAllCompetencies(){
	
		Query query = competencies.query();
		query.constrain(Competency.class);
		List<Competency> allCompetencies = query.execute();

		return allCompetencies;
    
	}
	
	public List<Question> getAllQuestions(){
		
		Query query = questions.query();
		//query.constrain(Question.class);
		query.descend("number").orderAscending();
		List<Question> allQuestions = query.execute();

		return allQuestions;
    
	}
	
	public void deleteQuestion(int number){
		Query query = questions.query();
		query.constrain(Question.class);
		List<Question> allQuestions = query.execute();
		
		for(Question question:allQuestions){
			if(question.getNumber()==number){
				questions.delete(question);
				questions.commit();
				for(Question q:allQuestions){
					if(q.getNumber()>=number){
						q.setNumber(q.getNumber()-1);
						questions.store(q);
						questions.commit();
					}
				}
				break;
			}
		}
	}
	
	
	public void deleteCompetency(String competencyName){
		Query query = competencies.query();
		query.constrain(Competency.class);
		List<Competency> allCompetencies = query.execute();
		
		for(Competency competency:allCompetencies){
			if(competency.getName().toLowerCase().equals(competencyName.toLowerCase())){
				competencies.delete(competency);
				competencies.commit();
				break;
			}
		}
	}
	
}
