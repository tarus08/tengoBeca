package ejer_05_cli_emple;

public class Empleado extends Persona
{
    private double salary;
 protected Empleado (String name, int age, double salary) {
        super(name, age);
        this.salary = calculateSalary(salary);
    }
    private double calculateSalary(double salary)
    {
        return salary * 0.8;
    }
    @Override
    public String toString()
    {
        return "Name: " + getName() + " age " + getAge() + " salary " + salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
