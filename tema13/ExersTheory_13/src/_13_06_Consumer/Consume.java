package _13_06_Consumer;

import java.util.function.Consumer;

public class Consume <T> {

    static <T> void forEach(T[] array, Consumer<T> consumer)
    {
        for (T t : array)
        {
            consumer.accept(t);
        }
    }
}
