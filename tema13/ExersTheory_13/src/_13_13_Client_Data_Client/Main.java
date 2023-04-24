package _13_13_Client_Data_Client;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Cliente [] clientArray = new Cliente [3];
        clientArray [0] = new Cliente("Mario", "1234A", LocalDate.parse("2004-08-10"));
        clientArray [1] = new Cliente("Alex", "1234B", LocalDate.parse("2005-09-11"));
        clientArray [2] = new Cliente("Carlota", "1234C", LocalDate.parse("2006-10-12"));

        Map<String, DataClient> map = Arrays.stream(clientArray)
                .collect(Collectors.toMap(Cliente::getDni, DataClient::new));

        Map<String, DataClient> sortedMap =
                //get a set of key-value pairs
                map.entrySet()
                .stream()
                //compare the age of each client
                .sorted(Comparator.comparingInt(entry -> entry.getValue().age()))
                .collect(Collectors.toMap(
                        //collects the sorted entries to a new map
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        //if there are duplicate key values, then the first is taken
                        (v1, v2) -> v1,
                        //store the values to a linked... to preserve the order of the entries
                        LinkedHashMap::new));
        System.out.println(sortedMap);
    }
}
