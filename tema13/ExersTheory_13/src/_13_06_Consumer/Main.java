package _13_06_Consumer;

public class Main {
    public static void main(String[] args) {

        Client [] cl = new  Client[2];
        cl [0] = new Client("mario", 1);
        cl [1] = new Client("maria", 1);

        Consume.forEach(cl, a -> System.out.println("Name: " +a.getName()+ ", age: " + a.getAge()));
    }
}
