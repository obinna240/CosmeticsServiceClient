package ob.service.cosmeticsmanufacturer.services;

import lombok.extern.slf4j.Slf4j;
import ob.service.cosmeticsmanufacturer.web.model.CosmeticsDto;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Slf4j
@Service
public class CosmeticsServiceImpl implements CosmeticsService {

    @Override
    public CosmeticsDto getCosmeticsById(UUID cosmeticsId) {
        return CosmeticsDto.builder()
                .id(cosmeticsId.randomUUID())
                .cosmeticName("Test")
                .cosmeticType("Cream")
                .fdaNumber(12345678900000L)
                .build();
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

}
