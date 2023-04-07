import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SumNumbersFromFile {
    public static void main(String[] args) {

        File file = new File("file.txt");
        int sum = 0;

        //para almacenar las lineas
        String line;

        //que lea
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            //mientras la linea a leer no sea nula
            while ((line = br.readLine()) != null) {
                //almacena los numeros del archivo
                String[] numbers = line.split(",");
                //recorre el array de numbers, almacenando los valores de numbers en num
                for (String num : numbers) {
                    //trim se usa para que quite espacios y cosas raras, queremos que solo tenga Integer
                    sum += Integer.parseInt(num.trim());
                }
            }
            System.out.println("Sum of numbers in file: " + sum);
        } catch (IOException e) {
            //esta funcion lo que hace es enseniarte lo que hay mal basicamente.
            e.printStackTrace();
        }
    }
}
