package ob.service.cosmeticsmanufacturer.services;

import lombok.extern.slf4j.Slf4j;
import ob.service.cosmeticsmanufacturer.domain.Cosmetics;
import ob.service.cosmeticsmanufacturer.repositories.CosmeticsRepository;
import ob.service.cosmeticsmanufacturer.web.model.CosmeticsDto;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CosmeticsServiceImpl implements CosmeticsService {

    private final CosmeticsRepository cosmeticsRepository;

    public CosmeticsServiceImpl(CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsRepository = cosmeticsRepository;
    }

    @Override
    public CosmeticsDto getCosmeticsById(UUID cosmeticsId) {

        return CosmeticsDto.builder()
                .id(cosmeticsId.randomUUID())
                .cosmeticName("Test")
                .cosmeticType("Cream")
                .fdaNumber(12345678900000L)
                .build();
    }


    @Cacheable(cacheNames = "cosmeticsCache")
    @Override
    public Cosmetics getCosmeticsObjById(UUID cosmeticsId) {
        return cosmeticsRepository.findById(cosmeticsId).orElse(null);

    }

    @Override
    public List<Cosmetics> getCosmeticsObjByType(String cosmeticsType) {

        final List<Cosmetics> cosmeticList = new ArrayList<>();

        ListenableFuture<List<Cosmetics>> future = cosmeticsRepository.findCosmeticsByCosmeticType(cosmeticsType);
        future.addCallback(new ListenableFutureCallback<List<Cosmetics>>() {
            @Override
            public void onSuccess(List<Cosmetics> cos) {
                for(Cosmetics c:cos){
                    cosmeticList.add(c);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("Massive failure");
            }
        });

        return cosmeticList;
    }

    @Override
    public List<Cosmetics> getCosmeticsObjByName(String cosmeticsName) {
        return cosmeticsRepository.findCosmeticsByCosmeticName(cosmeticsName);
    }

    @Override
    public CosmeticsDto save(CosmeticsDto cosmeticsDto) {
        return CosmeticsDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void update(UUID cosmeticsId, CosmeticsDto cosmeticsDto) {

    }

    @Override
    public void delete(UUID cosmeticsId) {

    }

    @Override
    public Cosmetics save(Cosmetics cosmetics) {
        return cosmeticsRepository.save(cosmetics);
    }

}
