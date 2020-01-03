package ob.service.cosmeticsmanufacturer.repositories;

import ob.service.cosmeticsmanufacturer.domain.Content;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContentRepository extends PagingAndSortingRepository<Content, Integer> {
}
