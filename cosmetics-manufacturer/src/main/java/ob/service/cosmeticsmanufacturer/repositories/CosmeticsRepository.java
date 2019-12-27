package ob.service.cosmeticsmanufacturer.repositories;

import ob.service.cosmeticsmanufacturer.domain.Cosmetics;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/**
 *
 */
public interface CosmeticsRepository extends PagingAndSortingRepository<Cosmetics, UUID> {
}
