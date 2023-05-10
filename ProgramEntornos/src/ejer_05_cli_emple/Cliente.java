package ejer_05_cli_emple;

public class Cliente extends Persona
{
    private int phoneNumber;
    protected Cliente(String name, int age, int phoneNumber) {
        super(name, age);
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString()
    {
        return "Name: " + getName() + " Age: " + getAge() + " Phone number: " +phoneNumber;
    }
}
