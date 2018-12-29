package pl.szbd.virtualuniversity.domain.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.virtualuniversity.domain.commons.model.TableData;
import pl.szbd.virtualuniversity.domain.commons.model.entities.User;
import pl.szbd.virtualuniversity.domain.commons.service.UserService;
import pl.szbd.virtualuniversity.domain.commons.utils.DateFormatter;
import pl.szbd.virtualuniversity.domain.student.repository.StudentQuestionnaireRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentQuestionnaireService {
    @Autowired
    private StudentQuestionnaireRepository studentQuestionnaireRepository;
    @Autowired
    private UserService userService;

    public List<TableData> getStudentQuestionnaires(String username, String filter) {
        User user = userService.getUserByUsername(username);
        return studentQuestionnaireRepository.getStudentQuestionnaires(user.getPersonId())
                .stream().map(element -> new TableData(
                        element.getId(),
                        element.getName(),
                        DateFormatter.getFormatter().format(element.getStart_date()),
                        DateFormatter.getFormatter().format(element.getEnd_date()),
                        element.getAvailable()))
                .filter(element -> filter.equals("ALL") || element.getColumn4().equals(filter))
                .collect(Collectors.toList());
    }
}
