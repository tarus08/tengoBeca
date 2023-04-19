package Ampliacion._11_27_Deportista;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static Ampliacion._11_27_Deportista.Deportes.NATACION;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        File file = new File("deportesFile.dat");
        if(file.exists() && file.length() > 0) {
            try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))){
                Deportista [] showDep = (Deportista[])reader.readObject();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("The file is empty");
        }

        LocalDate fecha = LocalDate.of(2012, 10,2);

        Deportista [] dep = new Deportista[1];
        LocalDate birthDate = LocalDate.of(2004,10,8);
        dep[0] = new Deportista(123, "mario", birthDate, NATACION);

        int choice = 0;
        do{
            System.out.println("Enter:\n" +
                    "'1' to add a new deportista.\n" +
                    "'2' to remove one deportista.\n" +
                    "'3' to modify data of the deportista\n"+
                    "'4' to list alphabetically by name.\n"+
                    "'5' to list numerically by age.\n"+
                    "'6' to exit");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Enter a dni");
                    int newDni = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter a name");
                    String newName = scanner.nextLine();
                    System.out.println("Enter the year, month, day");
                    int year = scanner.nextInt();
                    int month = scanner.nextInt();
                    int day = scanner.nextInt();
                    LocalDate newDate = LocalDate.of(year,month, day);
                    System.out.println("Enter a new sport (1 for NATACION, 2 for REMO, 3 for VELA, 4 for  WATERPOLO):");
                    int sportChoice = scanner.nextInt();
                    Deportes sport = Deportes.values()[sportChoice - 1];

                    Deportista []  addDep = new Deportista[dep.length+1];
                    for (int i = 0; i < dep.length; i++){
                        addDep[i] = dep[i];
                    }
                    addDep[addDep.length-1] = new Deportista(newDni, newName, newDate, sport);
                    dep = addDep;

                    break;

                case 2:
                    System.out.println("Enter the index of the deportista you want to erase");
                    int index = scanner.nextInt();
                    Deportista [] delDep = new Deportista[dep.length-1];
                    int j = 0;
                    for (int i = 0; i < delDep.length; i++){
                        if (i != index){
                            delDep[j] = dep[i];
                            j++;
                        }
                    }
                    dep = delDep;

                    break;

                case 3:
                    System.out.println("Insert the index for the deportista to modify");
                    int indexMod = scanner.nextInt();
                    scanner.nextLine();

                    //set the new name
                    System.out.println("Enter a new name:");
                    String newName02 = scanner.nextLine();
                    dep[indexMod].setName(newName02);

                    //set the new birth date
                    System.out.println("Enter a new birthdate (year, month, day):");
                    int year02 = scanner.nextInt();
                    int month02 = scanner.nextInt();
                    int day02 = scanner.nextInt();
                    LocalDate newBirthdate = LocalDate.of(year02, month02, day02);
                    dep[indexMod].setBirthDate(newBirthdate);

                    //set the new sport
                    System.out.println("Enter a new sport (1 for NATACION, 2 for REMO, 3 for VELA, 4 for  WATERPOLO):");
                    int sportChoice02 = scanner.nextInt();
                    Deportes newSport = Deportes.values()[sportChoice02 - 1];
                    dep[indexMod].setSport(newSport);
                    break;

                case 4:
                    //order by name
                    Arrays.sort(dep, new Comparator<Deportista>(){
                    @Override
                    public int compare(Deportista d1, Deportista d2){
                        return d1.getName().compareTo(d2.getName());
                    }
                });
                    for (Deportista d : dep){
                        System.out.println("The deportistas sorted by name: DNI: " +d.getDni()+ " /name " +d.getName()+ " /birth date " + d.getBirthDate()+ " /sport " +d.getSport());
                    }
                    break;

                case 5:
                    //order by age
                    Arrays.sort(dep, new Comparator<Deportista>(){
                        @Override
                        public int compare(Deportista d1, Deportista d2){
                            return d1.getBirthDate().compareTo(d2.getBirthDate());
                        }
                });

                    for(Deportista d : dep){
                        System.out.println("The deportistas sorted by birth date:  DNI: " +d.getDni()+ " /name " +d.getName()+ " /birth date " + d.getBirthDate()+ " /sport " +d.getSport());
                    }
                    break;

                case 6:
                    try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))){
                        writer.writeObject(dep);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
            }
        }while(choice >= 0 && choice < 6);
    }
}
