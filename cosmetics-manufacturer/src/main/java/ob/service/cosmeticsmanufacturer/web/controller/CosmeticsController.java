package ob.service.cosmeticsmanufacturer.web.controller;

import lombok.extern.slf4j.Slf4j;
import ob.service.cosmeticsmanufacturer.domain.Cosmetics;
import ob.service.cosmeticsmanufacturer.services.CosmeticsService;
import ob.service.cosmeticsmanufacturer.web.model.CosmeticsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@Slf4j
@RequestMapping("/api/v1/cosmetics")
@RestController
public class CosmeticsController {

    @Autowired
    private final CosmeticsService cosmeticsService;

    public CosmeticsController(CosmeticsService cosmeticsService) {
        this.cosmeticsService = cosmeticsService;
    }

    @GetMapping("/{cosmeticsId}")
    public ResponseEntity<CosmeticsDto> getCosmetics(@PathVariable("cosmeticsId") UUID cosmeticsId){
        return new ResponseEntity<>(cosmeticsService.getCosmeticsById(cosmeticsId), HttpStatus.OK);
    }

    //potentially use @Validated (spring validation) or @Valid fom javax
    @PostMapping
    public ResponseEntity postNewCosmetics(@Validated @RequestBody CosmeticsDto cosmeticsDto) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "api/v1/cosmetics/"+cosmeticsDto.getId().toString());
        return new ResponseEntity<>(cosmeticsService.save(cosmeticsDto), httpHeaders, HttpStatus.CREATED);
    }


    @PutMapping("/{cosmeticsId}")
    public ResponseEntity putCosmetics(@PathVariable("cosmeticsId") UUID cosmeticsId, @Validated @RequestBody CosmeticsDto cosmeticsDto) {

        cosmeticsService.update(cosmeticsId, cosmeticsDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{cosmeticsId")
    public void deleteCosmetics(@PathVariable("cosmeticsId") UUID cosmeticsId) {
        cosmeticsService.delete(cosmeticsId);
    }

    /**
     * Select directly from DB
     * @param cosmetic
     * @return
     */
    @PostMapping("/postCosmetic")
    public ResponseEntity postCosmeticToDB(@RequestBody Cosmetics cosmetic){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "api/v1/cosmetics/"+cosmetic.getId().toString());
        return new ResponseEntity<>(cosmeticsService.save(cosmetic), httpHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/getCosmetic/{cosmeticId}")
    public ResponseEntity getCosmeticToDB(@PathVariable("cosmeticId") UUID cosmeticId) {
        return new ResponseEntity<>(cosmeticsService.getCosmeticsObjById(cosmeticId), HttpStatus.OK);
    }

    @GetMapping("/getCosmeticByType/{cosmeticType}")
    public ResponseEntity getCosmeticByType(@PathVariable("cosmeticType") String cosmeticType) {
        return new ResponseEntity<>(cosmeticsService.getCosmeticsObjByType(cosmeticType), HttpStatus.OK);
    }


    @GetMapping("/getCosmeticByName/{cosmeticName}")
    public ResponseEntity getCosmeticByName(@PathVariable("cosmeticName") String cosmeticName) {
        return new ResponseEntity<>(cosmeticsService.getCosmeticsObjByName(cosmeticName), HttpStatus.OK);
    }

}
