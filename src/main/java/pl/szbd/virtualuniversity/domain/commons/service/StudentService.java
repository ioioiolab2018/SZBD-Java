package pl.szbd.virtualuniversity.domain.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.virtualuniversity.domain.commons.model.SemesterData;
import pl.szbd.virtualuniversity.domain.commons.model.TableData;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Student;
import pl.szbd.virtualuniversity.domain.commons.model.entities.StudentSubject;
import pl.szbd.virtualuniversity.domain.commons.repository.StudentRepository;
import pl.szbd.virtualuniversity.domain.student.model.Semester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student getStudentByIndex(Long index){
        return studentRepository.findStudentByIndex(index);
    }

    public void saveStudent(Student student){
        studentRepository.save(student);
    }

}
