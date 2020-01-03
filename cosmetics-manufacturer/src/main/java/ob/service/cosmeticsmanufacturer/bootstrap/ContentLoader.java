package ob.service.cosmeticsmanufacturer.bootstrap;

import ob.service.cosmeticsmanufacturer.domain.Content;
import ob.service.cosmeticsmanufacturer.repositories.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ContentLoader implements CommandLineRunner {

    private final ContentRepository contentRepository;

    public ContentLoader(ContentRepository contentRepository) {

        this.contentRepository = contentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCosmetics();
    }

    private void loadCosmetics(){
        if(contentRepository.count() == 0 ){
            contentRepository.save(new Content("This is a test?", "This is the answer"));

            contentRepository.save(new Content("This is a test2?", "This is the answer2"));

            contentRepository.save(new Content("This is a test3?", "This is the answer3"));

        }
    }
}
