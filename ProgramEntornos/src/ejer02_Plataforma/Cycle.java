package ejer02_Plataforma;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Cycle {

    static Scanner scanner = new Scanner(System.in);
    private String name;
    private Map<String, List<Module>> cycleMap;
    private List<Module> moduleList;

    public Cycle(String name, List<Module> moduleList) {
        this.name = name;
        this.moduleList = moduleList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
