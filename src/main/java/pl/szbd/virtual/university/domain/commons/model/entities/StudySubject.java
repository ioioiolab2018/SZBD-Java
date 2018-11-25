package pl.szbd.virtual.university.domain.commons.model.entities;


import javax.persistence.*;

@Entity(name = "STUDY_SUBJECTS")
public class StudySubject {
    private Long id;
    private String name;
    private Integer ectsValue;
    private Integer semester;
    private String description;
    private Lecturer lecturer;
    private StudentGroup studentGroup;



    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "GroupSemesterId")
    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "ECTS_VALUE")
    public Integer getEctsValue() {
        return ectsValue;
    }

    public void setEctsValue(Integer ectsValue) {
        this.ectsValue = ectsValue;
    }

    @Column(name = "SEMESTER")
    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    @Column(name = "DESCRIPTION")
    @Lob
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "lecturer_id")
    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    @Override
    public String toString() {
        return "StudySubject{" +
                "name='" + name + '\'' +
                ", ectsValue=" + ectsValue +
                ", semester=" + semester +
                ", description='" + description + '\'' +
                ", lecturer=" + lecturer +
                '}';
    }
}

