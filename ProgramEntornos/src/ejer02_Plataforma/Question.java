package ejer02_Plataforma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question {
    private String question;
    private String correctAnswer;
    private String inCorrectAnswer;
    private List<String> answers = new ArrayList<String>();

    public Question(String question, String correctAnswer, String... incorrectAnswers) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.answers.add(correctAnswer);
        this.answers.addAll(Arrays.asList(incorrectAnswers));
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public String getAnswer(int answerIndex) {
        return answers.get(answerIndex);
    }

}
