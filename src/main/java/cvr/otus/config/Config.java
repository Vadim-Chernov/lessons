package cvr.otus.config;

import org.h2.tools.Console;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    /**
     * Бин сделан "вражьим" способом)))
     * чтоб запустить Н2-консоль
     * @return Консоль Н2
     */
    @Bean
    public Console console() {
        Console con = null;
        try {
            Console.main();
            con = Console.class.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

}
