package ejer02_Plataforma;

public class Teacher extends Person{
    private String aka, email;
    private int nrp;
    public Teacher(String name, String surname, String address, int phoneNumber, String aka, String email) {
        super(name, surname, address, phoneNumber);
        this.aka = aka;
        this.email = email;
    }
    public String toString()
    {
        return "STUDENTS. Name: " +getName()+ ", the surname: " +getSurname()+ ", the aka: " +getAka()+
               ", the nrp: " +getNrp()+ ", the address: " +getAddress()+ ", the phone number: " +getPhoneNumber()+
                ", the email: " +getEmail();
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

    public int getNrp() {
        return nrp;
    }

    public void setNrp(int nrp) {
        this.nrp = nrp;
    }
}
