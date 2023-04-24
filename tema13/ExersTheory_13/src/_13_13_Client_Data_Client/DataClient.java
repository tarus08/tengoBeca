package _13_13_Client_Data_Client;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DataClient {
    private String name;
    private LocalDate birthDate;

    protected DataClient(Cliente client)
    {
        this.name = client.getName();
        this.birthDate = client.getBirthDate();
    }
    public int age()
    {
        return ((int) birthDate.until(LocalDate.now(), ChronoUnit.YEARS));
    }

    @Override
    public String toString()
    {
        return "Name: " + name + " age: " + age();
    }
}
