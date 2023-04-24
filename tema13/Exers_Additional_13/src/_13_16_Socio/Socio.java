package _13_16_Socio;

import java.time.LocalDate;

public class Socio {
    private String dni, name;
    private LocalDate birthDate, fechaAlta;
    private double share;
    private int numFamily;

    public Socio(String dni, String name, LocalDate birthDate, LocalDate fechaAlta, double share, int numFamily) {
        this.dni = dni;
        this.name = name;
        this.birthDate = birthDate;
        this.fechaAlta = fechaAlta;
        this.share = share;
        this.numFamily = numFamily;
    }

    public String equals()
    {
        boolean startswith = false;
        if (name.startsWith("A"))
        {
            return dni;
        }
        return dni;
    }

     void compareTo()
    {

    }

    @Override
    public String toString()
    {
        return name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public double getShare() {
        return share;
    }

    public void setShare(double share) {
        this.share = share;
    }

    public int getNumFamily() {
        return numFamily;
    }

    public void setNumFamily(int numFamily) {
        this.numFamily = numFamily;
    }
}
