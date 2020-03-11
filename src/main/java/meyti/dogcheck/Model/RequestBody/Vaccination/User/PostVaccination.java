package meyti.dogcheck.Model.RequestBody.Vaccination.User;

import meyti.dogcheck.Model.Entity.Vaccination;

import java.time.LocalDate;

public class PostVaccination {
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public PostVaccination setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Vaccination getVaccination(){
        Vaccination vaccination = new Vaccination();
        vaccination.setDate(date);
        return vaccination;
    }
}
