package _11_32_Llamada;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Llamada9_31 implements Serializable {

    static Collection<Llamada9_31> llamadaCollection = new ArrayList<>();
    static List<Llamada9_31> llamadaList = new ArrayList<Llamada9_31>(llamadaCollection);
    private Integer phoneNumClient;
    private Integer phoneNumberWorker;
    private boolean outgoing;
    private LocalDateTime beginningCall;
    private LocalDateTime endCall;
    private static long minutes;
    private static double totalCost;
    enum Zones
    {
        MADRID, BARCELONA, SEVILLA, MALAGA, ZARAGOZA;
    }
    static Scanner scanner = new Scanner(System.in);
    public Llamada9_31(Integer phoneNumClient, Integer phoneNumberWorker, boolean outgoing, LocalDateTime beginningCall, LocalDateTime endCall) {
        this.phoneNumClient = phoneNumClient;
        this.phoneNumberWorker = phoneNumberWorker;
        this.outgoing = outgoing;
        this.beginningCall = beginningCall;
        this.endCall = endCall;
    }
    public static long differenceMinutes(){

        System.out.println("Enter the phone number for the client");
        int phoneNumberClient = scanner.nextInt();
        System.out.println("Enter the phone number for the worker");
        int phoneNumberWorker = scanner.nextInt();

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
        LocalDateTime beginningCall = LocalDateTime.parse(beginningString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
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
        LocalDateTime endCall = LocalDateTime.parse(endString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("End of call: " +endCall);

        Llamada9_31 llamadaNew = new Llamada9_31 (phoneNumberClient, phoneNumberWorker, false, beginningCall, endCall);
        llamadaCollection.add (llamadaNew);
        Llamada9_31 [] llamadaarray = new Llamada9_31[llamadaList.size()];
        for (int i = 0; i < llamadaList.size();i++){
            llamadaarray[i] = llamadaList.get(i);
        }

        //calculate the difference between the start and end of the call
        Duration duration = Duration.between(beginningCall, endCall);
        long minutes = duration.toMinutes();
        System.out.println("This is the difference between the start and end of the call: " +minutes);
        return minutes;
    }
    public static double calculateCostPerMinute() {
        //outgoing or ingoing
        boolean outgoing = false;
        double costPerMinute = 0;
        System.out.println("Enter the duration of the call in minutes: ");
        int minutes = scanner.nextInt();
        System.out.println("Enter 'true' if the call is being made by the client, 'false' if the call is made by the worker");
        outgoing = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("Enter the name of the city: Madrid, Barcelona, Sevilla, Malaga, Zaragoza");
        String city = scanner.next();

        switch (city.toUpperCase()) {
            case "MADRID":
                costPerMinute = 5;
                break;
            case "BARCELONA":
                costPerMinute = 4;
                break;
            case "SEVILLA":
                costPerMinute = 3;
                break;
            case "MALAGA":
                costPerMinute = 2;
                break;
            case "ZARAGOZA":
                costPerMinute = 1;
                break;
            default:
                System.out.println("Invalid city name.");
                break;
        }
        if (outgoing == true) {
            totalCost = minutes * costPerMinute / 100;
            System.out.println("The cost of the outgoing call in " + city + " is: " + totalCost);
        } else {
            System.out.println("The call is being made by the worker, the cost of the call is 0");
        }
        return totalCost;
    }
    public static void orderByPhoneNumberClient() {
        Comparator<Llamada9_31> orderByPhoneNumberClient = new Comparator<Llamada9_31>(){
            public int compare(Llamada9_31 l1, Llamada9_31 l2) {
                int phoneNumberCompare = l1.getPhoneNumClient().compareTo(l2.getPhoneNumClient());
                if (phoneNumberCompare == 0){
                    return l1.getBeginningCall().compareTo(l2.getBeginningCall());
                }
                return phoneNumberCompare;
            }
        };

        llamadaList.sort(orderByPhoneNumberClient);
        for (Llamada9_31 llam : llamadaList) {
            System.out.println("Calls sorted by phone number of the client:" +llam);
        }
    }

    @Override
    public String toString() {
        return "Call: "+
                "\nPhone number client: " + phoneNumClient +
                "\nPhone number worker: " + phoneNumberWorker +
                "\nCall began at: " + beginningCall +
                "\nDuration in minutes: " + minutes +
                "\nCost: " + totalCost;
    }
    public Integer getPhoneNumClient() {
        return phoneNumClient;
    }
    public Integer getPhoneNumberWorker() {
        return phoneNumberWorker;
    }

    public LocalDateTime getBeginningCall() {
        return beginningCall;
    }
    public LocalDateTime getEndCall() {
        return endCall;
    }
}


