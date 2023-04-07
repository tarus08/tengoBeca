package programa11_32;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Llamada9_31> calls = new ArrayList<Llamada9_31>();
        System.out.println("How many calls do you want?");
        int numOfCalls = scanner.nextInt();

        for (int i = 0; i < numOfCalls; i++){
            Llamada9_31.differenceMinutes();
            Llamada9_31.calculateCostPerMinute();
            Llamada9_31.orderByPhoneNumberClient();
        }
    }
}
