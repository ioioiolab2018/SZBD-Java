package pl.szbd.virtualuniversity.domain.commons.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "QUESTIONNAIRE_ANSWERS")
public class QuestionnaireAnswer implements Serializable {
    @EmbeddedId
    private QuestionnaireAnswerIdentity questionnaireAnswerIdentity;
    @Lob
    @Column(name = "ANSWER")
    private String answer;
    @Column(name = "DT")
    private Date date;

    public QuestionnaireAnswer() {
    }

    public QuestionnaireAnswer(QuestionnaireAnswerIdentity questionnaireAnswerIdentity, String answer, Date date) {
        this.questionnaireAnswerIdentity = questionnaireAnswerIdentity;
        this.answer = answer;
        this.date = date;
    }

    public QuestionnaireAnswer(String personId, Long questionnaireId, String answer, Date date) {
        this.questionnaireAnswerIdentity = new QuestionnaireAnswerIdentity(personId, questionnaireId);
        this.answer = answer;
        this.date = date;
    }

    public QuestionnaireAnswerIdentity getQuestionnaireAnswerIdentity() {
        return questionnaireAnswerIdentity;
    }

    public void setQuestionnaireAnswerIdentity(QuestionnaireAnswerIdentity questionnaireAnswerIdentity) {
        this.questionnaireAnswerIdentity = questionnaireAnswerIdentity;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "QuestionnaireAnswer{" +
                "questionnaireAnswerIdentity=" + questionnaireAnswerIdentity +
                ", answer='" + answer + '\'' +
                ", date=" + date +
                '}';
    }
}
