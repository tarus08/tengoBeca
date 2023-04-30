package ejer_03_Asociacion;

public class Socio extends Person{
    private String associateCode;
    private Date fechaAlta;
    private Name name;

    protected Socio(Nif nif, Name name, String surname01, String surname02, Date birthDate, Date fechaAlta, String associateCode) {
        super(nif, name, birthDate);
        this.associateCode = associateCode;
        this.fechaAlta = fechaAlta;
    }

    public String getAssociateCode() {
        return associateCode;
    }

    public void setAssociateCode(String associateCode) {
        this.associateCode = associateCode;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}
