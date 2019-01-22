package pl.szbd.virtualuniversity.domain.commons.model.entities;


import pl.szbd.virtualuniversity.domain.commons.model.enums.StudentStatus;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "STUDENTS")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "Update_semester",
                procedureName = "STUDENTAVERAGECALCULATIONS.UPDATESEMESTER",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "student_index", type = Long.class)
                })
})
public class Student {
    private long index;
    private String personId;
    private Integer ectsPoints;
    private Date startDate;
    private Date endDate;
    private Float lastAverage;
    private Integer semester;
    private StudentStatus status;
    private Integer studyYear;

    @Id
    @SequenceGenerator(name = "studentSeq", sequenceName = "STUDENTS_SEQ")
    @GeneratedValue(generator = "studentSeq", strategy = GenerationType.AUTO)
    @Column(name = "STUDENT_INDEX")
    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    @Column(name = "PERSON_ID")
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "ECTS_POINTS")
    public Integer getEctsPoints() {
        return ectsPoints;
    }

    public void setEctsPoints(Integer ectsPoints) {
        this.ectsPoints = ectsPoints;
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
    @Column(name = "LAST_AVERAGE")
    public Float getLastAverage() {
        return lastAverage;
    }

    public void setLastAverage(Float lastAverage) {
        this.lastAverage = lastAverage;
    }

    @Basic
    @Column(name = "SEMESTER")
    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    @Basic
    @Column(name = "STUDY_YEAR")
    public Integer getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(Integer studyYear) {
        this.studyYear = studyYear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "index=" + index +
                ", personId='" + personId + '\'' +
                ", ectsPoints=" + ectsPoints +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", lastAverage=" + lastAverage +
                ", semester=" + semester +
                ", status=" + status +
                ", studyYear=" + studyYear +
                '}';
    }
}
