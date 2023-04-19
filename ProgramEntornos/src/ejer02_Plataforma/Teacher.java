package ejer02_Plataforma;

public class Teacher extends Person{
    private String aka, email;
    private int nrp;
    public Teacher(String name, String surname, String address, int phoneNumber, String aka, String email) {
        super(name, surname, address, phoneNumber);
        this.aka = aka;
        this.email = email;
    }
}
