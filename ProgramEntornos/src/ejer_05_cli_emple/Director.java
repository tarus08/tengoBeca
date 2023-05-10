package ejer_05_cli_emple;

import java.util.List;

public class Director extends Empleado
{
    private Categoria categoria;
    protected Director(String name, int age, double salary, Categoria categoria)
    {
        super(name, age, salary);
        this.categoria = categoria;
    }
    @Override
    public String toString()
    {
        return "Name: " + getName() + ", age: " + getAge() + ", salary: " + getSalary() + " categoria: " + getCategoria();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
