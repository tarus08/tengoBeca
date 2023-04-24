package ejer02_Plataforma;

import java.util.*;

public class Platform {
    static Scanner scanner = new Scanner(System.in);
    private Map<String, String> correctAnswersMap = new HashMap<String, String>();
    private Map<String, List<Cycle>> platformMap;
    private List<Cycle> cycleList = new ArrayList<Cycle>();
    private Map<String, ProfessionalSkills> cycleMap;
    private List<ProfessionalSkills> professionalSkillsList = new ArrayList<ProfessionalSkills>();
    private List<Module> moduleList = new ArrayList<Module>();
    private List<Question> questions = new ArrayList<Question>();
    private String namePlatform;
    private Exam exam;
    private Map<String, List<Module>> professionalSkillsMap = new HashMap<String, List<Module>>();




    public Platform(String namePlatform, List<Cycle> cycleList) {
        this.namePlatform = namePlatform;
        this.cycleList = new ArrayList<Cycle>();
        this.moduleList = new ArrayList<Module>();
        this.cycleMap = new HashMap<String, ProfessionalSkills>();
    }

    public void addPlatform(String namePlatform)
    {
        //cycle
        System.out.println("Enter the name of the cycle");
        String nameCycle = scanner.next();

        //professional skills
            //base de datos
        System.out.println("These are the descriptions of the professional skills: ");
        List<String> descriptionList = new ArrayList<String>();
        String descripBBDD01 = "Gestionar bases de datos, interpretando su diseño lógico y verificando integridad, consistencia, seguridad y accesibilidad de los datos.";
        descriptionList.add(descripBBDD01);
        String descripBBDD02 = "Configurar y explotar sistemas informáticos, adaptando la configuración lógica del sistema según las necesidades de uso y los criterios establecidos.";
        descriptionList.add(descripBBDD02);

            //programacion
        String descrip03 = "Desarrollar aplicaciones multiplataforma con acceso a bases de datos utilizando lenguajes, librerías y herramientas adecuados a las especificaciones.";
        descriptionList.add(descrip03);
        String descrip04 = "Desarrollar aplicaciones implementando un sistema completo de formularios e informes que permitan gestionar de forma integral la información almacenada.";
        descriptionList.add(descrip04);

        //module data
        System.out.println("Enter the name of the module: ");
        String nameModule = scanner.next();
        scanner.nextLine();
        System.out.println("Enter the hours necessary for the module: ");
        int hoursModule = scanner.nextInt();

        //teacher data
        System.out.println("Enter the name of the teacher: ");
        String nameTeacher = scanner.next();
        System.out.println("Enter the surname of the teacher: ");
        String surnameTeacher = scanner.next();
        System.out.println("Enter the aka of the teacher: ");
        String akaTeacher = scanner.next();
        System.out.println("Enter the address of the teacher: ");
        String addressTeacher = scanner.next();
        scanner.nextLine();
        System.out.println("Enter the phone number of the teacher: ");
        int phoneNumberTeacher = scanner.nextInt();
        System.out.println("Enter the email address of the teacher: ");
        String emailTeacher = scanner.next();

            //new teacher
        Teacher teach = new Teacher(nameTeacher, surnameTeacher, addressTeacher, phoneNumberTeacher, akaTeacher, emailTeacher);

        //students data
        System.out.println("How many students do you want the module to have?");
        int numStudents = scanner.nextInt();
        String nameStudent = " ";
        List <Student> studentList = new ArrayList<>();
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter the name of the " +(i+1)+ " student");
            nameStudent = scanner.next();
            System.out.println("Enter the surname of the "+(i+1)+" student: ");
            String surnameStudent = scanner.next();
            System.out.println("Enter the aka of the "+(i+1)+ " student: ");
            String akaStudent = scanner.next();
            scanner.nextLine();
            System.out.println("Enter the address of the " +(i+1)+ " the student");
            String addressStudent = scanner.nextLine();
            System.out.println("Enter the phone number of the " +(i+1)+" student");
            int phoneNumberStudent = scanner.nextInt();
            System.out.println("Enter the email of the " +(i+1)+ " student");
            String emailStudent = scanner.next();

                //new student
            Student stud = new Student(nameStudent, surnameStudent, akaStudent, phoneNumberStudent, addressStudent, emailStudent);
            studentList.add(stud);
        }

