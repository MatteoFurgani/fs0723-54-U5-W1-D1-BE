package matteofurgani.u5w1d1.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class BeansMenu {

    @Bean
    public List<Menu> menuList(){
        return Arrays.asList(margherita(), napoli(), boscaiola(), mozzarella(), salsiccia(), cocacola(), birra());
    }

    @Bean
    public Pizza margherita(){
        return new Pizza("Margherita", 1100, 5.00, Arrays.asList("pomodoro","mozzarella"));
    }

    @Bean
    public Pizza napoli(){
        return new Pizza("Napoli", 1100, 7.00, Arrays.asList("pomodoro","mozzarella","alici"));
    }

    @Bean
    public Pizza boscaiola(){
        return new Pizza("Boscaiola", 1300, 8.00, Arrays.asList("mozzarella","funghi","salsiccia"));
    }

    @Bean
    public Condimento mozzarella(){
        return new Condimento("Mozzarella", 30, 0.50);
    }

    @Bean
    public Condimento salsiccia(){
        return new Condimento("Salsiccia", 50, 0.50);
    }

    @Bean
    public Bevanda cocacola() {
        return new Bevanda("Coca-cola", 500, 5.00, "0.5");
    }

    @Bean
    public Bevanda birra() {
        return new Bevanda("Birra", 700, 8.00, "0.7");
    }

}
