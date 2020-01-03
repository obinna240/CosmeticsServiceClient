package ob.service.cosmeticsmanufacturer.repositories;

import ob.service.cosmeticsmanufacturer.domain.Attribute;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AttributeRepository extends PagingAndSortingRepository<Attribute, Integer> {
}
