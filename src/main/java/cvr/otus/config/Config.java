package cvr.otus.config;

import liquibase.integration.spring.SpringLiquibase;
import org.h2.tools.Console;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.jline.PromptProvider;

@Configuration
public class Config {
    /**
     * Бин сделан "вражьим" способом)))
     *
     * @return
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

//    @Bean
//    public SpringLiquibase liquibase() {
//        SpringLiquibase liquibase = new SpringLiquibase();
//        liquibase.setChangeLog("classpath:db.changelog-master.yaml");
////        liquibase.setDataSource(dataSource());
//        return liquibase;
//    }


    @Bean
    public PromptProvider promptProvider() {
        return () -> new AttributedString("otus:>", AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW));
    }
}
