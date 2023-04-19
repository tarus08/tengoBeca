package ejer02_Plataforma;

import java.util.*;

public class Exam {

    private List<Question> questions = new ArrayList<Question>();
    private Map<String, String> correctAnswersMap = new HashMap<String, String>();

    private String nameStudent;

    public Exam(String nameStudent, List<Question> questions, Map<String, String> correctAnswersMap) {
        if (nameStudent == null || nameStudent.isEmpty()) {
            throw new IllegalArgumentException("Name student cannot be null or empty");
        }
        if (questions == null || questions.isEmpty()) {
            throw new IllegalArgumentException("Questions list cannot be null or empty");
        }
        if (correctAnswersMap == null || correctAnswersMap.isEmpty()) {
            throw new IllegalArgumentException("Correct answers map cannot be null or empty");
        }
        this.nameStudent = nameStudent;
        this.questions = questions;
        this.correctAnswersMap = correctAnswersMap;
    }

    public String getQuestion(int questionIndex) {
        if (questionIndex < 0 || questionIndex >= questions.size()) {
            throw new IndexOutOfBoundsException("Invalid question index");
        }
        return questions.get(questionIndex).getQuestion();
    }

    public String getCorrectAnswers() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : correctAnswersMap.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }

    public List<Question> getQuestions() {
        return questions;
    }

}
