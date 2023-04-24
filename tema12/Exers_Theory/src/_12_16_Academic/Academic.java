package _12_16_Academic;
public class Academic implements Comparable<Academic> {

    String name;
    int yearAdmission;

    public Academic(String name, int yearAdmission) {
        this.name = name;
        this.yearAdmission = yearAdmission;
    }
    public int getYearAdmission() {
        return yearAdmission;
    }
    @Override
    public int compareTo(Academic o) {
        return name.compareTo(o.name);
    }
    @Override
    public String toString() {
        return "Name : " + name + ", year of admission : " + yearAdmission;
    }

}
