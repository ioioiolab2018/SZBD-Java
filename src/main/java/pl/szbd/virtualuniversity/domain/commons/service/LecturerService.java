package pl.szbd.virtualuniversity.domain.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Lecturer;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Student;
import pl.szbd.virtualuniversity.domain.commons.repository.LecturerRepository;
import pl.szbd.virtualuniversity.domain.commons.repository.StudentRepository;

@Service
public class LecturerService {
    @Autowired
    private LecturerRepository lecturerRepository;

    public void saveLecturer(Lecturer lecturer){
        lecturerRepository.save(lecturer);
    }

}

