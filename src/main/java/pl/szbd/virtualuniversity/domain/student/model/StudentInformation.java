package pl.szbd.virtualuniversity.domain.student.model;

import pl.szbd.virtualuniversity.domain.commons.model.enums.SexType;
import pl.szbd.virtualuniversity.domain.commons.model.enums.StudentStatusEnum;
import pl.szbd.virtualuniversity.domain.commons.model.enums.StudyTypeEnum;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "STUDENT_INFORMATION")
public class StudentInformation {
    private String pesel;
    private String name;
    private String secondName;
    private String surname;
    private String birthPlace;
    private Date birthDate;
    private String fatherName;
    private String motherName;
    private SexType sex;
    private String email;
    private String phone;
    private String address;
    private String contactAddress;
    private String temporaryAddress;
    private Long studentIndex;
    private Long semester;
    private String faculty;
    private String studyField;
    private String studyMode;
    private StudyTypeEnum type;
    private StudentStatusEnum status;
    private Long ectsPoints;
    private Date startDate;
    private Date endDate;

    @Id
    @Column(name = "PESEL")
    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "SECOND_NAME")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Column(name = "SURNAME")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "BIRTHPLACE")
    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    @Column(name = "BIRTH_DATE")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "FATHER_NAME")
    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    @Column(name = "MOTHER_NAME")
    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "SEX")
    public SexType getSex() {
        return sex;
    }

    public void setSex(SexType sex) {
        this.sex = sex;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "CONTACT_ADDRESS")
    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    @Column(name = "TEMPORARY_ADDRESS")
    public String getTemporaryAddress() {
        return temporaryAddress;
    }

    public void setTemporaryAddress(String temporaryAddress) {
        this.temporaryAddress = temporaryAddress;
    }

    @Column(name = "STUDENT_INDEX")
    public Long getStudentIndex() {
        return studentIndex;
    }

    public void setStudentIndex(Long studentIndex) {
        this.studentIndex = studentIndex;
    }

    @Column(name = "SEMESTER")
    public Long getSemester() {
        return semester;
    }

    public void setSemester(Long semester) {
        this.semester = semester;
    }

    @Column(name = "FACULTY")
    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Column(name = "STUDY_FIELD")
    public String getStudyField() {
        return studyField;
    }

    public void setStudyField(String studyField) {
        this.studyField = studyField;
    }

    @Column(name = "STUDY_MODE")
    public String getStudyMode() {
        return studyMode;
    }

    public void setStudyMode(String studyMode) {
        this.studyMode = studyMode;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    public StudyTypeEnum getType() {
        return type;
    }

    public void setType(StudyTypeEnum type) {
        this.type = type;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    public StudentStatusEnum getStatus() {
        return status;
    }

    public void setStatus(StudentStatusEnum status) {
        this.status = status;
    }

    @Column(name = "ECTS_POINTS")
    public Long getEctsPoints() {
        return ectsPoints;
    }

    public void setEctsPoints(Long ectsPoints) {
        this.ectsPoints = ectsPoints;
    }

    @Column(name = "START_DATE")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "END_DATE")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "StudentInformation{" +
                "pesel='" + pesel + '\'' +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", surname='" + surname + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", birthDate=" + birthDate +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                ", temporaryAddress='" + temporaryAddress + '\'' +
                ", studentIndex=" + studentIndex +
                ", semester=" + semester +
                ", faculty='" + faculty + '\'' +
                ", studyField='" + studyField + '\'' +
                ", studyMode='" + studyMode + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", ectsPoints=" + ectsPoints +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
