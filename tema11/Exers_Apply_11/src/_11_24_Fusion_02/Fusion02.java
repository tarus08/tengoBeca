package _11_24_Fusion_02;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Fusion02 {

    private String ficheroBase;
    private String ficheroNuevo;
    private List <String> _firstList_FicheroNuevo = new ArrayList<String>();
    private List <String> _secondList_FicheroNuevo = new ArrayList<String>();
    private List <String> _firstList_FicheroBase = new ArrayList<String>();
    private List <String> _secondList_FicheroBase = new ArrayList<String>();
    private List <String> _resultList = new ArrayList<String>();
    void fusionar (String ficheroBase, String ficheroNuevo){

        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(ficheroNuevo));
        ObjectOutputStream writer02 = new ObjectOutputStream(new FileOutputStream(ficheroBase))){

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the size of the lists ");
            int size = scanner.nextInt();
            scanner.nextLine();

            //ficheroNuevo content
            //first list
            for (int i = 0; i < size; i++){
                System.out.println("Enter the phrase " +(i+1)+ " for the first list in the " +ficheroNuevo+ " file");
                String phrase = scanner.nextLine();
                _firstList_FicheroNuevo.add(phrase);
            }

            Collections.sort(_firstList_FicheroNuevo);
            writer.writeObject(_firstList_FicheroNuevo);
            writer.flush();

            //second list
            for (int i = 0; i < size; i++) {
                System.out.println("Enter the phrase " +(i+1)+ " for the second list in the " +ficheroNuevo+ " file");
                String phrase = scanner.nextLine();
                _secondList_FicheroNuevo.add(phrase);
            }

            Collections.sort(_secondList_FicheroNuevo);
            writer.writeObject(_secondList_FicheroNuevo);
            writer.flush();

            //ficheroBase content
            //first list
            for (int i = 0; i < size; i++){
                System.out.println("Enter the phrase " +(i+1)+ " for the first list in the " +ficheroBase+ " file");
                String phrase = scanner.nextLine();
                _firstList_FicheroBase.add(phrase);
            }

            Collections.sort(_firstList_FicheroBase);
            writer02.writeObject(_firstList_FicheroBase);
            writer02.flush();

            //second list
            for (int i = 0; i < size; i++) {
                System.out.println("Enter the phrase " +(i+1)+ " for the second list in the " +ficheroBase+ " file");
                String phrase = scanner.nextLine();
                _secondList_FicheroBase.add(phrase);
            }

            Collections.sort(_secondList_FicheroBase);
            writer02.writeObject(_secondList_FicheroBase);
            writer02.flush();

            try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(ficheroNuevo));
            ObjectInputStream reader02 = new ObjectInputStream(new FileInputStream(ficheroBase))){

                //ficheroNuevo
                List<String> _ficheroNuevoLists_01 = (List<String>) reader.readObject();
                List<String> _ficheroNuevoLists_02 = (List<String>) reader.readObject();
                reader.close();

                _resultList.addAll(_ficheroNuevoLists_01);
                _resultList.addAll(_ficheroNuevoLists_02);

                //ficheroBase
                List<String> _ficheroBaseLists_01 = (List<String>) reader02.readObject();
                List<String> _ficheroBaseLists_02 = (List<String>) reader02.readObject();
                reader.close();

                _resultList.addAll(_ficheroBaseLists_01);
                _resultList.addAll(_ficheroBaseLists_02);

                Collections.sort(_resultList);

                try(ObjectOutputStream writer03 = new ObjectOutputStream(new FileOutputStream(ficheroBase))){
                    writer03.writeObject(_resultList);
                    writer03.flush();

                    System.out.print("These are the phrases arranged: ");
                    for (String line : _resultList){
                        System.out.print(line+ ", ");
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
