package ob.service.cosmeticsmanufacturer.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Hibernate creates this for us
 */

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cosmetics")
public class Cosmetics {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 40, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    @Type(type="org.hibernate.type.UUIDCharType")
    @JsonDeserialize(using= UUIDDeserializer.class) //we could use our own custom deserializer here
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
