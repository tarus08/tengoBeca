package _11_31_Cliente;

import java.io.Serializable;
import java.time.LocalDate;
public class ClienteBanco implements Serializable {

    private String dni;
    private String name;
    private double money;
    private LocalDate birthDate;

    public ClienteBanco(String dni, String name, double money, LocalDate birthDate) {
        this.dni = dni;
        this.name = name;
        this.money = money;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + "\n" +
                "Name: " + name + "\n" +
                "Money: " + money + "\n" +
                "Birthdate: " + birthDate;
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

}
