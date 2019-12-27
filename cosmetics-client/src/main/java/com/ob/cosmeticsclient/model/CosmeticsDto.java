package com.ob.cosmeticsclient.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.money.MonetaryAmount;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Alternatively we can use a swagger client
 */
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public final class CosmeticsDto {

    private UUID id;
    private String cosmeticName;
    private String cosmeticType;
    private Long fdaNumber;
    private OffsetDateTime creationDate;
    private OffsetDateTime modificationDate;
    private CosmeticsEnum cosmeticEnum;
    private Integer availableQuantity;
    private MonetaryAmount price;
    private TradingCurrencyEnum tradingCurrency;
}
