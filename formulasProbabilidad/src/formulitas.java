import java.util.*;
public class formulitas {
    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);
        System.out.println("Bienvenid@ al programa");
        System.out.println("Introduce el valor para P(A)");
        double variableA = scanner.nextDouble();
        System.out.println("Introduce el valor para P(B)");
        double variableB = scanner.nextDouble();

        boolean running = true;
        while(running) {
            System.out.println("Bienvenid@ al programa, introduce: \n" +
                    "1. Para calcular: P(A) + P(A-con raya) - 1.\n" +
                    "2. Para calcular: P(A-union-B).\n" +
                    "3. Para calcular: P(A-interseccion-B-con raya).\n" +
                    "4. Para calcular: P(A-con raya--union-B-con raya).\n" +
                    "5. Para calcular: P(A-con raya--interseccion-B-con raya).\n" +
                    "6. Para calcular: P(A/B).\n" +
                    "7. Determinar si A y B son compatibles o no.\n" +
                    "8. Determinar si A y B son dependientes o no.\n" +
                    "0. Para salir");
            int opciones = scanner.nextInt();
            switch (opciones) {
                case 1:

            }
        }











    }
}