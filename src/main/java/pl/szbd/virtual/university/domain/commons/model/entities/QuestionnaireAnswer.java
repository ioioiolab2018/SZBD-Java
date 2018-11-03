package pl.szbd.virtual.university.domain.commons.model.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "QUESTIONNAIRE_ANSWERS")
public class QuestionnaireAnswer {
    private Long id;
    private String Value;
    private Questionnaire questionnaire;
    private Person person;
    private Date date;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "VALUE")
    @Lob
    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "questionnaire_id")
    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Column(name = "QUEST_DATE")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "QuestionnaireAnswer{" +
                "id=" + id +
                ", Value='" + Value + '\'' +
                ", questionnaire=" + questionnaire +
                ", person=" + person +
                ", date=" + date +
                '}';
    }
}
