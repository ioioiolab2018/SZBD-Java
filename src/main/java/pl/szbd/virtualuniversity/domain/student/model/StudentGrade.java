package pl.szbd.virtualuniversity.domain.student.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedNativeQuery(name = "StudentGrade.getGrades",
        query = "SELECT name, lecturer, pass_date, first_value, second_value " +
                "FROM STUDENT_GRADES " +
                "WHERE username = :username AND group_id = :groupId", resultSetMapping = "StudentGradeEntity")
@SqlResultSetMapping(name = "StudentGradeEntity",
        classes = @ConstructorResult(
                targetClass = StudentGrade.class,
                columns = {
                        @ColumnResult(name = "NAME", type = String.class),
                        @ColumnResult(name = "LECTURER", type = String.class),
                        @ColumnResult(name = "PASS_DATE", type = Date.class),
                        @ColumnResult(name = "FIRST_VALUE", type = Double.class),
                        @ColumnResult(name = "SECOND_VALUE", type = Double.class)
                }
        ))
public class StudentGrade {
    private String name;
    private String lecturer;
    private Date passDate;
    private Double firstValue;
    private Double secondValue;

    public StudentGrade() {
    }

    public StudentGrade(String name, String lecturer, Date passDate, Double firstValue, Double secondValue) {
        this.name = name;
        this.lecturer = lecturer;
        this.passDate = passDate;
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    @Id
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "LECTURER")
    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    @Column(name = "PASS_DATE")
    public Date getPassDate() {
        return passDate;
    }

    public void setPassDate(Date passDate) {
        this.passDate = passDate;
    }

    @Column(name = "FIRST_VALUE")
    public Double getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(Double firstValue) {
        this.firstValue = firstValue;
    }

    @Column(name = "SECOND_VALUE")
    public Double getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(Double secondValue) {
        this.secondValue = secondValue;
    }

    @Override
    public String toString() {
        return "StudentGrade{" +
                "name='" + name + '\'' +
                ", lecturer='" + lecturer + '\'' +
                ", passDate=" + passDate +
                ", firstValue=" + firstValue +
                ", secondValue=" + secondValue +
                '}';
    }
}
