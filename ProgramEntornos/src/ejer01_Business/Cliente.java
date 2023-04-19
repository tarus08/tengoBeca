package ejer01_Business;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Cliente extends Persona {
    private int phoneNumber;
    private Set<Business> businesses;
    private Business busin;


    public Cliente(String name, LocalDate birthDate, int phoneNumber) {
        super(name, birthDate);
        this.phoneNumber = phoneNumber;
        this.businesses = new HashSet<>();
    }

    public void addBusiness(Business business) {
        businesses.add(business);
    }
    @Override
    public String toString()
    {
        return "CLIENTES. Nombre del cliente: " +getName()+ ", fecha de nacimiento " +getBirthDate()+ ", numero de telefono: " +getPhoneNumber()+ " empresas de la que es cliente: " +busin.getName();
    }
    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof Cliente))
        {
            return false;
        }
        Cliente otherClient = (Cliente) obj;
        return Objects.equals(this.getName(), otherClient.getName()) &&
                Objects.equals(this.getBirthDate(), otherClient.getBirthDate()) &&
                Objects.equals(this.getPhoneNumber(), otherClient.getPhoneNumber());
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(this.getName(), this.getBirthDate(), this.getPhoneNumber());
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public Set<Business> getBusiness() {
        return businesses;
    }

    public void setBusiness(Set<Business> businesses) {
        this.businesses = businesses;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(Set<Business> businesses) {
        this.businesses = businesses;
    }

    public Business getBusin() {
        return busin;
    }

    public void setBusin(Business busin) {
        this.busin = busin;
    }
}
