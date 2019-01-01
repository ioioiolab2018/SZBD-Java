package pl.szbd.virtualuniversity.domain.commons.model.entities;

import pl.szbd.virtualuniversity.domain.commons.model.enums.StudyMode;
import pl.szbd.virtualuniversity.domain.commons.model.enums.StudyType;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "STUDENT_GROUPS")
public class StudentGroup {
    private Long id;
    private String faculty;
    private String studyField;
    private StudyMode studyMode;
    private StudyType type;
    private Date startDate;
    private Date endDate;

    @Id
    @SequenceGenerator(name = "studentGroupSeq", sequenceName = "STUDENT_GROUPS_SEQ")
    @GeneratedValue(generator = "studentGroupSeq", strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "FACULTY")
    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Column(name = "STUDY_FIELD")
    public String getStudyField() {
        return studyField;
    }

    public void setStudyField(String studyField) {
        this.studyField = studyField;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "STUDY_MODE")
    public StudyMode getStudyMode() {
        return studyMode;
    }

    public void setStudyMode(StudyMode studyMode) {
        this.studyMode = studyMode;
    }

    @Column(name = "TYPE")
    public StudyType getType() {
        return type;
    }

    public void setType(StudyType type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "StudentGroup{" +
                "id=" + id +
                ", faculty='" + faculty + '\'' +
                ", studyField='" + studyField + '\'' +
                ", studyMode='" + studyMode + '\'' +
                ", type='" + type + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
