package _11_28_29_Socio;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Socio> socioList = new ArrayList<Socio>();
        List<Familiar> relativesList= new ArrayList<Familiar>();
        Familiar fam;
        int addRelative = 0;
        int choice = 0;

        do {
            System.out.println("Enter:\n" +
                    "'1' To add a new socio (by adding a socio you also have the option to add relatives)\n" +
                    "'2' To remove a socio (by removing a socio you also are removing his relatives)\n" +
                    "'3' To modify the contents of socios\n" +
                    "'4' To order socios alphabetically\n" +
                    "'5' To order socios by their seniority in the club\n" +
                    "'6' To order socios by the age of their relatives\n" +
                    "'7' To exit ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                        //id socio
                        System.out.println("Enter the id for the new socio");
                        int newId = scanner.nextInt();
                        scanner.nextLine();

                        //name socio
                        System.out.println("Enter the name of the new socio");
                        String newName = scanner.nextLine();

                        //fechaNacimiento socio
                        System.out.println("Enter the year, month, day the new socio was born");
                        int year = scanner.nextInt();
                        int month = scanner.nextInt();
                        int day = scanner.nextInt();
                        LocalDate newBirthDate = LocalDate.of(year, month, day);

                        //fechaAlta socio
                        System.out.println("Enter the year, month, day the new socio was dado de alta");
                        int year02 = scanner.nextInt();
                        int month02 = scanner.nextInt();
                        int day02 = scanner.nextInt();
                        LocalDate newFechaAlta = LocalDate.of(year02, month02, day02);

                        //phone number socio
                        System.out.println("Enter the phone number of the new socio");
                        int newPhoneNumber = scanner.nextInt();
                        scanner.nextLine();

                        //email socio
                        System.out.println("Enter the new email of the new socio");
                        String newEmail = scanner.nextLine();
                        // Define the regular expression pattern for an email address
                        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
                        // Check if the input matches the email pattern
                        Matcher matcher = pattern.matcher(newEmail);
                        if (matcher.matches()) {
                            System.out.println("Valid email address!");
                        } else {
                            System.out.println("Invalid email address!");
                        }

                        //relatives
                        do {
                            System.out.println("Add a new relative, enter any number different to '-1' add a relative");
                            addRelative = scanner.nextInt();
                            scanner.nextLine();

                                //dni for the relative
                                System.out.println("Enter a dni for the relative");
                                int relativeDni = scanner.nextInt();
                                scanner.nextLine();

                                //name for the relative
                                System.out.println("Enter the name of the relative");
                                String relativeName = scanner.nextLine();

                                //birth date for the relative
                                System.out.println("Enter the birth date for the relative following this format: yyyy/mm/dd");
                                int relativeYear = scanner.nextInt();
                                int relativeMonth = scanner.nextInt();
                                int relativeDay = scanner.nextInt();
                                LocalDate relativeBirthDate = LocalDate.of(relativeYear, relativeMonth, relativeDay);

                                fam = new Familiar(relativeDni, relativeName, relativeBirthDate);
                                relativesList.add(fam);

                        } while (addRelative != -1);

                        Socio newSocio = new Socio (newId, newName, newBirthDate, newFechaAlta, newPhoneNumber, newEmail, relativesList);
                        socioList.add(newSocio);
                        scanner.nextLine();

                    break;

                case 2:

                    System.out.println("Enter the index for the socio you want to delete");
                    int indexRemove = scanner.nextInt();
                    socioList.remove(indexRemove);

                    break;

                case 3:

                    List<Familiar> relativesListForMod = new ArrayList<Familiar>();
                    relativesListForMod.addAll(relativesList);
                    System.out.println("Enter the index to modify a socio");
                    int index02 = scanner.nextInt();
                    scanner.nextLine();

                    if (index02 < socioList.size() && index02 >= 0) {
                        Socio oldSocio = socioList.get(index02);

                        //name
                        System.out.println("Enter the new name for the socio " +index02);
                        String newNameMod = scanner.nextLine();

                        //fechaNacimiento
                        System.out.println("Enter the new birthdate for socio "+index02+ ", follow this format: year, month, day ");
                        int yearMod = scanner.nextInt();
                        int monthMod = scanner.nextInt();
                        int dayMod = scanner.nextInt();
                        LocalDate newBirthDateMod = LocalDate.of(yearMod, monthMod, dayMod);

                        //fechaAlta
                        System.out.println("Enter the new fecha de alta for socio " +index02+" follow this format: year, month, day ");
                        int year02Mod = scanner.nextInt();
                        int month02Mod = scanner.nextInt();
                        int day02Mod = scanner.nextInt();
                        LocalDate newFechaAltaMod = LocalDate.of(year02Mod, month02Mod, day02Mod);

                        //phone number
                        System.out.println("Enter the phone number of the new socio");
                        int newPhoneNumberMod = scanner.nextInt();
                        scanner.nextLine();

                        //email
                        System.out.println("Enter the new email of the new socio");
                        String newEmailMod = scanner.nextLine();
                        // Define the regular expression pattern for an email address
                        Pattern patternMod = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
                        Matcher matcherMod = patternMod.matcher(newEmailMod);
                        // Check if the input matches the email pattern
                        if (matcherMod.matches()) {
                            System.out.println("Valid email address!");
                        } else {
                            System.out.println("Invalid email address!");
                        }

                        Socio newSocioMod = new Socio (oldSocio.getNum_socio(), newNameMod, newBirthDateMod, newFechaAltaMod, newPhoneNumberMod, newEmailMod, relativesListForMod);
                        socioList.set (index02, newSocioMod);

                }else{
                        System.out.println("Enter a valid index");
                    }
                    break;

                case 4:
                    Comparator <Socio> comparator01 = new Comparator<Socio>(){
                        public int compare(Socio s1, Socio s2) {
                            return s1.getName().compareTo(s2.getName());
                        }
                };
                    Collections.sort(socioList, comparator01);
                    for (Socio s : socioList){
                        System.out.println("The socios sorted by name: " +s.getNum_socio()+ "/" +s.getName()+ "/" +s.getBirthDate()+ "/" +s.getFechaAlta()+ "/" +s.getPhoneNumber()+ "/" +s.getEmail());
                    }

                    break;

                case 5:

                    Comparator <Socio> comparator02 = new Comparator<Socio>() {
                        public int compare(Socio s1, Socio s2) {
                            return s1.getFechaAlta().compareTo(s2.getFechaAlta());
                        }
                    };
                    Collections.sort(socioList, comparator02);
                    for (Socio s : socioList){
                        System.out.println("The socios sorted by seniority: " +s.getNum_socio()+ "/" +s.getName()+ "/" +s.getBirthDate()+ "/" +s.getFechaAlta()+ "/" +s.getPhoneNumber()+ "/" +s.getEmail()+ "/" +s.getRelatives());
                    }

                    break;

                case 6:

                    for (Socio s : socioList){
                        List<Familiar>relatives = s.getRelatives();
                        Comparator <Familiar> comparator03 = new Comparator<Familiar>() {
                            public int compare(Familiar f1, Familiar f2) {
                                return f1.getBirthDate().compareTo(f2.getBirthDate());
                            }
                        };
                    Collections.sort(relativesList, comparator03);
                        System.out.println("Socio: " + s.getNum_socio() + "/" + s.getName() + "/" + s.getBirthDate() + "/" + s.getFechaAlta() + "/" + s.getPhoneNumber() + "/" + s.getEmail());
                        System.out.println("Relatives (sorted by age):");
                        for (Familiar r : relatives) {
                            System.out.println(r.getDni() + "/" + r.getName() + "/" + r.getBirthDate() + "/");
                        }
                    }
                    break;

                case 7:
                    try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("sociosFile.dat"))){
                        writer.writeObject(socioList);
                    }catch (IOException e){
                        System.out.println("There was an error writing" + e.getMessage());
                    }
            }
        }while(choice >= 0 && choice < 7);

    }

}