        //exam data
        questions = new ArrayList<>();
        System.out.println(nameTeacher+" is going to make the exam for the module.");
        scanner.nextLine();
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter question " + (i + 1) + ": ");
            String question = scanner.nextLine();
            System.out.println("Enter the correct answer for question " + (i + 1) + ": ");
            String answer = scanner.nextLine();
            System.out.println("Enter three incorrect answers for question " + (i + 1) + ": ");
            String[] incorrectAnswers = new String[3];
            for (int j = 1; j <= 3; j++) {
                incorrectAnswers[j - 1] = scanner.nextLine();
            }
            questions.add(new Question(question, answer, incorrectAnswers[0], incorrectAnswers[1], incorrectAnswers[2]));
        }

        //new exam
        exam = new Exam(nameStudent, questions, correctAnswersMap);

        //new module
        Module mod = new Module(nameModule, hoursModule, teach, studentList, exam);
        moduleList.add(mod);

        //new professional skills
        ProfessionalSkills proSkillSet = new ProfessionalSkills(descriptionList, moduleList);

        //new cycle
        Cycle cyc = new Cycle(nameCycle, professionalSkillsList);
        cycleList.add(cyc);
        if (!platformMap.containsKey(namePlatform)) {
            platformMap.put(namePlatform, cycleList);
        }
    }
    public void takeExam(String studentName) {
        int score = 0;

        System.out.println("Welcome to the exam, " + studentName);

        List<Question> questions = exam.getQuestions();

        List<Integer> askedQuestions = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < questions.size(); i++) {
            int randomQuestion;
            do {
                randomQuestion = random.nextInt(questions.size());
            } while (askedQuestions.contains(randomQuestion));
            askedQuestions.add(randomQuestion);
            Question question = questions.get(randomQuestion);
            System.out.println("Question " + (i + 1) + ": " + question.getQuestion());

            List<String> answers = question.getAnswers();
            for (int j = 0; j < answers.size(); j++) {
                System.out.println((j+1) + ". " + answers.get(j));
            }

            System.out.print("Enter your answer (1-" + answers.size() + "): ");
            int answerIndex = scanner.nextInt() - 1;

            if (question.getAnswer(answerIndex).equals(question.getCorrectAnswer())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
        }

        System.out.println("Your final score is: " + score + " out of " + questions.size());

        if (score >= questions.size()/2) {
            Student.showCertificate();
        }
    }


    public void showAllData() {
        System.out.println("Platform name: " + namePlatform);
        System.out.println("----------------------------");
        for (Cycle cycle : cycleList)
        {
            System.out.println("Cycle name: " + cycle.getName());
            System.out.println("----------------------------");
            for (Module module : professionalSkillsMap.get(cycle.getName()))
            {
                System.out.println("Module name: " + module.getName());
                System.out.println("Hours necessary for module: " + module.getHours());
                System.out.println("----------------------------");
                System.out.println("Teacher name: " + module.getTeacher().getName());
                System.out.println("Teacher surname: " + module.getTeacher().getSurname());
                System.out.println("Teacher aka: " + module.getTeacher().getAka());
                System.out.println("Teacher address: " + module.getTeacher().getAddress());
                System.out.println("Teacher phone number: " + module.getTeacher().getPhoneNumber());
                System.out.println("Teacher email address: " + module.getTeacher().getEmail());
                System.out.println("----------------------------");
                System.out.println("Student information: ");
                for (Student student : module.getStudents())
                {
                    System.out.println("Student name: " + student.getName());
                    System.out.println("Student surname: " + student.getSurname());
                    System.out.println("Student aka: " + student.getAka());
                    System.out.println("Student address: " + student.getAddress());
                    System.out.println("Student phone number: " + student.getPhoneNumber());
                    System.out.println("Student email address: " + student.getEmail());
                    System.out.println("----------------------------");
                }
                System.out.println("Exam questions:");
                for (int i = 0; i < questions.size(); i++) {
                    System.out.println((i+1) + ". " + exam.getQuestion(i));
                }
                System.out.println("Exam correct answers:");
                System.out.println(exam.getCorrectAnswers());
                System.out.println("----------------------------");
            }
        }
    }
}
