package pl.szbd.virtualuniversity.domain.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.virtualuniversity.domain.commons.model.SemesterData;
import pl.szbd.virtualuniversity.domain.commons.model.TableData;
import pl.szbd.virtualuniversity.domain.commons.model.entities.StudentSubject;
import pl.szbd.virtualuniversity.domain.commons.model.entities.StudySubject;
import pl.szbd.virtualuniversity.domain.commons.repository.StudentSubjectRepository;
import pl.szbd.virtualuniversity.domain.commons.repository.StudySubjectRepository;
import pl.szbd.virtualuniversity.domain.student.model.Semester;
import pl.szbd.virtualuniversity.domain.student.repository.SemesterRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentSubjectsService {
    @Autowired
    private StudentSubjectRepository studentSubjectRepository;
    @Autowired
    private SemesterRepository semesterRepository;
    @Autowired
    private StudySubjectRepository studySubjectRepository;

    public ArrayList<SemesterData> getStudentSubjects(String username, String filter) {
        List<Semester> semesters = semesterRepository.getSemesters(username);
        if (semesters.size() > 0) {
            List<Long> semestersIds =
                    semesters.stream().map(Semester::getId).collect(Collectors.toList());
            List<StudentSubject> studentSubjects = studentSubjectRepository.getSubjects(username, semestersIds);
            if (studentSubjects.size() > 0) {
                ArrayList<SemesterData> semesterData = new ArrayList<>();
                Map<Integer, List<StudentSubject>> map = studentSubjects.stream().collect(Collectors.groupingBy(StudentSubject::getSemester));

                for (Map.Entry<Integer, List<StudentSubject>> entry : map.entrySet()) {
                    semesterData.add(new SemesterData(entry.getKey(),
                            entry.getValue().stream()
                                    .map(element -> new TableData(
                                            element.getId(),
                                            element.getName(),
                                            element.getLecturer(),
                                            element.getEctsValue().toString(),
                                            element.getComplete()))
                                    .filter((element -> filter.equals("ALL") || element.getColumn4().equals(filter)))
                                    .collect(Collectors.toList())));
                }
                Collections.sort(semesterData);
                return semesterData;
            }
        }
        return new ArrayList<>();
    }

    public StudySubject getSubject(Long id) {
        return studySubjectRepository.findOne(id);
    }
}
