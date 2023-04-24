package Exer_Proposed_04;

public class Entero {
    Integer value = 0;
    public Entero(Integer value) {
        this.value = value;
    }
    Entero nextEntero ()
    {
        return new Entero(value + 1);
    }

    @Override
    public String toString()
    {
        return String.valueOf(value);
    }

}

