package _11_26_Registro_Temperature;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Registro record = new Registro(35.0, -10.3, "08/10/2004");
        Registro [] recordArray = {record};

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("weatherData.dat"))) {
            recordArray = (Registro[]) objectInputStream.readObject();
            if (recordArray != null) {
                System.out.println("Existing records loaded.");
            }
        } catch (IOException | ClassNotFoundException e) {
            recordArray = new Registro[0];
            System.out.println("No existing records found.");
        }

        int choice = 0;

        do {
            System.out.println("Enter: \n'1' to add a new record\n" +
                    "'2' to show the history\n" +
                    "'3' to show the stats\n" +
                    "'4' to exit the loop\n");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    System.out.println("Enter the maximum and minimum temperatures and the date.");
                    double askedMaxTemperature = scanner.nextDouble();
                    double askedMinTemperature = scanner.nextDouble();
                    scanner.nextLine();
                    String askedDate = scanner.nextLine();
                    Registro newRegistro = new Registro(askedMaxTemperature, askedMinTemperature, askedDate);
                    Registro[] newRecord = new Registro[recordArray.length + 1];

                    Registro[] newRegistroArray = new Registro[recordArray.length + 1];
                    for (int i = 0; i < recordArray.length; i++) {
                        newRecord[i] = recordArray[i];
                    }

                    newRecord[recordArray.length] = newRegistro;
                    recordArray = newRecord;

                    break;

                case 2:

                    String[][] showContent02 = new String[recordArray.length][4];
                    for (int i = 0; i < recordArray.length; i++) {

                        showContent02[i][0] = Double.toString(recordArray[i].getMaxTemp());
                        showContent02[i][1] = Double.toString(recordArray[i].getMinTemp());
                        double variation = recordArray[i].getMaxTemp() - recordArray[i].getMinTemp();
                        showContent02[i][2] = Double.toString(variation); // Add this line
                        showContent02[i][3] = recordArray[i].getDate();

                    }

                    System.out.println("Max Temp\tMin Temp\tVariation\tDate");
                    for (int i = 0; i < showContent02.length; i++) {
                        for (int j = 0; j < showContent02[i].length; j++) {
                            System.out.print(showContent02[i][j] + "\t\t\t");
                        }
                        System.out.println();
                    }

                    break;

                case 3:

                    double maxTempSum = 0;
                    double minTempSum = 0;
                    double maxTempAvg, minTempAvg;
                    double maxTempMax = Double.MIN_VALUE;
                    double maxTempMin = Double.MAX_VALUE;
                    double minTempMax = Double.MIN_VALUE;
                    double minTempMin = Double.MAX_VALUE;
                    double varMax = Double.MIN_VALUE;
                    double varMin = Double.MAX_VALUE;

                    for (Registro reg : recordArray) {
                        double maxTemp = reg.getMaxTemp();
                        double minTemp = reg.getMinTemp();
                        double variation = maxTemp - minTemp;

                        maxTempSum += maxTemp;
                        minTempSum += minTemp;

                        // Check for new max and min values
                        if (maxTemp > maxTempMax) {
                            maxTempMax = maxTemp;
                        }
                        if (maxTemp < maxTempMin) {
                            maxTempMin = maxTemp;
                        }
                        if (minTemp > minTempMax) {
                            minTempMax = minTemp;
                        }
                        if (minTemp < minTempMin) {
                            minTempMin = minTemp;
                        }
                        if (variation > varMax) {
                            varMax = variation;
                        }
                        if (variation < varMin) {
                            varMin = variation;
                        }
                    }

                    // Calculate averages
                    maxTempAvg = maxTempSum / recordArray.length;
                    minTempAvg = minTempSum / recordArray.length;

                    // Display stats
                    System.out.println("Average Maximum Temperature: " + maxTempAvg);
                    System.out.println("Average Minimum Temperature: " + minTempAvg);
                    System.out.println("Maximum Maximum Temperature: " + maxTempMax);
                    System.out.println("Minimum Maximum Temperature: " + maxTempMin);
                    System.out.println("Maximum Minimum Temperature: " + minTempMax);
                    System.out.println("Minimum Minimum Temperature: " + minTempMin);
                    System.out.println("Maximum Variation: " + varMax);
                    System.out.println("Minimum Variation: " + varMin);
                    break;

                case 4:

                    try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("weatherData.dat"))) {
                        for (Registro reg : recordArray) {
                            writer.write((reg.getMaxTemp() + "," + reg.getMinTemp() + "," + reg.getDate() + "\n").getBytes());
                        }
                        writer.close();
                        System.out.println("Record data written to weatherData.dat.");
                    } catch (IOException e) {
                        System.out.println("Error writing record data to file.");
                        e.printStackTrace();
                    }
                    break;
            }

        } while (choice >= 1 && choice < 4);
    }
}

