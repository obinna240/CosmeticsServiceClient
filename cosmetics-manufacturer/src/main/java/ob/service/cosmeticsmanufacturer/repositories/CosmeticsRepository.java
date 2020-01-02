package ob.service.cosmeticsmanufacturer.repositories;

import ob.service.cosmeticsmanufacturer.domain.Cosmetics;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public interface CosmeticsRepository extends PagingAndSortingRepository<Cosmetics, UUID> {

    @Async
    ListenableFuture<List<Cosmetics>> findCosmeticsByCosmeticType(String cosmeticType);
//    List<Cosmetics> findCosmeticsByCosmeticType(String cosmeticType);
    List<Cosmetics> findCosmeticsByCosmeticName(String cosmeticName);
}
