package _13_16_17_18_19_20_21_Socio;

import java.time.LocalDate;

public class Socio {
    private String dni;
    private String name;
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

    public int compareTo(Socio s)
    {
        return this.getDni().compareTo(s.getDni());
    }

    public int equals(Socio s)
    {
        return this.getDni().compareTo(s.getDni());
    }

    public static int age(Socio s1, Socio s2)
    {
        return s2.getBirthDate().until(LocalDate.now()).getYears()
                - s1.getBirthDate().until(LocalDate.now()).getYears();
    }

    public static int loyalty(Socio s1, Socio s2)
    {
        return s2.getFechaAlta().until(s1.getFechaAlta()).getMonths();
    }

    public static int compNames (Socio s1, Socio s2)
    {
        return s1.getName().compareTo(s2.getName());
    }
    @Override
    public String toString()
    {
        return "Dni: " +dni+ ". Name: " + name;
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
