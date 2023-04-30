package ejer_04_renting;

import java.util.Map;

public class Garaje {
    private String address;
    private int parkingLots;
    private Map<String, String> mapGarage;

    public Garaje(String address, int parkingLots, Map<String, String> mapGarage) {
        this.address = address;
        this.parkingLots = parkingLots;
        this.mapGarage = mapGarage;
    }

    public Map<String, String> getMapGarage() {
        return mapGarage;
    }

    public void setMapGarage(Map<String, String> mapGarage) {
        this.mapGarage = mapGarage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(int parkingLots) {
        this.parkingLots = parkingLots;
    }
}
