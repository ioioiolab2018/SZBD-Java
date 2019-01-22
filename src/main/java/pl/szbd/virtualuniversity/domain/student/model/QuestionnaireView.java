package pl.szbd.virtualuniversity.domain.student.model;

import java.util.Date;
import java.util.List;

public class QuestionnaireView {
    private Long questionnaireId;
    private String personId;
    private String name;
    private String content;
    private List<String> options;
    private String answer;
    private Date date;
    private String available;

    public QuestionnaireView() {
    }

    public QuestionnaireView(Long questionnaireId, String personId, String name, String content, List<String> options, String answer, Date date, String available) {
        this.questionnaireId = questionnaireId;
        this.personId = personId;
        this.name = name;
        this.content = content;
        this.options = options;
        this.answer = answer;
        this.date = date;
        this.available = available;
    }

    public Long getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Long questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
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

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "QuestionnaireView{" +
                "questionnaireId=" + questionnaireId +
                ", personId=" + personId +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", options='" + options + '\'' +
                ", answer='" + answer + '\'' +
                ", date=" + date +
                ", available='" + available + '\'' +
                '}';
    }
}
