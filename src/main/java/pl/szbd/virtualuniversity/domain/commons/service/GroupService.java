package pl.szbd.virtualuniversity.domain.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Contact;
import pl.szbd.virtualuniversity.domain.commons.model.entities.Student;
import pl.szbd.virtualuniversity.domain.commons.model.entities.StudentGroup;
import pl.szbd.virtualuniversity.domain.commons.repository.ContactRepository;
import pl.szbd.virtualuniversity.domain.commons.repository.StudentGroupRepository;

import java.security.acl.Group;
import java.util.List;

@Service
public class GroupService {
    @Autowired
    private StudentGroupRepository groupRepository;

    public void  saveStudentGroup(StudentGroup group){
        groupRepository.save(group);
    }
}
