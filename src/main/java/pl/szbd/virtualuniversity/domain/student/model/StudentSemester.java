package pl.szbd.virtualuniversity.domain.student.model;

import javax.persistence.*;

@Entity
@NamedNativeQuery(name = "StudentSemester.getSemesters",
        query = "SELECT id, semester " +
                "FROM STUDENT_SEMESTERS " +
                "WHERE username = :username", resultSetMapping = "StudentStudySemester")
@SqlResultSetMapping(name = "StudentStudySemester",
        classes = @ConstructorResult(
                targetClass = StudentSemester.class,
                columns = {
                        @ColumnResult(name = "ID", type = Long.class),
                        @ColumnResult(name = "SEMESTER", type = Integer.class)
                }
        ))
public class StudentSemester {
    private Long id;
    private Integer semester;

    public StudentSemester() {
    }

    public StudentSemester(Long id, Integer semester) {
        this.id = id;
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

    @Column(name = "SEMESTER")
    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "StudentSemester{" +
                "id=" + id +
                ", semester=" + semester +
                '}';
    }
}
