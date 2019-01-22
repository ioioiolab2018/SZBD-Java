package pl.szbd.virtualuniversity.domain.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Address;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Grade;
import pl.szbd.virtualuniversity.domain.commons.repository.AddressRepository;
import pl.szbd.virtualuniversity.domain.commons.repository.GradeRepository;
import pl.szbd.virtualuniversity.domain.commons.repository.StudentRepository;

@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;


    public void saveGrade(Grade grade) {
        Grade oldGrade = gradeRepository.findFirstByStudentIndexAndStudySubjectIdAndType(grade.getStudentIndex(), grade.getStudySubjectId(), grade.getType());
        if(oldGrade!=null){
            grade.setId(oldGrade.getId());
        }
        gradeRepository.save(grade);

    }
}
