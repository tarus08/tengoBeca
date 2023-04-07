package programa11_32;

import java.io.*;
import java.security.spec.RSAOtherPrimeInfo;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class Centralita {

    public static void main(String[] args) throws FileNotFoundException {

        Llamada9_31 [] llamadaArray = new Llamada9_31[10];

        String archivoVacio = "este archivo ya no esta vacio";

        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("centralita.dat"))){
            writer.writeObject(archivoVacio);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream("centralita.dat"))){
            reader.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        int phoneNumberClient = 0;
        int phoneNumberWorker = 0;
        LocalDateTime beginningCall = null;
        LocalDateTime endCall = null;

        do{
            System.out.println("Enter: \n" +
                    "'1' To add a new call\n" +
                    "'2' To list the phone calls of a phone number\n" +
                    "'3' To list all the phone calls\n" +
                    "'4' To exit.");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:

                    System.out.println("Enter the phone number for the client");
                    phoneNumberClient = scanner.nextInt();
                    System.out.println("Enter the phone number for the worker");
                    phoneNumberWorker = scanner.nextInt();

                    //beginning of the call
                    System.out.println("Enter the date and time following this format: yyyy-MM-dd HH:mm:ss");
                    String yearBeginning = scanner.next();
                    String monthBeginning = scanner.next();
                    String dayBeginning = scanner.next();
                    String hourBeginning = scanner.next();
                    String minuteBeginning = scanner.next();
                    String secondsBeginning = scanner.next();

                    //concatenate user input into a single string
                    String beginningString = yearBeginning + "-" + monthBeginning + "-" + dayBeginning + " " + hourBeginning + ":" + minuteBeginning + ":" + secondsBeginning;
                    beginningCall = LocalDateTime.parse(beginningString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    System.out.println("Beginning of call: " +beginningCall);

                    //end of the call
                    System.out.println("Enter the date and time following this format: yyyy-MM-dd HH:mm:ss");
                    String yearEnd = scanner.next();
                    String monthEnd = scanner.next();
                    String dayEnd = scanner.next();
                    String hourEnd = scanner.next();
                    String minuteEnd = scanner.next();
                    String secondsEnd = scanner.next();

                    //concatenate user input into a single string
                    String endString = yearEnd + "-" + monthEnd + "-" + dayEnd + " " + hourEnd + ":" + minuteEnd + ":" + secondsEnd;
                    endCall = LocalDateTime.parse(endString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    System.out.println("End of call: " +endCall);

                    Llamada9_31 llamadaCentralita = new Llamada9_31(phoneNumberClient, phoneNumberWorker, false, beginningCall, endCall);

                    int counter = 0;
                    for (int i = 0; i < llamadaArray.length; i++) {
                        if (llamadaArray[i] == null){
                            llamadaArray[i] = llamadaCentralita;
                            counter++;
                            break;
                        }
                    }
                    if (counter == llamadaArray.length){
                        System.out.println("The array is full. ");
                    }else{
                        for (int i = 0; i < counter; i ++) {
                            llamadaArray[i] = llamadaCentralita;
                        }
                    }

                    break;

                case 2:

                    Llamada9_31 selectedCall = null;
                    System.out.println("Enter the phone number you want to see the calls of");
                    int phoneNumberCheck = scanner.nextInt();
                    boolean found = false;
                    for (int i = 0; i < llamadaArray.length; i++) {
                        if (llamadaArray[i] != null && (llamadaArray[i].getPhoneNumClient() == phoneNumberCheck || llamadaArray[i].getPhoneNumberWorker() == phoneNumberCheck)) {
                            selectedCall = llamadaArray[i];
                            found = true;
                            System.out.println("Call " + (i+1) + ": " + llamadaArray[i]);
                        }
                    }
                    if (!found) {
                        System.out.println("No calls found for phone number " + phoneNumberCheck);
                    }else{
                        //calculate the difference between the start and end of the call
                        Duration duration = Duration.between(selectedCall.getBeginningCall(), selectedCall.getEndCall());
                        long minutes = duration.toMinutes();
                        System.out.println("This is the difference between the start and end of the call: " +minutes);
                    }

                    break;

                case 3:

                    for (int i = 0; i < 1; i++){
                        if (llamadaArray != null) {
                            System.out.println((i + 1) + ": " + llamadaArray[i]);
                        }
                    }

                    //calculate the difference between the start and end of the call
                    Duration duration02 = Duration.between(beginningCall, endCall);
                    long minutes02 = duration02.toMinutes();
                    System.out.println("This is the difference between the start and end of the call: " +minutes02);

                    break;

                case 4:
                    try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("centralita.dat"))){
                        writer.writeObject(llamadaArray);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
            }
        }while(choice > 0 && choice < 4);
    }

}
