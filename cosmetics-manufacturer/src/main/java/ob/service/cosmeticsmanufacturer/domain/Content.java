package ob.service.cosmeticsmanufacturer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "cosmeticsContent")
public final class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(columnDefinition = "varchar(400)", unique = true)
    private final String question;

    @Column(columnDefinition = "text", unique = true)
    private final String answer;

    @ManyToMany
    Set<Predicate> predicate;

    public Content(String question, String answer) {
        this.question = question;
        this.answer = answer;
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


