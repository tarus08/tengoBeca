package _11_30_Jornada;
import java.io.Serializable;
import java.time.LocalDateTime;
public class Jornada implements Serializable {
    private int dni;
    private LocalDateTime entrance;
    private LocalDateTime out;
    public Jornada(int dni, LocalDateTime entrance, LocalDateTime out) {
        this.dni = dni;
        this.entrance = entrance;
        this.out = out;
    }
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDateTime getEntrance() {
        return entrance;
    }

    public void setEntrance(LocalDateTime entrance) {
        this.entrance = entrance;
    }

    public LocalDateTime getOut() {
        return out;
    }

    public void setOut(LocalDateTime out) {
        this.out = out;
    }
}
