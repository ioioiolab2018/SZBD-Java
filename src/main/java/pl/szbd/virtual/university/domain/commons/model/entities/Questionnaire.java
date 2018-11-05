package pl.szbd.virtual.university.domain.commons.model.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "QUESTIONNAIRE")
public class Questionnaire {
    private Long id;
    private String name;
    private String content;
    private String options;
    private Date startDate;
    private Date endDate;
    private String single;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "questionnaire_Sequence")
    @SequenceGenerator(name = "questionnaire_Sequence", sequenceName = "QUESTIONNAIRE_SEQ")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "CONTENT")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "OPTIONS")
    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    @Column(name = "START_DATE")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "END_DATE")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Column(name = "SINGLE")
    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    @Override
    public String toString() {
        return "{ " +
                "id: " + id +
                ", name: '" + name + '\'' +
                ", content: '" + content + '\'' +
                ", options: '" + options + '\'' +
                ", startDate: " + startDate +
                ", endDate: " + endDate +
                ", single: '" + single + '\'' +
                " }";
    }
}
