package matteofurgani.u5w1d1;

import matteofurgani.u5w1d1.entities.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class U5w1d1ApplicationTests {

	@Autowired
	@Qualifier("margherita")
	private Pizza pizzaBean;

	@Autowired
	private List<Menu> menuList;

	@Autowired
	private BeansMenu beansMenu;

	@Test
	void contextLoads() {
	}

	@Test
	void testCreazionePizza() {
		System.out.println("TEST 1");
		assertEquals("Margherita", pizzaBean.getNome());
		assertEquals(1100, pizzaBean.getCalorie());
		assertEquals(5.0, pizzaBean.getPrezzo());
		assertEquals(Arrays.asList("pomodoro", "mozzarella"), pizzaBean.getIngredienti());
	}

	@Test
	void testAvanzamentoStato() {
		System.out.println("TEST 2");
		Ordine ordine = new Ordine(1, 4, StatoOrdine.IN_CORSO);
		assertEquals(StatoOrdine.IN_CORSO, ordine.getStato());
		ordine.setStato(StatoOrdine.PRONTO);
		assertEquals(StatoOrdine.PRONTO, ordine.getStato());
	}

	@Test
	void testCalcolaImportoTotale() {
		System.out.println("TEST 3");
		Ordine ordine = new Ordine(1, 4, StatoOrdine.PRONTO);
		ordine.aggiungiElemento(new Pizza("Margherita", 800, 7.50, Arrays.asList("pomodoro", "mozzarella")));
		ordine.aggiungiElemento(new Bevanda("Coca-cola", 150, 2.50, "0.5"));

		double costoCoperto = 5.00;
		assertEquals(30.00, ordine.calcolaImportoTotale(costoCoperto));
		assertNotEquals(31.00, ordine.calcolaImportoTotale(costoCoperto));
	}

	@Test
	void testCreazioneCondimento() {
		System.out.println("TEST 4");
		assert menuList != null;

		int condimentiPresenti = 0;
		for (Menu menu : menuList) {
			if (menu instanceof Condimento) {
				Condimento condimento = (Condimento) menu;
				if (condimento.getNome().equals("Mozzarella") || condimento.getNome().equals("Salsiccia")) {
					condimentiPresenti++;
				}
			}
		}

		assertEquals(2, condimentiPresenti);
	}

	@ParameterizedTest
	@CsvSource({"Coca-cola, 500, 5.00, 0.5", "Birra, 700, 8.00, 0.7"})
	void testCreazioneBevandaConDimensione(String nome, int calorie, double prezzo, String dimensione) {
		System.out.println("TEST 5");
		Bevanda bevanda = null;
		for (Menu menu : beansMenu.menuList()) {
			if (menu instanceof Bevanda && menu.getNome().equals(nome)) {
				bevanda = (Bevanda) menu;
				break;
			}
		}
		assert bevanda != null;

		assertEquals(nome, bevanda.getNome());
		assertEquals(calorie, bevanda.getCalorie());
		assertEquals(prezzo, bevanda.getPrezzo());
		assertEquals(dimensione, bevanda.getDimensione());
	}

	@BeforeAll
	public static void beforeAll(){
		System.out.println("BEFORE ALL");
	}

	@AfterAll
	public static void afterAll(){
		System.out.println("AFTER ALL");
	}

	@BeforeEach
	public void beforeEach(){
		System.out.println("BEFORE EACH");
	}

	@AfterEach
	public void afterEach(){
		System.out.println("AFTER EACH");
	}
}
