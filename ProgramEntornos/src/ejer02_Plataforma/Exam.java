
package ejer02_Plataforma;

import java.util.*;

public class Exam {

    private List<Question> questions = new ArrayList<Question>();
    private Map<String, String> correctAnswers = new HashMap<String, String>();

    private String nameStudent;
    public Exam(String nameStudent, List<Question> questions, Map<String, String> correctAnswers) {
        this.nameStudent = nameStudent;
        this.questions = questions;
        this.correctAnswers = correctAnswers;
    }
    public String getQuestion(int questionIndex)
    {
        return questions.get(questionIndex).getQuestion();
    }

    public List<Question> getQuestions() {
        return questions;
    }
}