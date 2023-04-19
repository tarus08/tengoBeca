package ejer02_Plataforma;

import java.util.ArrayList;
import java.util.List;

public class ProfessionalSkills {

    private List<Module> modulesList = new ArrayList<>();
    private List<String> descriptionList = new ArrayList<>();
    public ProfessionalSkills(List<String> descriptionList, List<Module> moduleList) {
        this.descriptionList = descriptionList;
        this.modulesList = moduleList;
    }

    public List<Module> getModulesList() {
        return modulesList;
    }

    public void setModulesList(List<Module> modulesList) {
        this.modulesList = modulesList;
    }

    public List<String> getDescriptionList() {
        return descriptionList;
    }

    public void setDescriptionList(List<String> descriptionList) {
        this.descriptionList = descriptionList;
    }
}
