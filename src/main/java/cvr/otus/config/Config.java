package cvr.otus.config;

import com.github.cloudyrock.mongock.Mongock;
import com.github.cloudyrock.mongock.SpringMongockBuilder;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    private static final String CHANGE_LOG_PACKAGE = "cvr.otus.changelogs";

    @Bean
    public Mongock mongock(MongoProps mongoProps, MongoClient mongoClient) {
        return new SpringMongockBuilder(mongoClient, mongoProps.getDatabase(), CHANGE_LOG_PACKAGE)
                .setLockQuickConfig()
                .build();
    }
}
