package ejer01_Business;

import ejer01_Business.Business;
import ejer01_Business.Cliente;
import ejer01_Business.Employee;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Business busi = new Business("businnesname", "123");
        LocalDate birhthDate = LocalDate.of(2000,12,12);
        Manager manag = new Manager("Paco", birhthDate, 2000,1);
        Cliente cl = new Cliente ("Paco",birhthDate, 1234);
        Employee emp = new Employee("Paco",birhthDate, 2300);
        Map<String, Business> businessMapString = new HashMap<>();
        Map<Cliente, Business> businessMapClient = new HashMap<>();
        Map<Manager, Employee> managerMap = new HashMap<>();
        int choice = 0;

        do {
            System.out.println("We have to store the info of a business. \n" +
                    "Insert: \n" +
                    "'1' To add a new business.\n" +
                    "'2' To add a new director to a business.\n" +
                    "'3' To add a new employee to a director.\n" +
                    "'4' To add a new client to a business.\n" +
                    "'5' To delete a client from a business.");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    //business data
                    System.out.println("Enter the name of the new business: ");
                    String nameBusiness = scanner.next();
                    System.out.println("Write the cif of the business: ");
                    String cifBusiness = scanner.next();
                    System.out.println();
                    Business business = new Business(nameBusiness, cifBusiness);
                    businessMapString.put(nameBusiness, business);

                    //client
                    System.out.println("Enter the name of the new client:");
                    String nameClient = scanner.next();
                    System.out.println("Enter the birthday: ");
                    int yearClient = scanner.nextInt();
                    int monthClient = scanner.nextInt();
                    int dayClient = scanner.nextInt();
                    LocalDate birthDate = LocalDate.of(yearClient, monthClient, dayClient);
                    System.out.println("Enter the phone number: ");
                    int phoneNumberClient = scanner.nextInt();
                    Cliente newClient = new Cliente(nameClient, birthDate, phoneNumberClient);
                    busi.addClient(newClient);
                    businessMapClient.put(newClient, business);
                    business.showClientBusiness(businessMapClient);
                }
                case 2 -> {
                    System.out.println("Enter the name of the business:");
                    String findNameBusiness = scanner.next();
                    scanner.nextLine();
                    Business business = businessMapString.get(findNameBusiness);
                    if (business != null) {
                        System.out.println("Enter the data for the manager, and then for the employees he is in charge of.");
                        System.out.println("Enter the name of the manager:");
                        String nameManager = scanner.next();
                        System.out.println("Enter the birthdate of the manager (yyyy-MM-dd):");
                        int year = scanner.nextInt();
                        int month = scanner.nextInt();
                        int day = scanner.nextInt();
                        LocalDate birthDateManager = LocalDate.of(year, month, day);
                        System.out.println("Enter the paycheck:");
                        int paycheckManager = scanner.nextInt();
                        System.out.println("Insert '1' if the manager is a top manager or '2' if he is a sub manager:");
                        int categoryManager = scanner.nextInt();
                        Manager manager = new Manager(nameManager, birthDateManager, paycheckManager, categoryManager);

                        // Add the new manager to the business
                        business.addManager(manager);

                        // ejer01_Business.Employee data
                        System.out.println("Enter a new employee:");
                        String nameEmployee = scanner.next();
                        System.out.println("Enter the birthdate of the employee (yyyy-MM-dd):");
                        int year02 = scanner.nextInt();
                        int month02 = scanner.nextInt();
                        int day02 = scanner.nextInt();
                        LocalDate birthDateEmployee = LocalDate.of(year02, month02, day02);
                        System.out.println("Enter the paycheck:");
                        int paycheckEmployee = scanner.nextInt();
                        Employee employee = new Employee(nameEmployee, birthDateEmployee, paycheckEmployee);

                        // Add the new employee to the manager
                        manager.addEmployee(employee);
                    } else {
                        System.out.println("The business was not found.");
                    }
                    manag.showManagAndEmployee(managerMap);
                }

                case 3 ->
                {
                    System.out.println("Enter the name of the director you want to add employees to: ");
                    String findNameDirector = scanner.next();
                    scanner.nextLine();
                    emp.addEmpleadoToDirector(findNameDirector);
                    manag.showManagAndEmployee(managerMap);
                }

                case 4 -> {
                    System.out.println("Enter the name of the business: ");
                    String businessName = scanner.next();
                    if (businessMapString.containsKey(businessName)) {
                        System.out.println("Enter the name of the new client:");
                        String nameClient = scanner.next();
                        System.out.println("Enter the birthday: ");
                        int yearClient = scanner.nextInt();
                        int monthClient = scanner.nextInt();
                        int dayClient = scanner.nextInt();
                        LocalDate birthDate = LocalDate.of(yearClient, monthClient, dayClient);
                        System.out.println("Enter the phone number: ");
                        int phoneNumberClient = scanner.nextInt();
                        Cliente newClient = new Cliente(nameClient, birthDate, phoneNumberClient);
                        Business busi01 = businessMapString.get(businessName);
                        busi01.addClient(newClient);
                    } else {
                        System.out.println("The name of the business was not found.");
                    }
                }
                case 5 -> {
                    System.out.println("Enter the name of the business. ");
                    String findBusiness = scanner.next();
                    if (businessMapString.containsKey(findBusiness)) {
                        busi = businessMapString.get(findBusiness);
                        System.out.println("Enter the name of the client you want to delete: ");
                        String findClient = scanner.next();
                        Cliente cli = null;
                        for (Cliente client : busi.getClients()) {
                            if (client.getName().equals(findClient)) {
                                cli = client;
                                break;
                            }
                        }
                        if (cli != null) {
                            busi.removeClient(cli);
                            System.out.println("Client " + findClient + " removed from " + findBusiness);
                        } else {
                            System.out.println("Client " + findClient + " not found in " + findBusiness);
                        }
                    } else {
                        System.out.println("The name of the business was not found.");
                    }
                }
            }
        }
        while(choice >= 1 && choice <=7);
    }
}