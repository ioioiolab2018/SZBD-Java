package pl.szbd.virtual.university.domain.commons;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "PERSONS", schema = "WEBUSER")
public class Person {
    private String name;
    private String name2;
    private String surname;
    private Time birthDate;
    private String birthplace;
    private String fatherName;
    private String motherName;
    private String sex;
    private String pesel;

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
    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
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
    public Time getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Time birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "BIRTHPLACE")
    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
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

    @Basic
    @Column(name = "SEX")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Id
    @Column(name = "PESEL")
    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person that = (Person) o;

        return (name != null ? name.equals(that.name) : that.name == null) &&
                (name2 != null ? name2.equals(that.name2) : that.name2 == null) &&
                (surname != null ? surname.equals(that.surname) : that.surname == null) &&
                (birthDate != null ? birthDate.equals(that.birthDate) : that.birthDate == null) &&
                (birthplace != null ? birthplace.equals(that.birthplace) : that.birthplace == null) &&
                (fatherName != null ? fatherName.equals(that.fatherName) : that.fatherName == null) &&
                (motherName != null ? motherName.equals(that.motherName) : that.motherName == null) &&
                (sex != null ? sex.equals(that.sex) : that.sex == null) &&
                (pesel != null ? pesel.equals(that.pesel) : that.pesel == null);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (name2 != null ? name2.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (birthplace != null ? birthplace.hashCode() : 0);
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
                ", name2: '" + name2 + '\'' +
                ", surname: '" + surname + '\'' +
                ", birthDate: " + birthDate +
                ", birthplace: '" + birthplace + '\'' +
                ", fatherName: '" + fatherName + '\'' +
                ", motherName: '" + motherName + '\'' +
                ", sex: '" + sex + '\'' +
                ", pesel: '" + pesel + '\'' +
                " }";
    }
}
