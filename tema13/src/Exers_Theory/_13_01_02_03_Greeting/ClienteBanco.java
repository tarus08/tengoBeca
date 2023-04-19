package Exers_Theory._13_01_02_03_Greeting;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

public class ClienteBanco implements Serializable {

    private String dni;
    private String name;
    private double money;
    private String birthDate;
    private int age;

    public ClienteBanco(String dni, String name, double money, String birthDate, int age) {
        this.dni = dni;
        this.name = name;
        this.money = money;
        this.birthDate = birthDate;
        this.age = age;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "DNI: " + dni + "\n" +
                "Name: " + name + "\n" +
                "Money: " + money + "\n" +
                "Birthdate: " + String.format(String.valueOf(formatter));
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate( String birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
