package pl.szbd.virtualuniversity.domain.student.model;

import javax.persistence.*;

@Entity
@NamedNativeQuery(name = "Semester.getSemesters",
        query = "SELECT id, semester " +
                "FROM SEMESTERS " +
                "WHERE username = :username", resultSetMapping = "StudySemester")
@SqlResultSetMapping(name = "StudySemester",
        classes = @ConstructorResult(
                targetClass = Semester.class,
                columns = {
                        @ColumnResult(name = "ID", type = Long.class),
                        @ColumnResult(name = "SEMESTER", type = Integer.class)
                }
        ))
public class Semester {
    private Long id;
    private Integer semester;

    public Semester() {
    }

    public Semester(Long id, Integer semester) {
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
        return "Semester{" +
                "id=" + id +
                ", semester=" + semester +
                '}';
    }
}
