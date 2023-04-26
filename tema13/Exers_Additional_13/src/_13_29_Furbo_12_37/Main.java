package _13_29_Furbo_12_37;

import com.sun.source.doctree.SeeTree;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Map<Integer, Jugador> plantilla = new HashMap<Integer, Jugador>();

    public static void main(String[] args) {

        Jugador jug = new Jugador("pepe", 12, 42, _13_29_Furbo_12_37.Jugador.Position.DELANTERO);

        int option = 0;
        do {
            System.out.println("\nMENU");
            System.out.println("1. Add player");
            System.out.println("2. Delete player");
            System.out.println("3. Show players");
            System.out.println("4. Show players by position");
            System.out.println("5. Edit player");
            System.out.println("6. Exit");

            System.out.print("Enter an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1 ->
                {
                    System.out.println("Enter a jersey number for the new player; ");
                    int jerseyNumberAdd = scanner.nextInt();
                    Jugador.addPlayer(plantilla, jerseyNumberAdd);
                }

                case 2 ->
                {
                    System.out.println("Enter the jersey number for the player to delete; " );
                    int jerseyNumberDelete = scanner.nextInt();
                    Jugador.deletePlayer(plantilla, jerseyNumberDelete);
                }

                case 3 ->
                {
                    System.out.println("\nUsing the map: ");
                    Jugador.showJerseyName(plantilla);

                    System.out.println("\nUsing the stream: ");
                    plantilla.values().stream()
                            .map(Jugador::getName)
                            .forEach(System.out::println);
                }

                case 4 ->
                {
                    System.out.println("\nUsing the map: ");
                    System.out.println("Enter the position of the player (portero, defensa, centrocampista, delantero): ");
                    String pos = scanner.next().toUpperCase();
                    Jugador.showPos(plantilla, pos);

                    System.out.println("\nUsing the stream: ");
                    plantilla.values().stream()
                            .map(Jugador::getPosition)
                            .forEach(System.out::println);
                }

                case 5 ->
                {
                    System.out.println("Enter the jersey number of the player you want to edit");
                    int jerseyNumberEdit = scanner.nextInt();
                    Jugador.editPlayer(plantilla, jerseyNumberEdit);
                }

                case 6 ->
                {
                    System.out.println("Exiting...");
                }

                default->
                {
                    System.out.println("Invalid option!");
                }
            }
        } while (option != 6);
    }
}


