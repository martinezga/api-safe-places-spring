package lat.safeplaces.api.configurations;

import lat.safeplaces.api.models.PlaceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lat.safeplaces.api.repositories.PlaceRepository;

@Configuration
public class LoadDatabase {
    // TODO: Research if this config loads on prod profile, if it is positive disable it

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PlaceRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new PlaceModel("Brasil")));
            log.info("Preloading " + repository.save(new PlaceModel( "México")));
        };
    }
}
