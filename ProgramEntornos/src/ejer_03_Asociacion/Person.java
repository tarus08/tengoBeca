package ejer_03_Asociacion;

public class Person {
    private Nif nif;
    private Name name;
    private Date birthDate;

    protected Person(Nif nif, Name name, Date birthDate) {
        this.nif = nif;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Nif getNif() {
        return nif;
    }

    public void setNif(Nif nif) {
        this.nif = nif;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

}
