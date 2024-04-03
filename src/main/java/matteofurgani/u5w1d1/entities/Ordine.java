package matteofurgani.u5w1d1.entities;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ordine {

    private int numeroOrdine;
    private int numeroCoperti;
    private LocalDateTime oraAcquisizione;
    private List<Menu> elementiOrdine;
    private StatoOrdine stato;

    public Ordine(int numeroOrdine, int numeroCoperti, StatoOrdine stato) {
        this.numeroOrdine = numeroOrdine;
        this.stato = stato;
        this.numeroCoperti = numeroCoperti;
        this.oraAcquisizione = LocalDateTime.now();
        this.elementiOrdine = new ArrayList<>();
    }

    public void aggiungiElemento(Menu elemento) {
        elementiOrdine.add(elemento);
    }

    public double calcolaImportoTotale(double costoCoperto) {
        double importoTotale = costoCoperto * numeroCoperti;
        for (Menu elemento : elementiOrdine) {
            importoTotale += elemento.getPrezzo();
        }
        return importoTotale;
    }

    public int getNumeroOrdine() {
        return numeroOrdine;
    }

    public void setNumeroOrdine(int numeroOrdine) {
        this.numeroOrdine = numeroOrdine;
    }

    public StatoOrdine getStato() {
        return stato;
    }

    public void setStato(StatoOrdine stato) {
        this.stato = stato;
    }

    public int getNumeroCoperti() {
        return numeroCoperti;
    }

    public void setNumeroCoperti(int numeroCoperti) {
        this.numeroCoperti = numeroCoperti;
    }

    public LocalDateTime getOraAcquisizione() {
        return oraAcquisizione;
    }

    public void setOraAcquisizione(LocalDateTime oraAcquisizione) {
        this.oraAcquisizione = oraAcquisizione;
    }

    public List<Menu> getElementiOrdine() {
        return elementiOrdine;
    }

    public void setElementiOrdine(List<Menu> elementiOrdine) {
        this.elementiOrdine = elementiOrdine;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "numeroOrdine=" + numeroOrdine +
                ", stato=" + stato +
                ", numeroCoperti=" + numeroCoperti +
                ", oraAcquisizione=" + oraAcquisizione +
                ", elementiOrdine=" + elementiOrdine +
                '}';
    }


}
