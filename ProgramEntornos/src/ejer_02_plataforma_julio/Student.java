package ejer_02_plataforma_julio;

import java.util.ArrayList;

public class Student extends Person{

    private float avgGrade;
    private ArrayList<Module> module = new ArrayList<Module>();
    public Student(String name, String email, String address, int phoneNumber, String aka, float avdGrade, ArrayList<Module> moduleList) {
        super(name, email, address, phoneNumber, aka);
        this.avgGrade = avdGrade;
        this.module = moduleList;
    }

    public void showCertificate()
    {

    }
    public void calculateAvgGrade()
    {

    }

}
