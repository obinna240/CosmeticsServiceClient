package ob.service.cosmeticsmanufacturer.bootstrap;

import ob.service.cosmeticsmanufacturer.domain.Attribute;
import ob.service.cosmeticsmanufacturer.domain.Content;
import ob.service.cosmeticsmanufacturer.domain.Predicate;
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

            //Contents
            Content c1 = new Content(1, "This is a test?", "This is the answer");

            Content c2 = new Content(2, "This is a test2?", "This is the answer2");

            Content c3 = new Content(3, "This is a test3?", "This is the answer3");


            //Attributes
            Attribute a1 = new Attribute(4, "transmission", "manual");

            Attribute a2 = new Attribute(5, "fuel", "electric");

            Attribute a3 = new Attribute(6, "fuel", "hybrid");

            Attribute a4 = new Attribute(7, "model", "A3 All weather");


//            Predicate p1 = new ob.service.cosmeticsmanufacturer.domain.Predicate.Builder()
//                    .id("1")
//                    .category("car")
//                    .keyword("Audi")
//                    .location("uk")
//                    .build();

            Predicate p1 = new Predicate("1", "uk", "car", "audi");
            Predicate p2 = new Predicate("2", "uk", "car", "vw");
            Predicate p3 = new Predicate("3", "uk", "car", "bentley");
            Predicate p4 = new Predicate("4", "London", "", "BMW");

            p1.getContent().add(c1);
            p2.getContent().add(c2);
            p3.getContent().add(c3);

            p1.getAttribute().add(a1);
            p1.getAttribute().add(a2);
            p2.getAttribute().add(a2);
            p2.getAttribute().add(a4);
            p3.getAttribute().add(a3);

            predicateRepository.save(p1);
            predicateRepository.save(p2);
            predicateRepository.save(p3);

//            predicateRepository.save(new ob.service.cosmeticsmanufacturer.domain.Predicate.Builder()
//                    .id("1")
//                    .category("car")
//                    .keyword("Audi")
//                    .location("uk")
//                    .content(c1)
//                    .build()).getSomecontent().add(c1);
//
//            predicateRepository.save(new ob.service.cosmeticsmanufacturer.domain.Predicate.Builder()
//                    .id("2")
//                    .category("car")
//                    .keyword("Mercedes-Benz")
//                    .location("uk")
//                    .content(c2)
//                    .build()).getSomecontent().add(c2);
//
//            predicateRepository.save(new ob.service.cosmeticsmanufacturer.domain.Predicate.Builder()
//                    .id("3")
//                    .category("car")
//                    .keyword("BMW")
//                    .location("uk")
//                    .content(c3)
//                    .build()).getSomecontent().add(c3);

        }
    }
}
