package ejer01_Business;

import java.time.LocalDate;
import java.util.*;

public class Manager extends Employee {
    static Scanner scanner = new Scanner(System.in);
    private int category;
    private Business busi;
    private Employee employee;
    private Set<Employee> employeeSet;
    private Set<Business> businessSet;

    public Manager(String name, LocalDate birthDate, int paycheck, int category) {
        super(name, birthDate, paycheck);
        this.category = category;
        this.employeeSet = new HashSet<Employee>();
        this.businessSet = new HashSet<Business>();
    }

    public void addEmployee(Employee employee) {
        if(!employeeSet.contains(employee))
        {
            employee.setManager(this);
            employeeSet.add(employee);
        }
        else
        {
            System.out.println("ejer01_Business.Employee already exists. ");
        }
    }
    public void addBusiness(Business business) {
        this.businessSet.add(business);
    }

    @Override
    public String toString()
    {
        return "DIRECTIVOS. Nombre del directivo: " + getName() + ", fecha de nacimiento: " +getBirthDate() + ", salario:  " +getPaycheck() + ", categoria: " +getCategory();
    }

    public int getCategory() {
        return category;
    }
    public void setCategory(int category) {
        this.category = category;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    public Business getBusi() {
        return busi;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof Manager))
        {
            return false;
        }
        Manager other = (Manager) obj;
        return Objects.equals(this.getName(), other.getName()) &&
                Objects.equals(this.getBirthDate(), other.getBirthDate()) &&
                Objects.equals(this.getPaycheck(), other.getPaycheck()) &&
                Objects.equals(this.getCategory(), other.getCategory());
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(this.getName(), this.getBirthDate(), this.getPaycheck(), this.getCategory());
    }

    public void setBusi(Business busi) {
        this.busi = busi;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void showManagAndEmployee(Map<Manager, Employee> managerMap)
    {
        for(Map.Entry<Manager, Employee> entry : managerMap.entrySet())
        {
            Manager man = entry.getKey();
            Employee empl = entry.getValue();
            System.out.println("MANAGERS.: " +man.getName()+ " birthdate: " +man.getBirthDate()+
                    "the paycheck: " +man.getPaycheck()+ " the category: " + man.getCategory()+
                    "EMPLOYEES. The name of the employees: " +empl.getName()+ "the birthdate: "
                    +empl.getBirthDate()+ " the paycheck: " +empl.getPaycheck());
        }
    }
}
