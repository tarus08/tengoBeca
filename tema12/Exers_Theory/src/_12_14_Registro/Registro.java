package _12_14_Registro;

import java.io.Serializable;
import java.time.LocalTime;

public class Registro implements Serializable {

    private double temperature;
    private LocalTime hour;
    private double maxTemperature;
    private double minTemperature;
    private double avgTemperature;
    public Registro(double temperature) {
        this.temperature = temperature;
        this.hour = LocalTime.now();
    }

    @Override
    public String toString() {
        return "Temperature: " + temperature+ "\nDate: " + hour;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour( LocalTime hour) {
        this.hour = hour;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getAvgTemperature() {
        return avgTemperature;
    }

    public void setAvgTemperature(double avgTemperature) {
        this.avgTemperature = avgTemperature;
    }
}
