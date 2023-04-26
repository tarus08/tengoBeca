package _13_26_Eratostenes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Eratosthenes {
    public static List<Integer> calcPrimeNumbers(int n) {
        boolean[] isPrimeNumber = new boolean[n + 1]; // boolean defaults to
        // false
        List<Integer> primes = new ArrayList<Integer>();
        for (int i = 2; i < n; i++) {
            isPrimeNumber[i] = true;
        }
        for (int i = 2; i < n; i++) {
            if (isPrimeNumber[i]) {
                primes.add(i);
                // now mark the multiple of i as non-prime number
                for (int j = i; j * i <= n; j++) {
                    isPrimeNumber[i * j] = false;
                }
            }
        }
        return primes.stream()
                .filter(e -> e <= 10 || primes.stream()
                .filter(p -> p <= 10)
                .allMatch(p -> e % p != 0))
                .toList();
    }

    public static void main(String[] args) {
        List<Integer> primes = calcPrimeNumbers(10);

        primes.stream()
                .filter(i -> {
                    if (i < 2) {
                        return false;
                    }
                    for (int j = 2; j <= Math.sqrt(i); j++) {
                        if (i % j == 0) {
                            return false;
                        }
                    }
                    return true;
                })
                .filter(i -> {
                    if (i < 10) {
                        return true;
                    }
                    for (int j = 2; j < 10; j++) {
                        if (i != j && i % j == 0) {
                            return false;
                        }
                    }
                    return true;
                })
                .sorted();

        System.out.println("Prime numbers: "
                +primes
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ")));
    }
}