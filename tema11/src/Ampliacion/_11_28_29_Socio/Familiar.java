package Ampliacion._11_28_29_Socio;

import java.time.LocalDate;

public class Familiar {

    private int dni;
    private String name;
    private LocalDate birthDate;

    public Familiar(int dni, String name, LocalDate birthDate) {
        this.dni = dni;
        this.name = name;
        this.birthDate = birthDate;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
