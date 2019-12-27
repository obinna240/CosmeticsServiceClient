package com.ob.cosmeticsclient.client;

import com.ob.cosmeticsclient.model.CosmeticsDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

/**
 * An alternative is to use Feign
 */
@Component
@ConfigurationProperties(value = "ob.cosmetics", ignoreInvalidFields = false)
public class CosmeticsClient {

    public final String COSMTEICS_PATH = "/api/v1/cosmetics/";
    private String apiHost;
    private final RestTemplate restTemplate;

    public CosmeticsClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    /**
     * GET CosmeticsDto
     * @param uuid
     * @return
     */
    public CosmeticsDto getCosmteticsById(UUID uuid){
        return restTemplate.getForObject(apiHost + COSMTEICS_PATH + uuid.toString(), CosmeticsDto.class);
    }

    /**
     * POST a new CosmeticsDto
     * @param cosmeticsDto
     * @return
     */
    public URI saveNewCosmetic(CosmeticsDto cosmeticsDto){
        return restTemplate.postForLocation(apiHost + COSMTEICS_PATH, cosmeticsDto);
    }

    /**
     * PUT a new Cosmetics Dto
     * @param uuid
     * @param cosmeticsDto
     */
    public void updateCosmetics(UUID uuid, CosmeticsDto cosmeticsDto){
        restTemplate.put(apiHost + COSMTEICS_PATH + uuid.toString(), cosmeticsDto);
    }

    /**
     * DELETE cosmetics
     * @param uuid
     */
    public void deleteCosmetics(UUID uuid){
        restTemplate.delete(apiHost + COSMTEICS_PATH + uuid);
    }
}
