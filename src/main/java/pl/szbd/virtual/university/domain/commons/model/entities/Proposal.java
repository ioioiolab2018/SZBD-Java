package pl.szbd.virtual.university.domain.commons.model.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "PROPOSALS")
public class Proposal {
    private Long id;
    private Person person;
    private String topic;
    private String content;
    private String answer;
    private Date submissionDate;
    private Date answerDate;
    private String shortAnswer;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "proposal_Sequence")
    @SequenceGenerator(name = "proposal_Sequence", sequenceName = "PROPOSAL_SEQ")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Column(name = "TOPIC")
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Column(name = "CONTENT")
    @Lob
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "ANSWER")
    @Lob
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Column(name = "SUBMISSION_DATE")
    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    @Column(name = "ANSWER_DATE")
    public Date getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(Date answerDate) {
        this.answerDate = answerDate;
    }

    @Column(name = "SHORT_ANSWER")
    public String getShortAnswer() {
        return shortAnswer;
    }

    public void setShortAnswer(String shortAnswer) {
        this.shortAnswer = shortAnswer;
    }

    @Override
    public String toString() {
        return "{ " +
                "id: " + id +
                ", person: " + person +
                ", topic: '" + topic + '\'' +
                ", content: '" + content + '\'' +
                ", answer: '" + answer + '\'' +
                ", submissionDate: " + submissionDate +
                ", answerDate: " + answerDate +
                ", shortAnswer: '" + shortAnswer + '\'' +
                " }";
    }
}
