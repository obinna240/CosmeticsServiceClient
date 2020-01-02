package ob.service.cosmeticsmanufacturer.services;

import ob.service.cosmeticsmanufacturer.domain.Cosmetics;
import ob.service.cosmeticsmanufacturer.web.model.CosmeticsDto;

import java.util.List;
import java.util.UUID;

public interface CosmeticsService {

    CosmeticsDto getCosmeticsById(UUID cosmeticsId);

    CosmeticsDto save(CosmeticsDto cosmeticsDto);

    void update(UUID cosmeticsId, CosmeticsDto cosmeticsDto);

    void delete(UUID cosmeticsId);

    Cosmetics save(Cosmetics cosmetics);

    Cosmetics getCosmeticsObjById(UUID cosmeticsId);

    List<Cosmetics> getCosmeticsObjByType(String cosmeticsType);

    List<Cosmetics> getCosmeticsObjByName(String cosmeticsName);
}
