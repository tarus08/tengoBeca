package ejer02_Plataforma;

public class Student extends Person{
    private float avGrade;
private String aka, email;
    public Student(String name, String surname, String address, int phoneNumber, String aka, String email, float avGrade) {
        super(name, surname, address, phoneNumber);
        this.aka = aka;
        this.email = email;
        this.avGrade = avGrade;
    }

    protected void calculateAvgGrade()
    {

    }

    protected static void showCertificate()
    {
        System.out.println("Congratulations! You have successfully passed the cycle. ");
    }

    public String toString()
    {
        return "STUDENTS. Name: " +getName()+ ", the surname: " +getSurname()+ ", the aka: " +getAka()+
                ", the address: " +getAddress()+ ", the phone number: " +getPhoneNumber()+
                ", the email: " +getEmail();
    }

    protected String getAka() {
        return aka;
    }

    protected void setAka(String aka) {
        this.aka = aka;
    }

    protected String getEmail() {
        return email;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

    protected float getAvGrade() {
        return avGrade;
    }
    protected void setAvGrade(float avGrade) {
        this.avGrade = avGrade;
    }
}
