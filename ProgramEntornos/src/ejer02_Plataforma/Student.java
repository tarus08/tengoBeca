package ejer02_Plataforma;

public class Student extends Person{
private String aka, email;
    public Student(String name, String surname, String address, int phoneNumber, String aka, String email) {
        super(name, surname, address, phoneNumber);
        this.aka = aka;
        this.email = email;
    }

    public void getGrades(String name, Exam exam)
    {

    }

    public String getAka() {
        return aka;
    }

    public void setAka(String aka) {
        this.aka = aka;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
