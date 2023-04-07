import java.io.*;
import java.util.Scanner;

/* tenemos dos ficheros, uno de entrada y otro de salida.
en el de entrada tenemos valores decimales, 5 filas de 2 numeros, separados unicamente por un espacio...
1.2 1.5
2.4 5.2
la columna de la izquierda es el radio (1.2 y 2.4)
la de la derecha la altura (1.5 y 5.2)
Volumen = pi * r al cuadrado * altura
siendo pi una constante 3,14159
 */
public class volumen {
    public static void main(String[] args) {

        String line;
        File datos = new File("datos.txt");
        String output = "resultado.txt";
        int count = 0;
        final double pi = 3.14159;
        double totalVolume = 0.0;

        try(Scanner reader = new Scanner(
                new FileReader(datos));
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(output))){

            while(count != 5){
                double radius = reader.nextDouble();
                double height = reader.nextDouble();
                double volume = pi * (radius * radius) * height;
                writer.write("El volumen del cilindro es "+radius+" * "+height+ " = " +volume);
                writer.newLine();
                count++;
                totalVolume += volume;
                writer.write("This is the total volume until this point: " +totalVolume);
                writer.newLine();

            }

        }catch(IOException e){
            System.out.println("Error ma g");
            e.printStackTrace();
        }
    }
}