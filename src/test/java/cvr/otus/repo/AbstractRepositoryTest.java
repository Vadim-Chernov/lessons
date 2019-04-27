package cvr.otus.repo;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;

@DataMongoTest
@EnableConfigurationProperties
@ComponentScan({"cvr.otus.config", "cvr.otus.repo"})
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
public abstract class AbstractRepositoryTest {
}
