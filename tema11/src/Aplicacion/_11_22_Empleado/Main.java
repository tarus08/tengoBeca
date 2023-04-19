package Aplicacion._11_22_Empleado;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Empleado> _list_Emple = new ArrayList<Empleado>();
        int choice = 0;

        // write initial list of employees to file
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("emple.dat"))) {
            // Create a list of employees and write it to the file
            List<Empleado> initialEmployees = new ArrayList<>();
            initialEmployees.add(new Empleado(12345678, "John Doe", 1000.0));
            initialEmployees.add(new Empleado(87654321, "Jane Smith", 2000.0));
            writer.writeObject(initialEmployees);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        try(ObjectInputStream reader = new ObjectInputStream(
                new FileInputStream("emple.dat"))){
            _list_Emple = (ArrayList<Empleado>)reader.readObject();
            for(Empleado e : _list_Emple){
                System.out.println("These are the employees now: " +e.toString());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        do{
            System.out.println("Enter: \n'1' to add a new employee (dar de alta)\n" +
                    "'2' to delete an employee (dar de baja)\n" +
                    "'3' to show the data of the employees\n" +
                    "'4' to list the employees\n" +
                    "'5' to exit the loop\n");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the dni, the name and the salaru of the employee");
                    int _newDni = scanner.nextInt();
                    scanner.nextLine();
                    String _newName = scanner.nextLine();
                    double _newSalary = scanner.nextDouble();

                    if (_newDni > 0 && _newSalary > 0 && _newName != null && !_newName.isEmpty()) {
                        Empleado _newEmpleado = new Empleado(_newDni, _newName, _newSalary);
                        _list_Emple.add(_newEmpleado);
                    } else {
                        System.out.println("Incorrect values");
                    }
                    break;

                case 2:
                    if (_list_Emple != null && !_list_Emple.isEmpty()) {
                        System.out.println("Enter the index of the employee you want to delete");
                        int index = scanner.nextInt();
                        if (index >= 0 && index < _list_Emple.size()) {
                            _list_Emple.remove(index);
                            for(Empleado e : _list_Emple){
                                System.out.println("These are the names of the empleados you deleted: "+e.get_name());
                            }
                        } else {
                            System.out.println("Invalid index.");
                        }
                    } else {
                        System.out.println("The list of employees is empty.");
                    }
                    break;

                case 3:
                    for(Empleado e : _list_Emple){
                        System.out.println("These are the empleados: " +e.toString());
                    }
                    break;

                case 4:
                    for(Empleado e : _list_Emple){
                        System.out.println("This is the name of the empleados: "+e.get_name());
                    }
                    break;

                case 5:
                    try(ObjectOutputStream writer = new ObjectOutputStream(
                            new FileOutputStream("emple.dat"))){
                        writer.writeObject(_list_Emple);
                        for(Empleado e : _list_Emple){
                            System.out.println("These are the empleados: " +e.toString());
                        }
                        choice = 5;
                    }catch (Exception e){
                        System.out.println("There was an error writing" +e.getMessage());
                    }
            }
        }while (choice > 0 && choice <= 4);
    }
}
