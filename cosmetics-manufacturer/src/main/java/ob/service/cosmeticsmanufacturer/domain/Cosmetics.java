package ob.service.cosmeticsmanufacturer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Hibernate creates this for us
 */

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cosmetics {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 40, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID id;
    private String cosmeticName;
    private String cosmeticType;

    @Column(unique = true)
    private Long fdaNumber;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp creationDate;

    @UpdateTimestamp
    private Timestamp modificationDate;

    private String cosmeticTypeName;
    private Integer availableQuantity;
    private BigDecimal price;
    private String tradingCurrency;
    private Integer quantityToCreate;

    @Version
    private Long version;
}
