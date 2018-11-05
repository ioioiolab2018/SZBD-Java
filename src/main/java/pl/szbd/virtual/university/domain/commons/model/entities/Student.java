package pl.szbd.virtual.university.domain.commons.model.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import pl.szbd.virtual.university.domain.commons.model.enums.StudentStatusEnum;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "STUDENTS")
@PrimaryKeyJoinColumn(name = "student_id")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Student extends Person {


    private Float lastAverage;
    private Date startDate;
    private Date endDate;
    private Integer studyYear;
    private Integer semester;
    private Integer ectsPoints;
    private StudentStatusEnum status;

    @Basic
    @Column(name = "LAST_AVERAGE")
    public Float getLastAverage() {
        return lastAverage;
    }

    public void setLastAverage(Float lastAverage) {
        this.lastAverage = lastAverage;
    }

    @Basic
    @Column(name = "START_DATE")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    @Basic
    @Column(name = "END_DATE")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "STUDY_YEAR")
    public Integer getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(Integer studyYear) {
        this.studyYear = studyYear;
    }

    @Basic
    @Column(name = "SEMESTER")
    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    @Basic
    @Column(name = "ECTS_POINTS")
    public Integer getEctsPoints() {
        return ectsPoints;
    }

    public void setEctsPoints(Integer ectsPoints) {
        this.ectsPoints = ectsPoints;
    }


    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    public StudentStatusEnum getStatus() {
        return status;
    }

    public void setStatus(StudentStatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "lastAverage=" + lastAverage +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", studyYear=" + studyYear +
                ", semester=" + semester +
                ", ectsPoints=" + ectsPoints +
                ", status='" + status + '\'' +
                '}';
    }


}
