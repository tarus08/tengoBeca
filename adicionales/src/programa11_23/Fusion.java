package programa11_23;

import java.io.*;
import java.util.*;

public class Fusion implements Serializable {
    Scanner scanner = new Scanner(System.in);

    //lists for the first file
    private List <Integer> _list_fichero1_1 = new ArrayList<Integer>();
    private List <Integer> _list_fichero1_2 = new ArrayList<Integer>();

    //lists for the second file
    private List <Integer> _list_fichero2_1 = new ArrayList<Integer>();
    private List <Integer> _list_fichero2_2 = new ArrayList<Integer>();

    //list to order the numbers on both files when they are merged
    private List <Integer> _list_fichero3 = new ArrayList<Integer>();
    private Integer [] result;


    //start of the method
    Integer [] fusionar (String fichero1, String fichero2) throws FileNotFoundException {

        try(ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(fichero1));
            ObjectOutputStream write02 = new ObjectOutputStream(new FileOutputStream(fichero2))){

            System.out.println("How many numbers do you want the lists to have?");
            int size = scanner.nextInt();

            //first list on the first file
            for(int i = 0; i < size; i++) {
                System.out.println("Enter the values for the first list in the first file");
                Integer numbers01 = scanner.nextInt();
                _list_fichero1_1.add(numbers01);
                Collections.sort(_list_fichero1_1);
            }

            //second list on the first file
            for(int i = 0; i < size; i++) {
                System.out.println("Enter the values for the second list in the first file");
                Integer numbers02 = scanner.nextInt();
                _list_fichero1_2.add(numbers02);
                Collections.sort(_list_fichero1_2);
            }

            //first list on the second file
            for(int i = 0; i < size; i++) {
                System.out.println("Enter the values for the first list in the second file");
                Integer numbers03 = scanner.nextInt();
                _list_fichero2_1.add(numbers03);
                Collections.sort(_list_fichero2_1);
            }

            //second list on the second file
            for(int i = 0; i < size; i++) {
                System.out.println("Enter the values for the second list in the second file");
                Integer numbers04 = scanner.nextInt();
                _list_fichero2_2.add(numbers04);
                Collections.sort(_list_fichero2_2);
            }

            write.writeObject(_list_fichero1_1);
            write.writeObject(_list_fichero1_2);
            write02.writeObject(_list_fichero2_1);
            write02.writeObject(_list_fichero2_2);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //read the files and store the values to the integer fichero3 array
        try(ObjectInputStream reader = new ObjectInputStream( new FileInputStream(fichero1));
        ObjectInputStream reader02 = new ObjectInputStream(new FileInputStream(fichero2))){

            // read the first file
            List<Integer> list1_1 = (List<Integer>) reader.readObject();
            List<Integer> list1_2 = (List<Integer>) reader.readObject();
            reader.close();

            List <Integer> list2_1 = (List<Integer>) reader02.readObject();
            List <Integer> list2_2 = (List<Integer>) reader02.readObject();
            reader02.close();

            //add the content of the lists to the list integer fichero3
            _list_fichero3.addAll(list1_1);
            _list_fichero3.addAll(list1_2);
            _list_fichero3.addAll(list2_1);
            _list_fichero3.addAll(list2_2);

            //convert the list fichero3 to an Integer array
            result = _list_fichero3.toArray(new Integer[_list_fichero3.size()]);
            Arrays.sort(result);

            System.out.print("These are the numbers ordered: ");
            System.out.println(Arrays.toString(result));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
