package programa11_25;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class CuatroFicheros {

    private String _fichero1 = "fichero1_11_25.dat";
    private String _fichero2 = "fichero2_11_25.dat";
    private String _fichero3 = "fichero3_11_25.dat";
    private String _fichero4 = "fichero4_11_25.dat";

    private String [] _ficherosJuntos = {_fichero1, _fichero2, _fichero3, _fichero4};
    void VerifiyNumber (){
        try(ObjectOutputStream writer01 = new ObjectOutputStream(new FileOutputStream(_fichero1));
            ObjectOutputStream writer02 = new ObjectOutputStream(new FileOutputStream(_fichero2));
            ObjectOutputStream writer03 = new ObjectOutputStream(new FileOutputStream(_fichero3));
            ObjectOutputStream writer04 = new ObjectOutputStream(new FileOutputStream(_fichero4))){

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the size of the arrays for the files");
            int _size = scanner.nextInt();
            scanner.nextLine();

            Integer [] _nums = new Integer[_size];

            //first file
            for (int i = 0; i < _size; i++){
                System.out.println("Enter the number " +(i+1)+" of the array for the first file.");
                _nums[i] = scanner.nextInt();
            }
            Arrays.sort(_nums);
            writer01.writeObject(_nums);
            writer01.flush();

            //second file
            for (int i = 0; i < _size; i++){
                System.out.println("Enter the number " +(i+1)+" of the array for the second file.");
                _nums[i] = scanner.nextInt();
            }
            Arrays.sort(_nums);
            writer02.writeObject(_nums);
            writer02.flush();

            //third file
            for (int i = 0; i < _size; i++){
                System.out.println("Enter the number " +(i+1)+" of the array for the third file.");
                _nums[i] = scanner.nextInt();
            }
            Arrays.sort(_nums);
            writer03.writeObject(_nums);
            writer03.flush();

            //fourth file
            for (int i = 0; i < _size; i++){
                System.out.println("Enter the number " +(i+1)+" of the array for the forth file.");
                _nums[i] = scanner.nextInt();
            }
            Arrays.sort(_nums);
            writer04.writeObject(_nums);
            writer04.flush();

            try(ObjectInputStream reader01 = new ObjectInputStream(new FileInputStream(_fichero1));
                ObjectInputStream reader02 = new ObjectInputStream(new FileInputStream(_fichero2));
                ObjectInputStream reader03 = new ObjectInputStream(new FileInputStream(_fichero3));
                ObjectInputStream reader04 = new ObjectInputStream(new FileInputStream(_fichero4))) {

                Integer[] _numsFichero1 = (Integer[]) reader01.readObject();
                Integer[] _numsFichero2 = (Integer[]) reader02.readObject();
                Integer[] _numsFichero3 = (Integer[]) reader03.readObject();
                Integer[] _numsFichero4 = (Integer[]) reader04.readObject();

                System.out.println("Now enter a new number, the program checks if the number is in any of the files");
                int _findNumber = scanner.nextInt();

                boolean found = false;

                //verify if the number is in the first file
                for (int i = 0; i < _size; i++) {
                    if (_numsFichero1[i] == _findNumber) {
                        found = true;
                        System.out.println("The number " + _findNumber + " was found in the: " + _ficherosJuntos[0] + " file in the " + i + " position of the array.");
                        break;
                    }
                }

                //verify if the number is in the second file
                for (int i = 0; i < _size; i++) {
                    if (_numsFichero2[i] == _findNumber) {
                        found = true;
                        System.out.println("The number " + _findNumber + " was found in the: " + _ficherosJuntos[1] + " file in the " + i + " position of the array.");
                        break;
                    }
                }

                //verify if the number is in the third file
                for (int i = 0; i < _size; i++) {
                    if (_numsFichero3[i] == _findNumber) {
                        found = true;
                        System.out.println("The number " + _findNumber + " was found in the: " + _ficherosJuntos[2] + " file in the " + i + " position of the array.");
                        break;
                    }
                }

                //verify if the number is in the fourth file
                for (int i = 0; i < _size; i++) {
                    if (_numsFichero4[i] == _findNumber) {
                        found = true;
                        System.out.println("The number " + _findNumber + " was found in the: " + _ficherosJuntos[3] + " file in the " + i + " position of the array.");
                        break;
                    }
                }

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}
