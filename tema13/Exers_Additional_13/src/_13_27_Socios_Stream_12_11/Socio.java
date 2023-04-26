package _13_27_Socios_Stream_12_11;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Socio implements Serializable {

    private int dni;
    private String name;
    private LocalDate fechaAlta;

    protected Socio(int dni, String name, LocalDate fechaAlta) {
        this.dni = dni;
        this.name = name;
        this.fechaAlta = fechaAlta;
    }

    public Socio(int dni){
        this.dni = dni;
    }

    int antiquity(){
        return (int) LocalDate.now().until(getFechaAlta(), ChronoUnit.YEARS);
    }
    public static int compareTo(Socio s1, Socio s2) {
        return s1.getDni() - (s2.getDni());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Socio)) {
            return false;
        }
        Socio other = (Socio) obj;
        return dni == other.dni;
    }

    @Override
    public String toString ()
    {
        return "Dni: " +getDni() + ". Name: " +getName()+ ". Fecha de alta: " +getFechaAlta();
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

}
