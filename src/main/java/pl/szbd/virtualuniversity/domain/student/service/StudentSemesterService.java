package pl.szbd.virtualuniversity.domain.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.virtualuniversity.domain.commons.model.TableData;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Student;
import pl.szbd.virtualuniversity.domain.commons.model.entities.User;
import pl.szbd.virtualuniversity.domain.commons.repository.StudentRepository;
import pl.szbd.virtualuniversity.domain.commons.repository.UserRepository;
import pl.szbd.virtualuniversity.domain.commons.utils.DateFormatter;
import pl.szbd.virtualuniversity.domain.student.model.StudentGrade;
import pl.szbd.virtualuniversity.domain.student.model.StudentSemester;
import pl.szbd.virtualuniversity.domain.student.repository.StudentGradeRepository;
import pl.szbd.virtualuniversity.domain.student.repository.StudentSemesterRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentSemesterService {
    @Autowired
    private StudentSemesterRepository studentSemesterRepository;
    @Autowired
    private StudentGradeRepository studentGradeRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UserRepository userRepository;

    public List<TableData> getStudentSemesters(String username) {
        return studentSemesterRepository.getSemesters(username).stream().sorted(Comparator.comparingInt(StudentSemester::getSemester))
                .map(element -> new TableData(element.getId(), element.getSemester().toString(),
                        element.getSemesterPassDate() != null ?
                                DateFormatter.getFormatter().format(element.getSemesterPassDate()) : null,
                        element.getAverage() != null ? element.getAverage().toString() : null))
                .collect(Collectors.toList());
    }

    public List<StudentSemester> getStudentSemesterList(Long index){
        Student student= studentRepository.getOne(index);
        User user= userRepository.getOne(student.getPersonId());
        return  studentSemesterRepository.getSemesters(user.getUsername());
    }


    public List<StudentGrade> getStudentGrades(String username, Long groupId) {
        return studentGradeRepository.getGrades(username, groupId);
    }
}
