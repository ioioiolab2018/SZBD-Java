package pl.szbd.virtualuniversity.domain.commons.model.entities;

import pl.szbd.virtualuniversity.domain.commons.model.enums.GradeTypeEnum;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "GRADES")
public class Grade {
    private Long id;
    private Date date;
    private Float value;
    private GradeTypeEnum type;
    private StudySubject subject;
    private Student student;


    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    public StudySubject getSubject() {
        return subject;
    }

    public void setSubject(StudySubject subject) {
        this.subject = subject;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Column(name = "GRADE_DATE")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "VALUE")
    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    public GradeTypeEnum getType() {
        return type;
    }

    public void setType(GradeTypeEnum type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", date=" + date +
                ", value=" + value +
                ", type='" + type.toString() + '\'' +
                ", subject=" + subject +
                ", student=" + student +
                '}';
    }
}
