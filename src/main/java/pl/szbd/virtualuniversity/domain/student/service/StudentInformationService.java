package pl.szbd.virtualuniversity.domain.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Student;
import pl.szbd.virtualuniversity.domain.commons.model.entities.User;
import pl.szbd.virtualuniversity.domain.commons.service.StudentService;
import pl.szbd.virtualuniversity.domain.commons.service.UserService;
import pl.szbd.virtualuniversity.domain.student.model.StudentInformation;
import pl.szbd.virtualuniversity.domain.student.repository.StudentInformationRepository;

import java.util.List;

@Service
public class StudentInformationService {
    @Autowired
    private StudentInformationRepository studentInformationRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;

    public StudentInformation getStudentInformationByUsername(String username) {
        User user = userService.getUserByUsername(username);
        return studentInformationRepository.findOne(user.getPersonId());
    }

    public StudentInformation getStudentInformationByIndex(Long index) {
        Student student = studentService.getStudentByIndex(index);
        return studentInformationRepository.findOne(student.getPersonId());
    }

    public List<StudentInformation> getStudentsInformationByIndexLike(Long index) {
        return studentInformationRepository.findFirstByStudentIndex(index);
    }
}
