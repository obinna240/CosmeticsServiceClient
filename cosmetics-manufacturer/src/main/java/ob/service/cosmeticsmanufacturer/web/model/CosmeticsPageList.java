package ob.service.cosmeticsmanufacturer.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;

public class CosmeticsPageList extends PageImpl<CosmeticsDto> {

    public CosmeticsPageList(List<CosmeticsDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public CosmeticsPageList(List<CosmeticsDto> content) {
        super(content);
    }
}
