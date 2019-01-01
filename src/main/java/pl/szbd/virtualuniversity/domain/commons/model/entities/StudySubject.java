package pl.szbd.virtualuniversity.domain.commons.model.entities;


import javax.persistence.*;

@Entity(name = "STUDY_SUBJECTS")
public class StudySubject {
    private Long id;
    private Long groupId;
    private Long lecturerId;
    private String name;
    private Long ectsValue;
    private String description;

    @Id
    @SequenceGenerator(name = "studySubjectSeq", sequenceName = "STUDY_SUBJECTS_SEQ")
    @GeneratedValue(generator = "studySubjectSeq", strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "GROUP_ID")
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Column(name = "LECTURER_ID")
    public Long getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Long lecturerId) {
        this.lecturerId = lecturerId;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "ECTS_VALUE")
    public Long getEctsValue() {
        return ectsValue;
    }

    public void setEctsValue(Long ectsValue) {
        this.ectsValue = ectsValue;
    }

    @Lob
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "StudySubject{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", lecturerId=" + lecturerId +
                ", name='" + name + '\'' +
                ", ectsValue=" + ectsValue +
                ", description='" + description + '\'' +
                '}';
    }
}

