package ejer01_Business;

import java.time.LocalDate;
import java.time.Period;

public class Persona {

    private String name;
    private LocalDate birthDate;

    public Persona(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public int calculateAge(){
        LocalDate birthDate = getBirthDate();
        LocalDate today = LocalDate.now();
        return Period.between(birthDate, today).getYears();
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
}
