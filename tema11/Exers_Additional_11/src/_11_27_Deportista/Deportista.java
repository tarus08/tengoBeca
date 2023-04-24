package _11_27_Deportista;
import java.io.Serializable;
import java.time.LocalDate;

public class Deportista implements Serializable {
     private final int dni;
     private String name;
     private LocalDate birthDate;
     private Deportes sport;
    Deportista [] dep = new Deportista [3];

    public Deportista(int dni, String name, LocalDate birthDate, Deportes sport) {
        this.dni = dni;
        this.name = name;
        this.birthDate = birthDate;
        this.sport = sport;
    }
    public int getDni() {
        return dni;
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

    public Deportes getSport() {
        return sport;
    }

    public void setSport(Deportes sport) {
        this.sport = sport;
    }
}
