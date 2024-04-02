package matteofurgani.u5w1d1.entities;




import java.util.List;

public class Pizza extends Menu{

    protected List<String> ingredienti;

    public Pizza(String nome, int calorie, double prezzo, List<String> ingredienti) {
        super(nome, calorie, prezzo);
        this.ingredienti = ingredienti;
    }

    public List<String> getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(List<String> ingredienti) {
        this.ingredienti = ingredienti;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "ingredienti=" + ingredienti +
                '}';
    }
}
