package pl.szbd.virtualuniversity.domain.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Student;
import pl.szbd.virtualuniversity.domain.commons.repository.StudentRepository;

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

    public Student getStudentByPersonId(String id){
        return studentRepository.getFirstByPersonId(id);
    }

}
