package ExersTheory._12_11_Socios;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Socio implements Comparable<Socio>, Serializable {

    private int dni;
    private String name;
    private LocalDate fechaAlta;

    public Socio(int dni, String name, LocalDate fechaAlta) {
        this.dni = dni;
        this.name = name;
        this.fechaAlta = fechaAlta;
    }

    public Socio(int dni){
        this.dni = dni;
    }

    int antiquity(){
        return (int) fechaAlta.until(LocalDate.now(), ChronoUnit.YEARS);
    }
    @Override
    public int compareTo(Socio o) {
        return Integer.compare(dni, o.dni);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Socio)) {
            return false;
        }
        Socio other = (Socio) obj;
        return dni == other.dni;    }

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
