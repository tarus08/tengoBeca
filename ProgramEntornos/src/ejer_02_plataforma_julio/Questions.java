package ejer_02_plataforma_julio;

public class Questions {
    private String statement;
    private String [] answers = new String[4];
    private int correctAnswer;

    public Questions(String statement, String [] answers, int correctAnswer) {
        this.statement = statement;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }
}
