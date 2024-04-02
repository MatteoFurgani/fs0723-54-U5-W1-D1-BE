package matteofurgani.u5w1d1;

import matteofurgani.u5w1d1.entities.Bevanda;
import matteofurgani.u5w1d1.entities.Condimento;
import matteofurgani.u5w1d1.entities.Menu;

import matteofurgani.u5w1d1.entities.Pizza;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SpringBootApplication
public class U5w1d1Application {

	public static void main(String[] args) {

		SpringApplication.run(U5w1d1Application.class, args);

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5w1d1Application.class);

		List<Menu> menuList = ctx.getBean("menuList", List.class);

		System.out.println("Menu:");
		for (Menu menu : menuList) {
			if (menu instanceof Pizza) {
				Pizza pizza = (Pizza) menu;
				System.out.println("Pizza: " + pizza.getNome() + " - Ingredienti: " + String.join(", ", pizza.getIngredienti()) +
						" - Calorie: " + pizza.getCalorie() +
						" - Prezzo: " + pizza.getPrezzo() + "€");
			} else if (menu instanceof Condimento) {
				Condimento condimento = (Condimento) menu;
				System.out.println("Condimento: " + condimento.getNome() +
						" - Calorie: " + condimento.getCalorie() +
						" - Prezzo: " + condimento.getPrezzo() + "€");
			} else if (menu instanceof Bevanda) {
				Bevanda bevanda = (Bevanda) menu;
				System.out.println("Bevanda: " + bevanda.getNome() + " (" + bevanda.getDimensione() + ")" +
						" - Calorie: " + bevanda.getCalorie() +
						" - Prezzo: " + bevanda.getPrezzo() + "€");
			}
		}

		ctx.close();
	}
}