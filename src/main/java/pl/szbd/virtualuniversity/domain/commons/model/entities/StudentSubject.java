package pl.szbd.virtualuniversity.domain.commons.model.entities;

import javax.persistence.*;

@Entity
@NamedNativeQuery(name = "StudentSubject.getSubjects",
        query = "SELECT id, name, lecturer, ects_value, complete, semester " +
                "FROM STUDENT_SUBJECTS " +
                "WHERE username = :username AND semester in :semesters", resultSetMapping = "StudentStudySubject")
@SqlResultSetMapping(name = "StudentStudySubject",
        classes = @ConstructorResult(
                targetClass = StudentSubject.class,
                columns = {
                        @ColumnResult(name = "ID", type = Long.class),
                        @ColumnResult(name = "NAME", type = String.class),
                        @ColumnResult(name = "LECTURER", type = String.class),
                        @ColumnResult(name = "ECTS_VALUE", type = Integer.class),
                        @ColumnResult(name = "COMPLETE", type = String.class),
                        @ColumnResult(name = "SEMESTER", type = Integer.class)
                }
        ))
public class StudentSubject {
    private Long id;
    private String name;
    private String lecturer;
    private Integer ectsValue;
    private String complete;
    private Integer semester;

    public StudentSubject() {
    }

    public StudentSubject(Long id, String name, String lecturer, Integer ectsValue, String complete, Integer semester) {
        this.id = id;
        this.name = name;
        this.lecturer = lecturer;
        this.ectsValue = ectsValue;
        this.complete = complete;
        this.semester = semester;
    }

    @Id
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Column(name = "ECTS_VALUE")
    public Integer getEctsValue() {
        return ectsValue;
    }

    public void setEctsValue(Integer ectsValue) {
        this.ectsValue = ectsValue;
    }

    @Column(name = "COMPLETE")
    public String getComplete() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    @Column(name = "SEMESTER")
    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "StudentSubject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lecturer='" + lecturer + '\'' +
                ", ectsValue=" + ectsValue +
                ", complete='" + complete + '\'' +
                ", semester=" + semester +
                '}';
    }
}
