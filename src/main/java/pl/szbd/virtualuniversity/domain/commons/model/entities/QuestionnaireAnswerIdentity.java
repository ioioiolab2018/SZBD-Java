package pl.szbd.virtualuniversity.domain.commons.model.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class QuestionnaireAnswerIdentity implements Serializable {
    @NotNull
    @Column(name = "PERSON_ID")
    private String personId;
    @NotNull
    @Column(name = "QUESTIONNAIRE_ID")
    private Long questionnaireId;

    public QuestionnaireAnswerIdentity() {
    }

    public QuestionnaireAnswerIdentity(String personId, Long questionnaireId) {
        this.personId = personId;
        this.questionnaireId = questionnaireId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Long getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Long questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionnaireAnswerIdentity that = (QuestionnaireAnswerIdentity) o;
        return personId.equals(that.personId) &&
                questionnaireId.equals(that.questionnaireId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, questionnaireId);
    }

    @Override
    public String toString() {
        return "QuestionnaireAnswerIdentity{" +
                "personId='" + personId + '\'' +
                ", questionnaireId=" + questionnaireId +
                '}';
    }
}
