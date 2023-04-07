import java.util.Scanner;
public class agenda {

    private String name;
    int phoneNumber;
    public agenda(String name, int phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public String getName(){
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
}