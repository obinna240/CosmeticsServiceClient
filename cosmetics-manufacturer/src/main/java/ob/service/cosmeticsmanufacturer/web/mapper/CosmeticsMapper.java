package ob.service.cosmeticsmanufacturer.web.mapper;

import ob.service.cosmeticsmanufacturer.domain.Cosmetics;
import ob.service.cosmeticsmanufacturer.web.model.CosmeticsDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface CosmeticsMapper {

    CosmeticsDto cosmeticToCosmeticDto(Cosmetics cosmetics);
    Cosmetics cosmeticsDtoToCosmetics(CosmeticsDto cosmeticsDto);
}
