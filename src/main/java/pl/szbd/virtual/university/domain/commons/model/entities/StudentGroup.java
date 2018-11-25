package pl.szbd.virtual.university.domain.commons.model.entities;

import pl.szbd.virtual.university.domain.commons.model.enums.StudyTypeEnum;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "STUDENT_GROUPS")
public class StudentGroup {
    private Long id;
    private Integer studyYear;
    private Integer semester;
    private String faculty;
    private String studyField;
    private String studyMode;
    private StudyTypeEnum type;
    private Date startDate;
    private Date endDate;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public Integer getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(Integer studyYear) {
        this.studyYear = studyYear;
    }

    @Column
    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
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

    @Column(name = "STUDY_MODE")
    public String getStudyMode() {
        return studyMode;
    }

    public void setStudyMode(String studyMode) {
        this.studyMode = studyMode;
    }

    @Column(name = "TYPE")
    public StudyTypeEnum getType() {
        return type;
    }

    public void setType(StudyTypeEnum type) {
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
