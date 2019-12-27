package ob.service.cosmeticsmanufacturer.bootstrap;

import ob.service.cosmeticsmanufacturer.domain.Cosmetics;
import ob.service.cosmeticsmanufacturer.repositories.CosmeticsRepository;
import ob.service.cosmeticsmanufacturer.web.model.CosmeticsEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CosmeticsLoader implements CommandLineRunner {

    private final CosmeticsRepository cosmeticsRepository;

    public CosmeticsLoader(CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsRepository = cosmeticsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCosmetics();
    }

    private void loadCosmetics(){
        if(cosmeticsRepository.count() == 0 ){
            cosmeticsRepository.save(Cosmetics.builder()
                    .cosmeticName("Mac")
                    .cosmeticType(CosmeticsEnum.PRIMER.toString())
                    .availableQuantity(10)
                    .fdaNumber(1000000000000000L)
                    .price(new BigDecimal("25.00"))
                    .availableQuantity(2)
                    .tradingCurrency("GBP")
                    .build());

            cosmeticsRepository.save(Cosmetics.builder()
                    .cosmeticName("Mac")
                    .cosmeticType(CosmeticsEnum.BLUSH.toString())
                    .availableQuantity(2)
                    .fdaNumber(1100000000000000L)
                    .price(new BigDecimal("125.00"))
                    .availableQuantity(23)
                    .tradingCurrency("GBP")
                    .build());

            cosmeticsRepository.save(Cosmetics.builder()
                    .cosmeticName("Mac")
                    .cosmeticType(CosmeticsEnum.EYESHADOW.toString())
                    .availableQuantity(1)
                    .fdaNumber(1200000000000000L)
                    .price(new BigDecimal("5.00"))
                    .availableQuantity(2)
                    .tradingCurrency("GBP")
                    .build());

        }
    }
}
