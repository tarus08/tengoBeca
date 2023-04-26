package _12_37_Furbol;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Jugador {
    static Scanner scanner = new Scanner (System.in);
    // Define a map to store the players on the team
    private static Map<Integer, Jugador> plantilla = new HashMap<Integer, Jugador>();
    private String name = " ";
    private static Position position;
    private int dni = 0;
    private double height = 0.0;

    public Jugador(String name, int dni, double height, Position position) {
        this.name = name;
        this.dni = dni;
        this.height = height;
        Jugador.position = position;
    }

    // Method to add a new player to the team
    public static void addPlayer(Map<Integer, Jugador> plantilla, Integer jerseyNumber)
    {
        System.out.println("Enter the dni, the name, the height and the position (portero, defensa, centrocampista, delantero) of the player");
        int dniPlayer = scanner.nextInt();
        String namePlayer = scanner.next();
        double heightPlayer = scanner.nextDouble();
        String pos = scanner.next().toUpperCase();
        Position position = Position.valueOf(pos);
        System.out.println("This is the position; " +position);
        Jugador jug = new Jugador(namePlayer, dniPlayer, heightPlayer, position);
        plantilla.put(jerseyNumber, jug);
    }

    public static Jugador deletePlayer(Map<Integer, Jugador> plantilla, Integer jerseyNumber)
    {
        if (plantilla.containsKey(jerseyNumber))
        {
            return plantilla.remove(jerseyNumber);
        }
        else
        {
            return null;
        }
    }

    public static void showJerseyName(Map<Integer, Jugador> plantilla)
    {
        for (Map.Entry<Integer, Jugador> entry : plantilla.entrySet())
        {
            Integer jerseyNumber = entry.getKey();
            Jugador jugador = entry.getValue();
            System.out.println("Jersey number: " + jerseyNumber + " name: " + jugador.getName());
        }
    }


    // Method to show a list of players that play in the same position
    static void showPos(Map<Integer,Jugador> plantilla, String position)
    {
        Position positionEnum = Position.valueOf(position.toUpperCase());
        for (Map.Entry<Integer, Jugador> entry : plantilla.entrySet())
        {
            Integer jerseyNumber = entry.getKey();
            Jugador jugador = entry.getValue();
            Position posicion = entry.getValue().getPosition();
            if (posicion == positionEnum)
            {
                System.out.println("Jersey number: " + jerseyNumber + " name: " + jugador.getName());
            }
            else
            {
                System.out.println("There is no player playing as " +position);
            }
        }
    }

    public static boolean editPlayer(Map<Integer, Jugador> plantilla, Integer jerseyNumber)
    {
        if (plantilla.containsKey(jerseyNumber))
        {
            Jugador juga = plantilla.get(jerseyNumber);
            System.out.println("Write the name for the player");
            String nameMod = scanner.next();
            System.out.println("Insert the new height for the player" );
            double heightMod = scanner.nextDouble();

            juga.setName(nameMod);
            juga.setHeight(heightMod);

            return true;
        }
        else
        {
            return false;
        }
    }
        public enum Position
    {
        PORTERO, DEFENSA, CENTROCAMPISTA, DELANTERO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public Position getPosition() {
        return position;
    }
}
