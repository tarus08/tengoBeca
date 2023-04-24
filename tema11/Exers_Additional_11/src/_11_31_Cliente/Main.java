package _11_31_Cliente;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<ClienteBanco> clienteList = new ArrayList<ClienteBanco>();
        int choice = 0;
        LocalDate newBirthday;

        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream("FileClienteBanco.dat"))){
            reader.readObject();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        do {

            System.out.println("Enter:\n" +
                    "'1' To add a new client\n" +
                    "'2' To remove a client\n" +
                    "'3' To show the clients\n" +
                    "'4' To exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Enter the dni for the new client");
                    String newDni = scanner.nextLine();
                    System.out.println("Enter the name for the new client");
                    String newName = scanner.nextLine();
                    System.out.println("Enter the money the new client has");
                    double newMoney = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Enter the birth date for the new client following this format: year, month, day");
                    int year = scanner.nextInt();
                    int month = scanner.nextInt();
                    int day = scanner.nextInt();
                    scanner.nextLine();
                    newBirthday = LocalDate.of(year, month, day);

                    ClienteBanco newClient = new ClienteBanco(newDni, newName, newMoney, newBirthday);
                    clienteList.add(newClient);

                    Comparator<ClienteBanco> dniComparator = new Comparator<ClienteBanco>() {
                        public int compare(ClienteBanco c1, ClienteBanco c2) {
                            return c1.getDni().compareTo(c2.getDni());
                        }
                    };
                    Collections.sort(clienteList, dniComparator);
                    for (ClienteBanco c : clienteList) {
                        System.out.println("The clients sorted by dni:\n" +
                                "DNI: " + c.getDni()+
                                "\nName: " + c.getName()+
                                "\nMoney: " + c.getMoney()+
                                "\nBirthdate: " + c.getBirthDate());
                    }

                    break;

                case 2:
                    System.out.println("Enter the index of the client to remove");
                    int indexClientRemove = scanner.nextInt();
                    System.out.println("The client removed is: \n" +clienteList.get(indexClientRemove));
                    clienteList.remove(indexClientRemove);

                    break;

                case 3:

                    //max, min and average money of the clients
                    double maxMoney = Double.MIN_VALUE;
                    double minMoney = Double.MAX_VALUE;
                    double totalMoney = 0;
                    double avgMoney = 0;

                    for (ClienteBanco client : clienteList) {
                        double money = client.getMoney();
                        if (money > maxMoney) {
                            maxMoney = money;
                        }
                        if (money < minMoney){
                            minMoney = money;
                        }
                        totalMoney += money;
                    }

                    avgMoney = totalMoney/clienteList.size();

                    for (ClienteBanco c : clienteList) {
                        LocalDate now = LocalDate.now();
                        //restar anios
                        long age = ChronoUnit.YEARS.between(c.getBirthDate(), now);
                        System.out.println("DNI: " + c.getDni() +
                                "\nName: " + c.getName() +
                                "\nThe money: " + c.getMoney() +
                                "\nThe maximum money: " + maxMoney +
                                "\nThe minimum money: " + minMoney +
                                "\nThe average money: " + avgMoney +
                                "\nAge: " + age);
                    }
                    break;

                case 4:
                    try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("FileClienteBanco.dat"))){
                        writer.writeObject(clienteList);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
            }
        }while (choice < 4);
    }
}
