package _13_01_02_03_Greeting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main implements Greeting{

    public static void main(String[] args) {

        //greet names
        Greeting<String> greetNames = g -> "Hi " + g;
        System.out.println(greetNames.greet("joselito"));
        System.out.println(greetNames.greet("mariano"));

        //greet clients
        Greeting<ClienteBanco> greetClients = g -> "Hi client " + g.getName();
        System.out.println(greetClients.greet(new ClienteBanco("111", "laica", 2000, "12-12-12", 54)));

        ClienteBanco [] groupClient =
                {
                        new ClienteBanco("111", "laica", 2000, "12,12,12", 20),
                        new ClienteBanco("222", "pablo", 3000, "10,10,10", 30),
                };
        System.out.println(GreetGroup(groupClient, cl -> "Hi big guys " +cl.getName()));

        System.out.println(maxAge(groupClient, Comparator.comparingInt(ClienteBanco::getAge)));
    }

    @Override
    public String greet(Object e) {
        return null;
    }

    static <T> List<String> GreetGroup(T[] group, Greeting<T> greeting)
    {
        List<String> res = new ArrayList<String>();
        for (T e : group){
            res.add(greeting.greet(e));
        }
        return res;
    }

    static <T> T maxAge(T [] generic, Comparator<T> compareAge)
    {
        T max = generic[0];
        for (T e : generic)
        {
            if (compareAge.compare(e, max) > 0)
            {
                max = e;
            }
        }
        return max;
    }
}

