package _13_13_Client_Data_Client;

import java.time.LocalDate;

public class Cliente {

    private String name;
    private LocalDate birthDate;
    private String dni;
    protected Cliente(String dni, String name, LocalDate birthDate) {
        this.dni = dni;
        this.birthDate = birthDate;
        this.name = name;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
