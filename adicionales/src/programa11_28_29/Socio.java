package programa11_28_29;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Socio implements Serializable {

    private final int num_socio;
    private String name;
    private LocalDate birthDate;
    private LocalDate fechaAlta;
    private int phoneNumber;
    private String email;
    private static List<Familiar> relatives;

    //constructor, getters and setters
    public Socio(int numSocio, String name, LocalDate birthDate, LocalDate fechaAlta, int phoneNumber, String email, List<Familiar>relatives) {
        num_socio = numSocio;
        this.name = name;
        this.birthDate = birthDate;
        this.fechaAlta = fechaAlta;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.relatives = relatives;
    }

    public int getNum_socio() {
        return num_socio;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static List<Familiar> getRelatives() {
        return relatives;
    }

    public void setRelatives(List<Familiar> relatives) {
        this.relatives = relatives;
    }
}
