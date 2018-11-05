package pl.szbd.virtual.university.domain.commons.model.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "QUESTIONNAIRE_ANSWERS")
public class QuestionnaireAnswer {
    private Long id;
    private String answer;
    private Questionnaire questionnaire;
    private Person person;
    private Date date;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "questionnaire_Answer_Sequence")
    @SequenceGenerator(name = "questionnaire_Answer_Sequence", sequenceName = "QUESTIONNAIRE_ANSWER_SEQ")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "ANSWER")
    @Lob
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTIONNAIRE_ID")
    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Column(name = "DT")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "{ " +
                "id: " + id +
                ", answer: '" + answer + '\'' +
                ", questionnaire: " + questionnaire +
                ", person: " + person +
                ", date: " + date +
                " }";
    }
}
