package ob.service.cosmeticsmanufacturer.bootstrap;

import ob.service.cosmeticsmanufacturer.domain.Post;
import ob.service.cosmeticsmanufacturer.domain.Tag;
import ob.service.cosmeticsmanufacturer.repositories.PostRepository;
import ob.service.cosmeticsmanufacturer.repositories.TagRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TagAndPostLoader implements CommandLineRunner {

    private final PostRepository postRepository;
    private final TagRepository tagRepository;

    public TagAndPostLoader(PostRepository postRepository, TagRepository tagRepository) {
        this.postRepository = postRepository;
        this.tagRepository = tagRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create a Post
        Post post = new Post("Hibernate Many to Many Example with Spring Boot",
                "Learn how to map a many to many relationship using hibernate",
                "Entire Post content with Sample code");

        // Create two tags
        Tag tag1 = new Tag("Spring Boot");
        Tag tag2 = new Tag("Hibernate");


        // Add tag references in the post
        post.getTags().add(tag1);
        post.getTags().add(tag2);

        Post post2 = new Post("None",
                "Awk",
                "Foo");

        Post post3 = new Post("Some",
                "All",
                "Goo");


        // Add post reference in the tags
        tag1.getPosts().add(post);
        tag2.getPosts().add(post);

        postRepository.save(post);
        postRepository.save(post2);
        postRepository.save(post3);

    }
}
