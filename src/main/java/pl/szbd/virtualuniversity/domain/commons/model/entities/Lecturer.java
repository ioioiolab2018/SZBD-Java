package pl.szbd.virtualuniversity.domain.commons.model.entities;

import pl.szbd.virtualuniversity.domain.commons.model.enums.AcademicDegreeType;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "LECTURERS")
public class Lecturer {
    private Long index;
    private String personId;
    private AcademicDegreeType academicDegree;
    private String office;
    private Date startDate;
    private Date endDate;

    @Id
    @Column(name = "LECTURER_INDEX")
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

    @Enumerated(EnumType.STRING)
    @Column(name = "ACADEMIC_DEGREE")
    public AcademicDegreeType getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(AcademicDegreeType academicDegree) {
        this.academicDegree = academicDegree;
    }

    @Basic
    @Column(name = "OFFICE")
    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
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

    @Override
    public String toString() {
        return "Lecturer{" +
                "index=" + index +
                ", personId='" + personId + '\'' +
                ", academicDegree=" + academicDegree +
                ", office='" + office + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
