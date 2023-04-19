package ejer01_Business;

import java.util.*;

public class Business {
    static Scanner scanner = new Scanner(System.in);
    private String name;
    private String CIF;
    private HashSet<Cliente> cli;
    private HashSet<Manager> managers;
    private static Set<Business> businesses = new HashSet<>();
    private Employee emple;
    private Cliente client;
    private Manager manager;

    private HashSet<Manager> manag;

    public Business(String name, String CIF) {
        this.name = name;
        this.CIF = CIF;
        this.cli = new HashSet<Cliente>();
        this.manag = new HashSet<Manager>();
    }
    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof Business))
        {
            return false;
        }
        Business other = (Business) obj;
        return Objects.equals(this.getName(), other.getName()) &&
                Objects.equals(this.getCIF(), other.getCIF()) &&
                Objects.equals(this.getCli(), other.getCli()) &&
                Objects.equals(this.getManag(), other.getManag());
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(this.getName(), this.getCIF(), this.getManag(), this.getClient());
    }
    public void addManager(Manager manager){
        this.manag.add(manager);
        manager.addBusiness(this);
    }
    public void addClient(Cliente newClient) {
        this.cli.add(newClient);
        newClient.addBusiness(this);
    }
    public void showClientBusiness (Map<Cliente, Business> businessMapClient)
    {
        for (Map.Entry<Cliente, Business> entry : businessMapClient.entrySet()) {
            Cliente client = entry.getKey();
            Business busine = entry.getValue();
            System.out.println("Client name: " + client.getName() + " birthdate client: " +client.getBirthDate()+
                    " phonw number client: " + client.getPhoneNumber()+ ". ejer01_Business.Business name: " + busine.getName()+
                    " cif: " +busine.getCIF());
        }
    }

    public String toString() {
        return "BUSINESSES. Name of the business: " +getName()+ ", cif: " +getCIF();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public Set<Cliente> getCli() {
        return cli;
    }

    public void setCli(HashSet<Cliente> cli) {
        this.cli = cli;
    }

    public static Set<Business> getBusinesses() {
        return businesses;
    }

    public static void setBusinesses(Set<Business> businesses) {
        Business.businesses = businesses;
    }

    public HashSet<Manager> getManag() {
        return manag;
    }

    public void setManag(HashSet<Manager> manag) {
        this.manag = manag;
    }


    public HashSet<Cliente> getClients() {
        return this.cli;
    }

    public void removeClient(Cliente client) {
        this.cli.remove(client);
    }

    public HashSet<Manager> getManagers() {
        return managers;
    }

    public void setManagers(HashSet<Manager> managers) {
        this.managers = managers;
    }

    public Employee getEmple() {
        return emple;
    }

    public void setEmple(Employee emple) {
        this.emple = emple;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
