import java.io.*;

/*dos ficheros
        1. fichero1: hola soy paco
        2. fichero2: hola me llamo mario
        tercer fichero:
        hola hola
        soy me
        paco llamo
        no puede haber mas de 6 palabras por linea*\
 */
public class alumnos {
    public static void main(String[] args) {

        try(BufferedReader in1 = new BufferedReader(
                new FileReader("Alumno1.txt"));
            BufferedReader in2 = new BufferedReader(
                    new FileReader("Alumno2.txt"));
            BufferedWriter out = new BufferedWriter(
                    new FileWriter("Resultado.txt"))) {

            String texto1 = in1.readLine();
            String texto2 = in2.readLine();

            int palabras = 0;

            while(texto2 != null){
                String [] subcadena1 = texto1.split(" ");
                String [] subcadena2 = texto2.split(" ");

                for (int i = 0; i < subcadena1.length; i++){
                    out.write(subcadena1[i]+ " ");
                    out.write(subcadena2[i]+ " ");
                    if (palabras == 4){
                        out.newLine();
                        palabras = 0;
                    }else{
                        palabras = palabras+2;
                    }
                }
                texto1 = in1.readLine();
                texto2 = in2.readLine();
            }

        } catch (IOException e) {
            System.out.println("There was an error");
            e.printStackTrace();
        }
    }
}
