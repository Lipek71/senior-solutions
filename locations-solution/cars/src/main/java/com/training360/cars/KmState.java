package com.training360.cars;

import java.time.LocalDate;

public class KmState {
    private LocalDate date;
    private int km;

    public KmState(LocalDate date, int km) {
        this.date = date;
        this.km = km;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }
}
