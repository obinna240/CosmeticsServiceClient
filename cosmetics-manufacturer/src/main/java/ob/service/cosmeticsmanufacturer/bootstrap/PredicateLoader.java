package ob.service.cosmeticsmanufacturer.bootstrap;

import ob.service.cosmeticsmanufacturer.repositories.PredicateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PredicateLoader implements CommandLineRunner {

    private final PredicateRepository predicateRepository;

    public PredicateLoader(PredicateRepository PredicateRepository) {

        this.predicateRepository = PredicateRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCosmetics();
    }

    private void loadCosmetics(){
        if(predicateRepository.count() == 0 ){
            predicateRepository.save(new ob.service.cosmeticsmanufacturer.domain.Predicate.Builder()
                    .id("1")
                    .category("car")
                    .keyword("Audi")
                    .location("uk")
                    .build());

            predicateRepository.save(new ob.service.cosmeticsmanufacturer.domain.Predicate.Builder()
                    .id("2")
                    .category("car")
                    .keyword("Mercedes-Benz")
                    .location("uk")
                    .build());

            predicateRepository.save(new ob.service.cosmeticsmanufacturer.domain.Predicate.Builder()
                    .id("1")
                    .category("car")
                    .keyword("BMW")
                    .location("uk")
                    .build());
        }
    }
}
