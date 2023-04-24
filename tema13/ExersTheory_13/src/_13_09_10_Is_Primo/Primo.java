package _13_09_10_Is_Primo;

public class Primo {

    static boolean isEven (Integer n)
    {
        boolean even = true;
        for (int i = 2; even && i <= Math.sqrt(n); i++)
        {
            if (n % i == 0) {
                even = false;
                break;
            }
        }
        return even;
    }
}
