package ejer_02_plataforma_julio;
import java.util.ArrayList;

public class Module {
    private String name, conten;
    private int duration;
    private Teacher teacher;
    private ArrayList<Student> studentList;

    public Module(String name, String conten, int duration, ArrayList<Student> studentList) {
        this.name = name;
        this.conten = conten;
        this.duration = duration;
        this.studentList = studentList;
    }

    public void matriculate (Student student)
    {

    }
}
