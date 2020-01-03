package ob.service.cosmeticsmanufacturer.bootstrap;


import ob.service.cosmeticsmanufacturer.domain.Attribute;
import ob.service.cosmeticsmanufacturer.repositories.AttributeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AttributeLoader implements CommandLineRunner {

    private final AttributeRepository attributeRepository;

    public AttributeLoader(AttributeRepository attributeRepository) {

        this.attributeRepository = attributeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCosmetics();
    }

    private void loadCosmetics(){
        if(attributeRepository.count() == 0 ){
            attributeRepository.save(new Attribute(1, "fuel", "hydrogen"));

            attributeRepository.save(new Attribute(8, "fuel", "diesel"));

            attributeRepository.save(new Attribute(2, "fuel", "petrol"));

            attributeRepository.save(new Attribute(3, "model", "C220"));

            attributeRepository.save(new Attribute(4, "transmission", "manual"));

            attributeRepository.save(new Attribute(5, "fuel", "electric"));

            attributeRepository.save(new Attribute(6, "fuel", "hybrid"));

            attributeRepository.save(new Attribute(7, "model", "A3 All weather"));
        }
    }
}
