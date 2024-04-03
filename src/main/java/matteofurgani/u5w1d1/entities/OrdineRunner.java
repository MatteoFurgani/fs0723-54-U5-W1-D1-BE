package matteofurgani.u5w1d1.entities;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Component
@PropertySource("application.properties")
public class OrdineRunner implements CommandLineRunner {

    @Value("${costo.coperto}")
    private double costoCoperto;

    private final Logger logger = Logger.getLogger(String.valueOf(OrdineRunner.class));



    @Override
    public void run(String... args) throws Exception {
        List<Menu> menu = Arrays.asList(
                new Pizza("Margherita", 1100, 5.00, Arrays.asList("pomodoro", "mozzarella")),
                new Pizza("Napoli", 1100, 7.00, Arrays.asList("pomodoro", "mozzarella", "alici")),
                new Pizza("Boscaiola", 1300, 8.00, Arrays.asList("mozzarella", "funghi", "salsiccia")),
                new Condimento("Mozzarella", 30, 0.50),
                new Condimento("Salsiccia", 50, 0.50),
                new Bevanda("Coca-cola", 500, 5.00, "0.5"),
                new Bevanda("Birra", 700, 8.00, "0.7")
        );

        // Creazione ordini
        Ordine ordine = new Ordine(1, 4, StatoOrdine.PRONTO);
        Ordine ordine1 = new Ordine(2,6, StatoOrdine.IN_CORSO);

        // Aggiunta elementi all'ordine
        ordine.aggiungiElemento(menu.get(0));
        ordine.aggiungiElemento(menu.get(1));
        ordine.aggiungiElemento(menu.get(2));

        // Aggiunta elementi all'ordine1
        ordine1.aggiungiElemento(menu.get(1));
        ordine1.aggiungiElemento(menu.get(1));
        ordine1.aggiungiElemento(menu.get(2));
        ordine1.aggiungiElemento(menu.get(5));
        ordine1.aggiungiElemento(menu.get(6));


        logger.info("Dettagli degli ordini:");
        for (Ordine ordineCorrente : Arrays.asList(ordine, ordine1)) {
            logger.info("Numero ordine: " + ordineCorrente.getNumeroOrdine());
            logger.info("Stato: " + ordineCorrente.getStato());
            logger.info("Numero coperti: " + ordineCorrente.getNumeroCoperti());
            logger.info("Ora acquisizione: " + ordineCorrente.getOraAcquisizione());
            logger.info("Elementi dell'ordine:");
            for (Menu elemento : ordineCorrente.getElementiOrdine()) {
                logger.info("- " + elemento.getNome() + " (" + elemento.getClass().getSimpleName() + ")");
            }
            logger.info("Importo totale: " + ordineCorrente.calcolaImportoTotale(costoCoperto));
        }



        // Stampa l'ordine utilizzando il logger
       /* logger.info("Dettagli dell'ordine:");
        logger.info("Numero ordine: " + ordine.getNumeroOrdine());
        logger.info("Stato: " + ordine.getStato());
        logger.info("Numero coperti: " + ordine.getNumeroCoperti());
        logger.info("Ora acquisizione: " + ordine.getOraAcquisizione());
        logger.info("Elementi dell'ordine:");
        for (Menu elemento : ordine.getElementiOrdine()) {
            logger.info("- " + elemento.getNome() + " (" + elemento.getClass().getSimpleName() + ")");
        }
        logger.info("Importo totale: " + ordine.calcolaImportoTotale(costoCoperto));*/
    }
}
