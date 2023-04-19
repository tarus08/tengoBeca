package ejer02_Plataforma;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Cycle {

    static Scanner scanner = new Scanner(System.in);
    private String name;
    private List<ProfessionalSkills> professionalSkillsList;

    public Cycle(String name, List<ProfessionalSkills> professionalSkillsList) {
        this.name = name;
        this.professionalSkillsList = professionalSkillsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProfessionalSkills> getProfessionalSkills() {
        return professionalSkillsList;
    }
}
