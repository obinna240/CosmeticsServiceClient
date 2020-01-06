package ob.service.cosmeticsmanufacturer.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
@Entity
@Table(name = "Predicate")
public final class Predicate {

    public Predicate(){

    }

    public Predicate(String id, String location, String category, String keyword) {
        this.id = id;
        this.location = location;
        this.category = category;
        this.keyword = keyword;
    }

    @Id
    private String id;

    @Column(columnDefinition = "varchar(70)")
    private String location;

    @Column(columnDefinition = "varchar(70)")
    private String category;

    @Column(columnDefinition = "varchar(70)")
    private String keyword;

    public Set<Content> getContent() {
        return content;
    }

    @JoinTable(
            name = "predicate_content",
            joinColumns = @JoinColumn(name = "predicate_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "content_id", referencedColumnName = "id"))

    @ManyToMany(targetEntity = Content.class, fetch = FetchType.LAZY,
            cascade = {
//                    CascadeType.ALL
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    private Set<Content> content = new HashSet<>();;


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

//
//    public static class Builder {
//        private String id;
//        private String location;
//        private String category;
//        private String keyword;
//        private Set<Content> somecontent = new HashSet<Content>();
//
//
//        public Builder id(String aId){
//            Validate.notBlank(aId, "This id cannot be null");
//            id = aId;
//            return this;
//        }
//
//        public Builder location(String aLocation){
//            location = aLocation;
//            return this;
//        }
//
//        public Builder category(String aCategory){
//            category = aCategory;
//            return this;
//        }
//
//        public Builder keyword(String aKeyword){
//            keyword = aKeyword;
//            return this;
//        }
//
//        public Builder content(Content... content){
//            for(Content contents:content){
//                somecontent.add(contents);
//            }
//            return this;
//        }
//
//        public Predicate build() {
//            return new Predicate(this);
//        }
//
//    }

//    private Predicate(Builder builder){
//        id = builder.id;
//        category = builder.category;
//        keyword = builder.keyword;
//        location = builder.location;
//    }

    @Override
    public int hashCode(){
        return new HashCodeBuilder(83, 7)
                .append(id)
                .append(location)
                .append(category)
                .append(keyword)
                .toHashCode();
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Predicate)) {
            return false;
        }
        if(o == this) {
            return true;
        }
        Predicate pred = (Predicate)o;
        return new EqualsBuilder()
                .append(keyword, pred.keyword)
                .append(location, pred.location)
                .append(category, pred.category)
                .append(id, pred.id)
                .isEquals();
    }
}