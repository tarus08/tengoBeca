package ejer_03_Asociacion;

public class Person {
    private Nif nif;
    private String name;
    private Date date;
    private String numAssociate;

    public Person(Nif nif, String name, Date date, String numAssociate) {
        this.nif = nif;
        this.name = name;
        this.date = date;
        this.numAssociate = numAssociate;
    }

    public Nif getNif() {
        return nif;
    }

    public void setNif(Nif nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNumAssociate() {
        return numAssociate;
    }

    public void setNumAssociate(String numAssociate) {
        this.numAssociate = numAssociate;
    }
}
