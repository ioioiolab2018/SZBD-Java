package pl.szbd.virtual.university.domain.commons.model.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import pl.szbd.virtual.university.domain.commons.model.enums.AcademicDegreeEnum;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "LECTURERS")
@PrimaryKeyJoinColumn(name = "lecturer_id")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Lecturer extends Person {
    private AcademicDegreeEnum academicDefree;
    private String office;
    private Date startDate;
    private Date endDate;


    @Enumerated(EnumType.STRING)
    @Column(name = "ACADEMIC_DEGREE")
    public AcademicDegreeEnum getAcademicDefree() {
        return academicDefree;
    }

    public void setAcademicDefree(AcademicDegreeEnum academicDefree) {
        this.academicDefree = academicDefree;
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
                "academicDefree='" + academicDefree.toString() + '\'' +
                ", office='" + office + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
