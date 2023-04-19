package ejer01_Business;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Employee extends Persona {
    static Scanner scanner = new Scanner(System.in);
    private int paycheck;
    private Manager manager;
    private Business business;
    private Set<Manager> managers = new HashSet<>();

    public Employee(String name, LocalDate birthDate, int paycheck) {
        super(name, birthDate);
        this.paycheck = paycheck;
    }
    @Override
    public String toString()
    {
        return "EMPLEADOS. " +getName()+ ", fecha de nacimiento: " +getBirthDate()+ ", salario: " +getPaycheck();
    }
   public void addEmpleadoToDirector(String directorName) {
        for (Manager director : managers) {
            if (director.getName().equals(directorName)) {
                System.out.println("Enter the name of the employee: ");
                String nameEmployee = scanner.next();
                System.out.println("Enter the birthdate of the employee (yyyy-MM-dd");
                int year02 = scanner.nextInt();
                int month02 = scanner.nextInt();
                int day02 = scanner.nextInt();
                LocalDate birthDateEmployee = LocalDate.of(year02, month02, day02);
                System.out.println("Enter the paycheck: ");
                int paycheckEmployee = scanner.nextInt();
                Employee employee = new Employee(nameEmployee, birthDateEmployee, paycheckEmployee);
                manager.addEmployee(employee);
                return;
            }
        }
        System.out.println("Director not found");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof Employee))
        {
            return false;
        }
        Employee other = (Employee) obj;

        return Objects.equals(this.getName(), other.getName()) &&
                Objects.equals(this.getBirthDate(), other.getBirthDate()) &&
                Objects.equals(this.getPaycheck(), other.getPaycheck());
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(this.getName(), this.getBirthDate(), this.getPaycheck());
    }

    public int getPaycheck() {
        return paycheck;
    }
    public void setPaycheck(int paycheck) {
        this.paycheck = paycheck;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Set<Manager> getManagers() {
        return managers;
    }

    public void setManagers(Set<Manager> managers) {
        this.managers = managers;
    }

}
