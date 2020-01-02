package ob.service.cosmeticsmanufacturer.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public final class CosmeticsDto implements Serializable {

    static final long serialVersionID = -8212094859048375763L;

    //Make this null since we do not want clients setting the id
    //@Null
    private UUID id;
    @NotBlank
    private String cosmeticName;

    @NotNull
    private String cosmeticType;

    @Positive
    @NotNull
    private Long fdaNumber;

    @Null
    private OffsetDateTime creationDate;
    @Null
    private OffsetDateTime modificationDate;
    private CosmeticsEnum cosmeticEnum;

    @Positive
    private Integer availableQuantity;

    @NotNull
    private BigInteger price;
    private TradingCurrencyEnum tradingCurrency;
}
