package ejer02_Plataforma;

import java.util.*;

public class Module {
    private String name;
    private int hours;
    private Teacher teacher;
    private List<Student> studentsList = new ArrayList<Student>();
    private List<Question> questions;
    private Map<String, String> correctAnswers;
    private Exam exam;

    public Module(String name, int hours, Teacher teacher, List<Student> students, Exam exam) {
        this.name = name;
        this.hours = hours;
        this.teacher = teacher;
        this.studentsList = students;
        this.questions = new ArrayList<>();
        this.correctAnswers = new HashMap<>();
        this.exam = new Exam(name, questions, correctAnswers);
    }
    public void passExam(int questionIndex, int answerIndex)
    {
        int grades = 0;
        String enteredAnswer = questions.get(questionIndex).getAnswer(answerIndex);
        String correctAnswer = correctAnswers.get(questions.get(questionIndex).getQuestion());

        if (enteredAnswer.equals(correctAnswer))
        {
            grades++;
            System.out.println("The answer is correct, this is your grade: " +grades);
        }

        if (grades >= (questions.size()/2))
        {
            System.out.println("You passed the exam, congratulations.");
        }
        else
        {
            System.out.println("You haven't passed the exam, sorry.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher)
    {
        this.teacher = teacher;
    }
    public List<Student> getStudent()
    {
        return studentsList;
    }
    public void setStudent(List<Student> students)
    {
        this.studentsList = students;
    }

    public List<Student> getStudents() {
        return studentsList;
    }

    public Exam getExam() {
        return exam;
    }
}