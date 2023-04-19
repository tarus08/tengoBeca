package Exercises_Theory._11_08_Socios;//hacer que copie el contenido a otro archivo .dat

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Socios [] so = new Socios[2];
        so [0] = new Socios ("Paco", 40);
        so [1] = new Socios ("Ana", 30);
        System.out.println(Arrays.deepToString(so));

        try(ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream("socios.dat"))){
            output.writeObject(so);
        }catch(Exception e){
            System.out.println(e);
        }

        try (ObjectInputStream input = new ObjectInputStream(
                new FileInputStream("socios.dat"))) {
            while (input.available() > 0) {
                Socios [] so_copy = (Socios[]) input.readObject();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}
