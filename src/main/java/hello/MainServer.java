package hello;

import static spark.Spark.*;




import java.util.LinkedList;
import java.util.List;



public class MainServer {

	final static Model model = new Model();

    public static void main(String[] args) {

		// Get port config of heroku on environment variable
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 8080;
        }
        port(port);

		
        
        initializeModel();
		
        
		
		staticFileLocation("/static");
		
		REST controller = new REST(model); 
		
		
		controller.getLogin();
		controller.getStudentsQuestionbyRA();
		controller.getStudentCompetencies();
		controller.getQuestionByNumber();
		controller.getStudentsbyInstitutionCourseYearPeriod();
		controller.setAnswerbyCode();
		controller.getAllInstitutions();
		controller.getCourses();
		controller.setComments();
		controller.getAllCompetencies();
		controller.setQuestion();
		controller.getAllQuestions();
		controller.deleteQuestion();
		controller.setStudent();
		controller.loginPsychologist();
		controller.setNewCompetency();
		controller.deleteCompetency();
		controller.setNewCourse();
		controller.deleteCourse();
		controller.loginADM();
		controller.setPsychologist();
		controller.setADM();
    }
	
    public static void initializeModel(){
		
    	model.addADM(new ADM("adm@adm.com", "12345", "João", "Fatec"));
        Institution fatecsjc = new Institution("fatecsjc");
		Institution fatecmarilia = new Institution("fatecmarilia");
		model.addInstitution(fatecsjc);
		model.addInstitution(fatecmarilia);
    	
		
		fatecsjc.addCourse("bd");
		fatecsjc.addCourse("ads");
		
		fatecmarilia.addCourse("bd");
		fatecmarilia.addCourse("aeronautica");
		
		model.addADM(new ADM("adm@adm.com", "12345", "João", "Fatec"));
		
		model.addInstitution(fatecsjc);
		model.addInstitution(fatecmarilia);
		
		model.addCompetency(new Competency("resiliencia"));
		model.addCompetency(new Competency("esforco"));
		model.addCompetency(new Competency("concentracao"));
		
		model.addStudent(new Student("joao@gmail.com", "12345", "Joao", 1111, "fatecsjc", "bd" ,2016, 1));
		model.addStudent(new Student("lilian@gmail.com", "12345", "Lilian", 2222, "fatecsjc", "bd", 2016, 1));
		model.addStudent(new Student("giuliano@gmail.com", "12345", "Giuliano", 3333, "fatecsjc", "bd", 2016, 1));
		
		model.addPsychologist(new Psychologist("marilia@gmail.com", "12345", "Marilia Bertoti", "Fatec SJC"));
		
		
		//adicionando a questao 1
		
		List<Competency> competencies1 = new LinkedList<Competency>();
		Competency comp1 = new Competency("resiliencia", 5);
		Competency comp2 = new Competency("esforco", 3);
		competencies1.add(comp1);
		competencies1.add(comp2);
		
		List<Answer> answers = new LinkedList<Answer>();
		Answer answersA = new Answer(1, "Interface Gráfica", competencies1);
		answers.add(answersA);
		
		List<Competency> competencies2 = new LinkedList<Competency>();
		Competency comp3 = new Competency("leadership", 0);
		Competency comp4 = new Competency("workGroup", 0);
		competencies2.add(comp3);
		competencies2.add(comp4);
		
		Answer answersB = new Answer(2, "Interface Linha de Comando", competencies2);
		answers.add(answersB);
		
		List<Competency> competencies3 = new LinkedList<Competency>();
		Competency comp5 = new Competency("leadership", 10);
		Competency comp6 = new Competency("workGroup", 10);
		Competency comp7 = new Competency("communication", 10);
		competencies3.add(comp5);
		competencies3.add(comp6);
		competencies3.add(comp7);
		
		Answer answersC = new Answer(3, "Interface Natural", competencies3);
		answers.add(answersC);
		
		List<Competency> competencies4 = new LinkedList<Competency>();
		Competency comp8 = new Competency("leadership", 0);
		competencies4.add(comp8);
		
		Answer answersD = new Answer(4, "Interface Orgânica", competencies4);
		answers.add(answersD);
		
		model.addQuestion(new Question(2, "http://giulianobertoti.github.io/assets/img/user.png", "video", "Qual é este tipo de Interação Humano Computador", answers));
	
		
		//adicionando a questao 2
		
		List<Competency> competencies5 = new LinkedList<Competency>();
		Competency comp9 = new Competency("leadership", 1);
		Competency comp10 = new Competency("workGroup", 3);
		competencies5.add(comp9);
		competencies5.add(comp10);
				
		List<Answer> answers_2 = new LinkedList<Answer>();
		Answer answersA_2 = new Answer(1, "Acelerômetro", competencies5);
		answers_2.add(answersA_2);
				
		List<Competency> competencies6 = new LinkedList<Competency>();
		Competency comp11 = new Competency("resiliencia", 5);
		Competency comp12 = new Competency("esforco", 3);
		competencies6.add(comp11);
		competencies6.add(comp12);
				
		Answer answersB_2 = new Answer(2, "Câmera", competencies6);
		answers_2.add(answersB_2);
			
		List<Competency> competencies7 = new LinkedList<Competency>();
		Competency comp13 = new Competency("leadership", 10);
		Competency comp14 = new Competency("workGroup", 10);
		Competency comp15 = new Competency("communication", 10);
		competencies7.add(comp13);
		competencies7.add(comp14);
		competencies7.add(comp15);
			
		Answer answersC_2= new Answer(3, "GPS", competencies7);
		answers_2.add(answersC_2);
			
		List<Competency> competencies8 = new LinkedList<Competency>();
		Competency comp16 = new Competency("leadership", 0);
		competencies8.add(comp16);
			
		Answer answersD_2 = new Answer(4, "Touch", competencies8);
		answers_2.add(answersD_2);
			
		model.addQuestion(new Question(1, "https://www.youtube.com/embed/JLQtIR_IFnQ", "video", "Qual sensor está sendo usado para esta Interação Humano Computador", answers_2));
		
		
	}
	
}
