package ob.service.cosmeticsmanufacturer.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Class implementing composite dbms key
 * This class must use the
 * @Embeddable annotation
 * it must also implements equals and hashcode
 */
@Embeddable
public class PredicateAttributeKey implements Serializable {


    @Column(name = "predicateId")
    private String predicateId;

    public String getPredicateId() {
        return predicateId;
    }

    public Integer getAttributeId() {
        return attributeId;
    }

    @Column(name = "attributeId")
    private Integer attributeId;

    public PredicateAttributeKey(String predicateId, Integer attributeId) {
        this.predicateId = predicateId;
        this.attributeId = attributeId;
    }

    public PredicateAttributeKey(){

    }


    @Override
    public int hashCode(){
        return new HashCodeBuilder(83, 7)
                .append(attributeId)
                .append(predicateId)
                .toHashCode();
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof PredicateAttributeKey)) {
            return false;
        }
        if(o == this) {
            return true;
        }
        PredicateAttributeKey predicateAttributeKey = (PredicateAttributeKey)o;
        return new EqualsBuilder()
                .append(attributeId, predicateAttributeKey.attributeId)
                .append(predicateId, predicateAttributeKey.predicateId)
                .isEquals();
    }

}
