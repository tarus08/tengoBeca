package _12_35_Jornada;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class Jornada implements Serializable {

    private int dni;
    private LocalDateTime dateIn;
    private LocalDateTime dateOut;

    public Jornada(int dni, LocalDateTime dateIn, LocalDateTime dateOut) {
        this.dni = dni;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }

    public void switchOptions() {
        Scanner scanner = new Scanner(System.in);
        Collection<Jornada> collectionJornada = new ArrayList<>();
        int choice = 0;

        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("jornada.dat")))
        {
            writer.writeObject(collectionJornada);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream("jornada.dat")))
        {
            reader.readObject();
        } catch (IOException | ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        do
        {
            System.out.println("Enter:\n" +
                    "'1' To add a new worker.\n" +
                    "'2' To delete a worker .\n" +
                    "'3' To add a new jornada.\n" +
                    "'4' To show the jornada of a worker.\n" +
                    "'5' To sort the workers by dates.\n" +
                    "'6' To show the difference between the date in and the date out.\n"+
                    "'7' To exit.");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Insert the dni of the new worker: ");
                    int newDni = scanner.nextInt();
                    boolean workerExists = false;
                    for (Jornada jor : collectionJornada) {
                        if (newDni == jor.getDni()) {
                            System.out.println("This worker already exists.");
                            workerExists = true;
                            break;
                        }
                    }
                    if (!workerExists) {
                        System.out.println("This worker is new.");
                        LocalDateTime dateIn = LocalDateTime.now();
                        LocalDateTime dateOut = LocalDateTime.now();
                        Jornada newJor = new Jornada(newDni, dateIn, dateOut);
                        collectionJornada.add(newJor);
                    }
                }

                case 2 ->
                {
                    System.out.println("Enter the dni of the worker you want to fire: ");
                    int fireDni = scanner.nextInt();
                    collectionJornada.removeIf(jor -> jor.getDni() == fireDni);
                    System.out.println("The worker with dni: " + fireDni + " was fired.");
                }

                case 3 -> {
                    System.out.println("Insert the dni for the worker you want to add a work day to");
                    int newWorkDni = scanner.nextInt();
                    boolean dniFound = false;
                    Iterator<Jornada> iterator = collectionJornada.iterator();
                    while (iterator.hasNext()) {
                        Jornada jor = iterator.next();
                        if (newWorkDni == jor.getDni()) {
                            dniFound = true;
                            System.out.println("The dni was found");
                            System.out.println("Enter the date for the new jornada (yyyy-mm-dd : hh-mm-ss):");
                            int year = scanner.nextInt();
                            int month = scanner.nextInt();
                            int day = scanner.nextInt();
                            int hour = scanner.nextInt();
                            int minute = scanner.nextInt();
                            int second = scanner.nextInt();
                            LocalDateTime dateIn = LocalDateTime.of(year, month, day, hour, minute, second);

                            System.out.println("Enter the date for the new jornada (yyyy-mm-dd : hh-mm-ss):");
                            int year02 = scanner.nextInt();
                            int month02 = scanner.nextInt();
                            int day02 = scanner.nextInt();
                            int hour02 = scanner.nextInt();
                            int minute02 = scanner.nextInt();
                            int second02 = scanner.nextInt();
                            LocalDateTime dateOut = LocalDateTime.of(year02, month02, day02, hour02, minute02, second02);
                            Jornada newJor = new Jornada(newWorkDni, dateIn, dateOut);
                            collectionJornada.add(newJor);
                            System.out.println("The new jornada has been added");
                            break;
                        }
                    }
                    if (!dniFound) {
                        System.out.println("The dni was not found");
                    }
                }
                case 4 -> {
                    System.out.println("Enter the dni of the worker you want to see the jornadas for: ");
                    int dniToSearch = scanner.nextInt();
                    List<Jornada> jornadasOfWorker = new ArrayList<>();
                    for (Jornada jor : collectionJornada) {
                        if (dniToSearch == jor.getDni()) {
                            jornadasOfWorker.add(jor);
                        }
                    }
                    if (jornadasOfWorker.isEmpty()) {
                        System.out.println("No jornadas found for the worker with dni: " + dniToSearch);
                    } else {
                        System.out.println("The jornadas of the worker with dni: " + dniToSearch);
                        for (Jornada jor : jornadasOfWorker) {
                            System.out.println(jor.toString());
                        }
                    }
                }
                case 5 ->
                {
                    List <Jornada> newList = new ArrayList<Jornada>(collectionJornada);
                    Comparator<Jornada> compareDni = new Comparator<Jornada>() {
                        @Override
                        public int compare(Jornada o1, Jornada o2)
                        {
                            return  o1.getDateIn().compareTo(o2.getDateIn()) +
                            o1.getDateOut().compareTo(o2.getDateOut());
                        }
                    };
                    newList.sort(compareDni);
                    for (Jornada jor : newList)
                    {
                        System.out.println(jor.toString());
                    }
                }
                case 6 ->
                {
                    getMinuteDifference();
                }
            }
            try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("jornada.dat")))
            {
                writer.writeObject(collectionJornada);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        while (choice >= 1 && choice <= 6);
    }
    public String toString()
    {
        return "dni: " + getDni() + " date in: " + getDateIn() + " date out: " + getDateOut() + " minute difference: " +getMinuteDifference();
    }
    public int getDni()
    {
        return dni;
    }
    public void setDni()
    {
        this.dni = dni;
    }
    public LocalDateTime getDateIn()
    {
        return dateIn;
    }
    public LocalDateTime getDateOut()
    {
        return dateOut;
    }
    public Duration getMinuteDifference()
    {
        Duration diff = Duration.between(getDateIn(), getDateOut());
        System.out.println("This is the difference of minutes: " + diff);
        return diff;
    }
}

