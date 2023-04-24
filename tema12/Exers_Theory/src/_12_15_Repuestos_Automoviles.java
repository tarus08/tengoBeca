import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.TreeMap;

public class _12_15_Repuestos_Automoviles {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Integer> data = new TreeMap<String, Integer>();
        int choice = 0;
        int previousSize = 0;
        String newId = null;

        do{
            System.out.println("Enter: \n" +
                    "'1' To add a new product.\n" +
                    "'2' To remove a product.\n" +
                    "'3' To modify the stock of a product.\n");
            choice = new Scanner(System.in).nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter the new id for the product");
                    newId = scanner.next();
                    System.out.println("Enter the stock for the product");
                    int stock = scanner.nextInt();
                    if (!data.containsKey(newId)){
                        data.put(newId, stock);
                    }else{
                        System.out.println("The product is already in stock");
                    }

                    //check if the product was added
                    if (data.size() > previousSize){
                        System.out.println("The new product was added.\nID:" + newId+ " \nStock: " + stock);
                    }
                    System.out.println(data);

                    break;

                case 2:
                    System.out.println("Enter the id for the product you want to remove: ");
                    String idDelete = scanner.next();
                    if (data.containsKey(idDelete)){
                        data.remove(idDelete);
                        System.out.println("The product with the id: '" +idDelete+ "' was removed");
                        System.out.println("The id was found and the product was deleted, these are the products: " +data);
                    }else{
                        System.out.println("The id was not found, this is the data: " +data);
                    }

                    break;

                case 3:
                    System.out.println("Enter the id for the product you want to modify the stock of: ");
                    String findId = scanner.next();
                    System.out.println("Enter the new stock for the product selected:");
                    int newStockMod = scanner.nextInt();
                    data.put(findId, newStockMod);
                    System.out.println("This is the new stock for the product '" +findId+ "': " +data.get(findId));
                    break;

            }

        }while (choice >= 1 && choice < 4);

        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("stock.dat"))){
            writer.writeObject(data);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
