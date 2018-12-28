package pl.szbd.virtualuniversity.domain.student.model;

import pl.szbd.virtualuniversity.domain.commons.model.enums.SexType;
import pl.szbd.virtualuniversity.domain.commons.model.enums.StudentStatusEnum;
import pl.szbd.virtualuniversity.domain.commons.model.enums.StudyTypeEnum;

import java.util.Date;

public class StudentInformation {
    private String name;
    private String secondName;
    private String surname;
    private String pesel;
    private String birthplace;
    private Date birthDate;
    private String fatherName;
    private String motherName;
    private SexType sex;
    private String email;
    private String phone;
    private String address;
    private String contactAddress;
    private String temporaryAddress;
    private long studentIndex;
    private long semester;
    private String faculty;
    private String studyField;
    private String studyMode;
    private StudyTypeEnum type;
    private StudentStatusEnum status;
    private long ectsPoints;
    private Date startDate;
    private Date endDate;
}
