package pl.szbd.virtualuniversity.domain.student.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedNativeQuery(name = "StudentSemester.getSemesters",
        query = "SELECT id, semester, semester_pass_date, average " +
                "FROM STUDENT_SEMESTERS " +
                "WHERE username = :username", resultSetMapping = "StudentStudySemester")
@SqlResultSetMapping(name = "StudentStudySemester",
        classes = @ConstructorResult(
                targetClass = StudentSemester.class,
                columns = {
                        @ColumnResult(name = "ID", type = Long.class),
                        @ColumnResult(name = "SEMESTER", type = Integer.class),
                        @ColumnResult(name = "SEMESTER_PASS_DATE", type = Date.class),
                        @ColumnResult(name = "AVERAGE", type = Double.class)
                }
        ))
public class StudentSemester {
    private Long id;
    private Integer semester;
    private Date semesterPassDate;
    private Double average;

    public StudentSemester() {
    }

    public StudentSemester(Long id, Integer semester, Date semesterPassDate, Double average) {
        this.id = id;
        this.semester = semester;
        this.semesterPassDate = semesterPassDate;
        this.average = average;
    }

    @Id
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "SEMESTER")
    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    @Column(name = "SEMESTER_PASS_DATE")
    public Date getSemesterPassDate() {
        return semesterPassDate;
    }

    public void setSemesterPassDate(Date semesterPassDate) {
        this.semesterPassDate = semesterPassDate;
    }

    @Column(name = "AVERAGE")
    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "StudentSemester{" +
                "id=" + id +
                ", semester=" + semester +
                ", semesterPassDate=" + semesterPassDate +
                ", average=" + average +
                '}';
    }
}
