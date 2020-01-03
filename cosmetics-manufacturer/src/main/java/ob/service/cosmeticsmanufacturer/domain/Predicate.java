package ob.service.cosmeticsmanufacturer.domain;


import org.apache.commons.lang3.Validate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 *
 */
@Entity
@Table(name = "Predicate")
public final class Predicate {

    public Predicate(){

    }

    @Id
    private String id;

    @Column(columnDefinition = "varchar(70)")
    private String location;

    @Column(columnDefinition = "varchar(70)")
    private String category;

    @Column(columnDefinition = "varchar(70)")
    private String keyword;

    @JoinTable(
            name = "pred_content",
            joinColumns = @JoinColumn(name = "criteriapredicate_id"),
            inverseJoinColumns = @JoinColumn(name = "content_id"))
    @ManyToMany
    Set<Content> somecontent;

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }

    public String getKeyword() {
        return keyword;
    }

    public static class Builder {
        private String id;
        private String location;
        private String category;
        private String keyword;


        public Builder id(String aId){
            Validate.notBlank(aId, "This id cannot be null");
            id = aId;
            return this;
        }

        public Builder location(String aLocation){
            location = aLocation;
            return this;
        }

        public Builder category(String aCategory){
            category = aCategory;
            return this;
        }

        public Builder keyword(String aKeyword){
            keyword = aKeyword;
            return this;
        }

        public Predicate build() {
            return new Predicate(this);
        }

    }

    private Predicate(Builder builder){
        id = builder.id;
        category = builder.category;
        keyword = builder.keyword;
        location = builder.location;
    }
}