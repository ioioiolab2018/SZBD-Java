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
    private Long studySubjectId;
    private Long studentIndex;


    @Id
    @SequenceGenerator(name = "gradeSeq", sequenceName = "GRADES_SEQ")
    @GeneratedValue(generator = "gradeSeq", strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "SUBJECT_ID")
    public Long getStudySubjectId() {
        return studySubjectId;
    }

    public void setStudySubjectId(Long studySubjectId) {
        this.studySubjectId = studySubjectId;
    }

    @Column(name = "STUDENT_ID")
    public Long getStudentIndex(){
        return studentIndex;
    }

    public void setStudentIndex(Long studentIndex) {
        this.studentIndex = studentIndex;
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
                ", subject=" + studySubjectId +
                ", student=" + studentIndex +
                '}';
    }
}
