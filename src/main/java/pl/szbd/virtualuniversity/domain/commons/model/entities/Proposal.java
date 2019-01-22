package pl.szbd.virtualuniversity.domain.commons.model.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "PROPOSALS")
public class Proposal {
    private Long id;
    private String personId;
    private String topic;
    private String content;
    private Date submissionDate;
    private String shortAnswer;
    private String answer;
    private Date answerDate;

    @Id
    @SequenceGenerator(name = "proposalSeq", sequenceName = "PROPOSALS_SEQ")
    @GeneratedValue(generator = "proposalSeq", strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "PERSON_ID")
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Column(name = "TOPIC")
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Lob
    @Column(name = "CONTENT")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "SUBMISSION_DATE")
    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    @Column(name = "SHORT_ANSWER")
    public String getShortAnswer() {
        return shortAnswer;
    }

    public void setShortAnswer(String shortAnswer) {
        this.shortAnswer = shortAnswer;
    }

    @Lob
    @Column(name = "ANSWER")
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Column(name = "ANSWER_DATE")
    public Date getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(Date answerDate) {
        this.answerDate = answerDate;
    }

    @Override
    public String toString() {
        return "{ " +
                "id: " + id +
                ", personId: " + personId +
                ", topic: '" + topic + '\'' +
                ", content: '" + content + '\'' +
                ", submissionDate: " + submissionDate +
                ", shortAnswer: '" + shortAnswer + '\'' +
                ", answer: '" + answer + '\'' +
                ", answerDate: " + answerDate +
                " }";
    }
}
