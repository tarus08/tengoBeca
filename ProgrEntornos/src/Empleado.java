import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Empleado {

    private int age;
    private String name;
    private double salary;
    private boolean status;

    public Empleado(String name, int age, double salary, boolean status) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.status = status;
    }

    public void newEmple() {

        Scanner scanner = new Scanner(System.in);
        List<Empleado> normalEmple = new ArrayList<>();
        List<Empleado> superiorEmple = new ArrayList<>();
        System.out.println("Enter false if the empleado is just empleado");
        boolean status = scanner.nextBoolean();
        if (status == true) {

            System.out.println("Lets enter a new empleado: ");
            System.out.println("Name: ");
            String name = scanner.next();
            System.out.println("Age: ");
            int age = scanner.nextInt();
            System.out.println("Salary:");
            double salary = scanner.nextDouble();

            System.out.println("Is he a manager, a supervisor or a ceo?");
            String category = scanner.next();
            switch (category) {
                case "manager":
                    System.out.println("The empleado is a manager, so the salary is bigger");
                    salary += 500;
                    break;

                case "supervisor":
                    System.out.println("The empleado is a supervisor, so the salary is bigger");
                    salary += 1000;
                    break;

                case "ceo":
                    System.out.println("The empleado is the ceo, so the salary is bigger");
                    salary += 2000;
                    break;

            }
            Empleado supEmple = new Empleado(name, age, salary, status);
            superiorEmple.add(supEmple);
        } else if (status == false) {
            System.out.println("Lets enter a new empleado: ");
            System.out.println("Name: ");
            String name = scanner.next();
            System.out.println("Age: ");
            int age = scanner.nextInt();
            System.out.println("Salary:");
            double salary = scanner.nextDouble();

            Empleado infEmple = new Empleado(name, age, salary, status);
            superiorEmple.add(infEmple);
        }

        for (Empleado e : superiorEmple) {
            System.out.println("These are the empleados: " + e.getName() +
                    " age: " + e.getAge() + " salary: " + e.getSalary() + " status: "
                    + e.isStatus());
        }
    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
