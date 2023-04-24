package _13_11_Sort_By_Name;

public class Clients02 {

    private int age;
    private String name;
    private double moneySpent;
    protected Clients02(int age, String name, double moneySpent) {
        this.age = age;
        this.name = name;
        this.moneySpent = moneySpent;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoneySpent() {
        return moneySpent;
    }

    public void setMoneySpent(double moneySpent) {
        this.moneySpent = moneySpent;
    }
}
