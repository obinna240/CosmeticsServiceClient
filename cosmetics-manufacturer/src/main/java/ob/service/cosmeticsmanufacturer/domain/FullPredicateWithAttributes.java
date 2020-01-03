package ob.service.cosmeticsmanufacturer.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 * Having created the composite entity key @PredicateAttributeKey
 * which we will use in binding Predicates and Attributes, we now create this class
 * Unlike in the previous method, here we want to include an additional attribute
 */
@Entity
public class FullPredicateWithAttributes {

    @EmbeddedId
    PredicateAttributeKey id;

    @ManyToOne
    @MapsId("predicateId")
    @JoinColumn(name = "predicateId")
    Predicate predicate;

    @ManyToOne
    @MapsId("attributeId")
    @JoinColumn(name = "attributeId")
    Attribute attribute;

    //the new property to add
    int version;
}
