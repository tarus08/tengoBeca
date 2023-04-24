package ejer_02_plataforma_julio;

import java.util.ArrayList;

public class Teacher extends Person{
    private int npr;
    private ArrayList<Module> modulesList;

    public Teacher(String name, String email, String address, int phoneNumber, String aka, int npr, ArrayList<Module> modulesList) {
        super(name, email, address, phoneNumber, aka);
        this.npr = npr;
        this.modulesList = modulesList;
    }
}
