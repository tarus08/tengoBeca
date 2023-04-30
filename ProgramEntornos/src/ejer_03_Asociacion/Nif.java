package ejer_03_Asociacion;

public class Nif {

    private int dni;
    private char letter;
    protected Nif(int dni, char letter) {
        this.dni = dni;
        this.letter = letter;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }
}
