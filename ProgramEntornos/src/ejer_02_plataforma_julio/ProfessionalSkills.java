package ejer_02_plataforma_julio;

import java.util.ArrayList;

public class ProfessionalSkills {
    private String description;
    private ArrayList<Module> moduleList;
    public ProfessionalSkills(String description, ArrayList<Module> moduleList) {
        this.description = description;
        this.moduleList = moduleList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
