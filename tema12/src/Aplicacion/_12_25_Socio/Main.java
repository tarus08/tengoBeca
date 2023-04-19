package Aplicacion._12_25_Socio;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main <NickName>{
    public static <NickName> void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<NickName, Socio> mapSocio = new HashMap<NickName, Socio>();

        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream("club.dat"))) {
            reader.readObject();
        }catch (IOException | ClassNotFoundException ignored) {

        }

        int choice = 0;

        do {
            System.out.println("""
                    Enter:\s
                    '1' To add a new socio.\s
                    '2' To delete a socio.\s
                    '3' To modify a socio.\s
                    '4' To list socios by nickname
                    '5' To list socios by aniquity
                    '6' To list socios by a determined year
                    '7' To exit""");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the nickname for the new socio");
                    NickName newNickName = (NickName) scanner.next();
                    altaMod(mapSocio, newNickName);
                }
                case 2 -> {
                    System.out.println("Enter the nickname for the socio you want to delete:");
                    NickName nickNameDel = (NickName) scanner.next();
                    mapSocio.remove(nickNameDel);
                    printMap(mapSocio);
                }
                case 3 -> {
                    System.out.println("Enter the nickname for the socio you want to modify");
                    NickName nickNameMod = (NickName) scanner.next();
                    mapSocio.remove(nickNameMod);
                    altaMod(mapSocio, nickNameMod);
                }
                case 4 -> {
                    Comparator<Socio> compareNickName = new Comparator<Socio>() {
                        @Override
                        public int compare(Socio o1, Socio o2) {
                            return o1.getNickname().compareTo(o2.getNickname());
                        }
                    };
                    Set<Socio> socio01 = new TreeSet<>(compareNickName);
                    socio01.addAll(mapSocio.values());
                    printSet(socio01);
                }
                case 5 -> {
                    Comparator<Socio> compareAntiquity = new Comparator<Socio>() {
                        @Override
                        public int compare(Socio o1, Socio o2) {
                            return o1.getDate().compareTo(o2.getDate());
                        }
                    };
                    Set<Socio> socio02 = new TreeSet<>(compareAntiquity);
                    socio02.addAll(mapSocio.values());
                    printSet(socio02);
                }
                case 6 -> {
                    Comparator<Socio> compareAntiquityLess = new Comparator<Socio>() {
                        final LocalDate dateToCompare = LocalDate.of(2023, 12, 31);

                        @Override
                        public int compare(Socio o1, Socio o2) {
                            return o1.getDate().compareTo(dateToCompare);
                        }
                    };
                    Set<Socio> socio = new TreeSet<>(compareAntiquityLess);
                    socio.addAll(mapSocio.values());
                    printSet(socio);
                }
            }


        }while (choice >= 1 && choice <= 6);

        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("club.dat"))){
            writer.writeObject(mapSocio);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printSet(Set<Socio> socio01) {
        for (Socio socio : socio01){
            System.out.println(socio);
        }
    }

    private static <NickName> void altaMod(Map<NickName, Socio> mapSocio, NickName newNickName) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the new socio");
        String newName = scanner.nextLine();
        System.out.println("Enter the date of admission of the new socio (yyyy-MM-dd)");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        LocalDate newDateOfAdmission = LocalDate.of(year, month, day);
        Socio so = new Socio((String) newNickName, newName, newDateOfAdmission);
        mapSocio.put(newNickName, so);
        printMap(mapSocio);
    }

    public static <NickName> void printMap (Map<NickName, Socio> socioMap){
        for (Map.Entry<NickName, Socio> entry : socioMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
