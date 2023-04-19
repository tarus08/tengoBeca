package Ampliacion._12_34_Registro;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Registro implements Serializable {

    private double temperature;
    private LocalDate date;
    private double maxTemperature;
    private double minTemperature;
    private double avgTemperature;
    public Registro(double temperature, LocalDate date) {
        this.temperature = temperature;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Temperature: " + temperature+ "\nDate: " + date;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate( LocalTime hour) {
        this.date = date;
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
