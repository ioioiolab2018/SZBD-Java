package pl.szbd.virtualuniversity.domain.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.virtualuniversity.domain.commons.model.Item;
import pl.szbd.virtualuniversity.domain.commons.model.entities.StudySubject;
import pl.szbd.virtualuniversity.domain.commons.repository.StudySubjectRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudySubjectService {
    @Autowired
    private StudySubjectRepository studySubjectRepository;

    public List<Item> findSubjectsForSemester(Long id){
    List<StudySubject> subjects = studySubjectRepository.findAllByGroupId(id);
        System.out.println(subjects);
    List<Item> result = subjects.stream().map(element -> new Item(
            element.getId(),
            element.getName())).collect(Collectors.toList());
    return result;
    }

}
