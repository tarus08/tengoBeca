package ejer_03_Asociacion;

public class Name {
    private String name;
    private String surname01;
    private String surname02;

    public Name(String name, String surname01, String surname02) {
        this.name = name;
        this.surname01 = surname01;
        this.surname02 = surname02;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname01() {
        return surname01;
    }

    public void setSurname01(String surname01) {
        this.surname01 = surname01;
    }

    public String getSurname02() {
        return surname02;
    }

    public void setSurname02(String surname02) {
        this.surname02 = surname02;
    }
}
