package com.ob.cosmeticsclient.client;

import com.ob.cosmeticsclient.model.CosmeticsDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CosmeticsClientTest {

    @Autowired
    CosmeticsClient cosmeticsClient;

    @Test
    void getCosmteticsById() {
        CosmeticsDto cosmeticsDto = cosmeticsClient.getCosmteticsById(UUID.randomUUID());
        assertNotNull(cosmeticsDto);
    }

    @Test
    void saveNewCosmeticsDtoObject() {
        CosmeticsDto cosmeticsDto = CosmeticsDto.builder().cosmeticName("test").build();
        URI uri = cosmeticsClient.saveNewCosmetic(cosmeticsDto);
        assertNotNull(uri);

    }

    @Test
    void testUpdateCosmetics(){
        CosmeticsDto cosmeticsDto = CosmeticsDto.builder().cosmeticName("test").build();
        cosmeticsClient.updateCosmetics(UUID.randomUUID(), cosmeticsDto);
    }

    @Test
    void deleteCosmetics(){
        cosmeticsClient.deleteCosmetics(UUID.randomUUID());
    }

}