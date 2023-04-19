package Aplicacion._11_22_Empleado;

import java.io.Serializable;

public class Empleado implements Serializable {

    private int _dni;
    private String _name;
    private double _salary;

    public Empleado(int dni, String name, double salary) {
        this._dni = dni;
        this._name = name;
        this._salary = salary;
    }

    @Override
    public String toString() {
        return "// " +
                " dni: " + _dni +
                "/ nombre: " + _name +
                "/ salary: " + _salary+
                "//";
    }

    public int get_dni() {
        return _dni;
    }

    public void set_dni(int _dni) {
        this._dni = _dni;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public double get_salary() {
        return _salary;
    }

    public void set_salary(double _salary) {
        this._salary = _salary;
    }
}
