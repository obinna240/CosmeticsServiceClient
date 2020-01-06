package ob.service.cosmeticsmanufacturer.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public final class Content {

    //    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Integer id;

    @Column(columnDefinition = "varchar(400)", unique = true)
    private String question;

    @Column(columnDefinition = "text", unique = true)
    private String answer;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }, mappedBy = "content")
    private Set<Predicate> predicate = new HashSet<>();

//    public Set<Predicate> getPredicate() {
//        return predicate;
//    }

    public Content(Integer id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public Content(){

    }

    private String getAnswer(){
        return answer;
    }

    private String getQuestion()
    {
        return question;
    }

    private Integer getId(){
        return id;
    }



}


