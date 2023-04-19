package Ampliacion._11_26_Registro_Temperature;

public class Registro {
    private double maxTemp;
    private double minTemp;
    private String date;
    Registro(double maxTemp, double minTemp, String date) {
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.date = date;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
