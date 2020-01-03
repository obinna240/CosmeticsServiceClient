package ob.service.cosmeticsmanufacturer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public final class Attribute {

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Id
    private Integer id;

    @Column(columnDefinition = "varchar(60)")
    private String title;

    @Column(columnDefinition = "varchar(60)", unique = true)
    private String description;


    public Attribute(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Attribute(){

    }
}
