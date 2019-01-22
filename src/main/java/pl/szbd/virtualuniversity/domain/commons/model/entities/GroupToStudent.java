package pl.szbd.virtualuniversity.domain.commons.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

@Entity(name = "Grups_To_Students")
public class GroupToStudent {
    private Long grupID;
    private Long studentID;

    @Id
    public Long getGrupID() {
        return grupID;
    }

    public void setGrupID(Long grupID) {
        this.grupID = grupID;
    }

    @Column(name = "STUDENT_ID", unique = true)
    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }
}
