package pl.szbd.virtualuniversity.domain.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import pl.szbd.virtualuniversity.domain.commons.model.TableData;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Person;
import pl.szbd.virtualuniversity.domain.commons.model.entities.StudentGroup;
import pl.szbd.virtualuniversity.domain.commons.model.enums.RoleType;
import pl.szbd.virtualuniversity.domain.commons.repository.PersonRepository;
import pl.szbd.virtualuniversity.domain.commons.repository.StudentGroupRepository;
import pl.szbd.virtualuniversity.domain.commons.service.PersonService;
import pl.szbd.virtualuniversity.domain.commons.service.StudentService;
import pl.szbd.virtualuniversity.domain.commons.utils.DateFormatter;
import pl.szbd.virtualuniversity.domain.employee.model.StudentView;
import pl.szbd.virtualuniversity.domain.student.model.Semester;
import pl.szbd.virtualuniversity.domain.student.model.StudentInformation;
import pl.szbd.virtualuniversity.domain.student.model.StudentSemester;
import pl.szbd.virtualuniversity.domain.student.service.Student;
import pl.szbd.virtualuniversity.domain.student.service.StudentInformationService;
import pl.szbd.virtualuniversity.domain.student.service.StudentSemesterService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeStudentService {
    @Autowired
    private StudentInformationService studentInformationService;
    @Autowired
    private StudentSemesterService studentSemesterService;
    @Autowired
    private StudentGroupRepository studentGroupRepository;
    @Autowired
    private PersonService personService;
    @Autowired
    private StudentService studentService;

    public StudentView findStudentForEmployee(Long index){
        StudentInformation student= studentInformationService.getStudentInformationByIndex(index);
        StudentView result =new StudentView(student.getStudentIndex(), student.getName(), student.getSurname(), student.getSecondName());
        List<StudentSemester> studentSemesters=studentSemesterService.getStudentSemesterList(index);
        for (StudentSemester studentSemester:studentSemesters) {
            result.addSemester(studentSemester.getId(),"Semestr "+studentSemester.getSemester());
        }
        return result;
    }

    public List<TableData> findStudentsForRates(String filter){
        Long index=null;
        try {
            index=Long.parseLong(filter);
        }catch (NumberFormatException e){

        }
        List<StudentInformation> students=new ArrayList<>();
        if(index!=null) {
            students = studentInformationService.getStudentsInformationByIndexLike(index);
        }else {
            List<pl.szbd.virtualuniversity.domain.commons.model.entities.Student> studentList=new ArrayList<>();
            String name="&";
            String surname="&";
            String[] splitted=filter.split(" ");
            if(splitted.length>1){
                surname=splitted[0];
                name=splitted[1];
            }else{
                surname=filter.trim();
            }
            List<Person> personList= personService.getStudentsLike(name, surname, RoleType.STUDENT);
            for (Person person:personList) {
                pl.szbd.virtualuniversity.domain.commons.model.entities.Student student=studentService.getStudentByPersonId(person.getPesel());
                students.add(studentInformationService.getStudentInformationByIndex(student.getIndex()));
            }
        }
        return students.stream().map(element -> new TableData(
                element.getStudentIndex(),
                element.getStudentIndex().toString(),
                element.getName(),
                element.getSurname(),
                element.getSemester().toString()))
                .collect(Collectors.toList());
    }

}
