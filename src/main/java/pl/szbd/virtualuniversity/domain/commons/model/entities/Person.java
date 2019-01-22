package pl.szbd.virtualuniversity.domain.commons.model.entities;

import pl.szbd.virtualuniversity.domain.commons.model.enums.RoleType;
import pl.szbd.virtualuniversity.domain.commons.model.enums.SexType;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "PERSONS")
public class Person {
    private String pesel;
    private String name;
    private String secondName;
    private String surname;
    private Date birthDate;
    private String birthPlace;
    private String fatherName;
    private String motherName;
    private SexType sex;
    private RoleType role;


    @Id
    @Column(name = "PESEL")
    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "NAME2")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "SURNAME")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "BIRTH_DATE")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "BIRTHPLACE")
    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    @Basic
    @Column(name = "FATHER_NAME")
    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    @Basic
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

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE")
    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person that = (Person) o;

        return (Objects.equals(name, that.name)) &&
                (Objects.equals(secondName, that.secondName)) &&
                (Objects.equals(surname, that.surname)) &&
                (Objects.equals(birthDate, that.birthDate)) &&
                (Objects.equals(birthPlace, that.birthPlace)) &&
                (Objects.equals(fatherName, that.fatherName)) &&
                (Objects.equals(motherName, that.motherName)) &&
                (Objects.equals(sex, that.sex)) &&
                (Objects.equals(pesel, that.pesel));
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (birthPlace != null ? birthPlace.hashCode() : 0);
        result = 31 * result + (fatherName != null ? fatherName.hashCode() : 0);
        result = 31 * result + (motherName != null ? motherName.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (pesel != null ? pesel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{ " +
                "name: '" + name + '\'' +
                ", secondName: '" + secondName + '\'' +
                ", surname: '" + surname + '\'' +
                ", birthDate: " + birthDate +
                ", birthPlace: '" + birthPlace + '\'' +
                ", fatherName: '" + fatherName + '\'' +
                ", motherName: '" + motherName + '\'' +
                ", sex: '" + sex + '\'' +
                ", pesel: '" + pesel + '\'' +
                " }";
    }
}
