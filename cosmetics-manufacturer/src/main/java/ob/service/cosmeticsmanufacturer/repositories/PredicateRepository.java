package ob.service.cosmeticsmanufacturer.repositories;

import ob.service.cosmeticsmanufacturer.domain.Predicate;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PredicateRepository extends PagingAndSortingRepository<Predicate, String> {
}
