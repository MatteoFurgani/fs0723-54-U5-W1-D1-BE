package matteofurgani.u5w1d1.entities;

import lombok.Getter;
import lombok.Setter;


public class Bevanda extends Menu {

    protected String dimensione;

    public Bevanda(String nome, int calorie, double prezzo, String dimensione) {
        super(nome, calorie, prezzo);
        this.dimensione = dimensione;
    }

    public String getDimensione() {
        return dimensione;
    }

    public void setDimensione(String dimensione) {
        this.dimensione = dimensione;
    }
}