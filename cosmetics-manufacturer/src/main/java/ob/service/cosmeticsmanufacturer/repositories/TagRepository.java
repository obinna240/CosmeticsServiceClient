package ob.service.cosmeticsmanufacturer.repositories;

import ob.service.cosmeticsmanufacturer.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
