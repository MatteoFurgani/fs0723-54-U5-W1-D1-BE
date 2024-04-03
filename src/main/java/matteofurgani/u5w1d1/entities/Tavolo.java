package matteofurgani.u5w1d1.entities;

public class Tavolo {

    private int numeroTavolo;
    private int numeroCopertiMassimo;
    private StatoTavolo stato;

    public Tavolo(int numeroTavolo, int numeroCopertiMassimo, StatoTavolo stato) {
        this.numeroTavolo = numeroTavolo;
        this.numeroCopertiMassimo = numeroCopertiMassimo;
        this.stato = stato;
    }

    public int getNumeroTavolo() {
        return numeroTavolo;
    }

    public void setNumeroTavolo(int numeroTavolo) {
        this.numeroTavolo = numeroTavolo;
    }

    public int getNumeroCopertiMassimo() {
        return numeroCopertiMassimo;
    }

    public void setNumeroCopertiMassimo(int numeroCopertiMassimo) {
        this.numeroCopertiMassimo = numeroCopertiMassimo;
    }

    public StatoTavolo getStato() {
        return stato;
    }

    public void setStato(StatoTavolo stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Tavolo{" +
                "numeroTavolo=" + numeroTavolo +
                ", numeroCopertiMassimo=" + numeroCopertiMassimo +
                ", stato=" + stato +
                '}';
    }
}
