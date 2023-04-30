package ejer_04_renting;

import java.time.LocalDate;

public class FechaInic {
    private LocalDate dateIni;
    private int gasLitres;

    public FechaInic(LocalDate dateIni, int gasLitres) {
        this.dateIni = dateIni;
        this.gasLitres = gasLitres;
    }

    public LocalDate getDateIni() {
        return dateIni;
    }

    public void setDateIni(LocalDate dateIni) {
        this.dateIni = dateIni;
    }

    public int getGasLitres() {
        return gasLitres;
    }

    public void setGasLitres(int gasLitres) {
        this.gasLitres = gasLitres;
    }
}
