public class NumeroNulos {
    static <T extends Number> int numberOfNull(T[] array){
        int count = 0;
        for(T e : array){
            if (e instanceof Number){
                count++;
            }
        }
        return count;
    }
}
