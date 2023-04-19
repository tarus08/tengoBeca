package ejer02_Plataforma;

import java.util.*;

public class Platform {
    static Scanner scanner = new Scanner(System.in);
    private Map<String, List<Cycle>> platformMap;
    private Map<String, List<Module>> cycleMap;
    private List<Cycle> cycleList = new ArrayList<Cycle>();
    private List<Question> questions = new ArrayList<Question>();
    private Exam exam;
    private Map<String, String> correctAnswers = new HashMap<String, String>();
    private List<Module> moduleList = new ArrayList<Module>();
    private String namePlatform;

    public Platform(String namePlatform, Map<String, List<Cycle>> platformMap) {
        this.namePlatform = namePlatform;
        this.platformMap = platformMap;
        this.cycleList = new ArrayList<Cycle>();
        this.moduleList = new ArrayList<Module>();
        this.cycleMap = new HashMap<String, List<Module>>();
    }

    public void addPlatform(String namePlatform)
    {
        int choice = 0;

        //cycle
        System.out.println("Enter the name of the cycle");
        String nameCycle = scanner.next();

        //module
        System.out.println("Enter the name of the module: ");
        String nameModule = scanner.next();
        System.out.println("Enter the hours necessary for the module: ");
        int hoursModule = scanner.nextInt();

        //teacher
        System.out.println("Enter the name of the teacher: ");
        String nameTeacher = scanner.next();
        System.out.println("Enter the surname of the teacher: ");
        String surnameTeacher = scanner.next();
        System.out.println("Enter the aka of the teacher: ");
        String akaTeacher = scanner.next();
        System.out.println("Enter the address of the teacher: ");
        String addressTeacher = scanner.next();
        System.out.println("Enter the phone number of the teacher: ");
        int phoneNumberTeacher = scanner.nextInt();
        System.out.println("Enter the email address of the teacher: ");
        String emailTeacher = scanner.next();
        Teacher teach = new Teacher(nameTeacher, surnameTeacher, addressTeacher, phoneNumberTeacher, akaTeacher, emailTeacher);

        //students
        System.out.println("How many students do you want the module to have?");
        int numStudents = scanner.nextInt();
        String nameStudent = " ";
        List <Student> studentList = new ArrayList<>();
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter the name of the student");
            nameStudent = scanner.next();
            System.out.println("Enter the surname of the student: ");
            String surnameStudent = scanner.next();
            System.out.println("Enter the aka of the student: ");
            String akaStudent = scanner.next();
            System.out.println("Enter the address of the student");
            String addressStudent = scanner.next();
            System.out.println("Enter the phone number of the student");
            int phoneNumberStudent = scanner.nextInt();
            System.out.println("Enter the email of the student");
            String emailStudent = scanner.next();
            Student stud = new Student(nameStudent, surnameStudent, akaStudent, phoneNumberStudent, addressStudent, emailStudent);
            studentList.add(stud);
        }

        questions = new ArrayList<>();
        Map<String, String> moduleQA = new HashMap<>();
        System.out.println("Lets make the exam for the module.");
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter question " + (i + 1) + ": ");
            String question = scanner.nextLine();
            System.out.println("Enter the correct answer for question " + (i + 1) + ": ");
            String answer = scanner.nextLine();
            System.out.println("Enter three incorrect answers for question " + (i + 1) + ": ");
            String[] incorrectAnswers = new String[3];
            for (int j = 1; j <= 3; j++) {
                incorrectAnswers[j-1] = scanner.nextLine();
            }
            questions.add(new Question(question, answer, incorrectAnswers[0], incorrectAnswers[1], incorrectAnswers[2]));
            Exam exam = new Exam(nameStudent, questions, correctAnswers);
        }
        Module mod = new Module(nameModule, hoursModule, teach, studentList, exam);
        if (!cycleMap.containsKey(nameCycle)) {
            cycleMap.put(nameCycle, new ArrayList<Module>());
        }
        cycleMap.get(nameCycle).add(mod);

        Cycle cyc = new Cycle(nameCycle, cycleMap.get(nameCycle));
        if (!platformMap.containsKey(namePlatform)) {
            platformMap.put(namePlatform, new ArrayList<Cycle>());
        }
        platformMap.get(namePlatform).add(cyc);
    }
    public void takeExam(Exam exam, String studentName) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the exam, " + studentName + "!");

        List<Question> questions = exam.getQuestions();

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("Question " + (i+1) + ": " + question.getQuestion());

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

        if (score >= 5)
        {
            System.out.println("Congratulations! You have passed the module.");
        }
    }

    public void showCertificate()
    {
        System.out.println("Congratulations! You have successfully passed the cycle. ");
    }
}
