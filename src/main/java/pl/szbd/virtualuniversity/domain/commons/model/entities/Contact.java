package pl.szbd.virtualuniversity.domain.commons.model.entities;


import pl.szbd.virtualuniversity.domain.commons.model.enums.ConcactType2Enum;
import pl.szbd.virtualuniversity.domain.commons.model.enums.ContactTypeEnum;

import javax.persistence.*;

@Entity(name = "CONTACTS")
public class Contact {
    private Long id;
    private ContactTypeEnum contactType;
    private String value;
    private String personId;
    private ConcactType2Enum type;

    @Id
    @SequenceGenerator(name = "proposalSeq", sequenceName = "Contacts_SEQ")
    @GeneratedValue(generator = "proposalSeq", strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    public ContactTypeEnum getContactType() {
        return contactType;
    }

    public void setContactType(ContactTypeEnum contactType) {
        this.contactType = contactType;
    }

    @Column(name = "CONTACT_TYPE")
    @Enumerated(EnumType.STRING)
    public ConcactType2Enum getType() {
        return type;
    }

    public void setType(ConcactType2Enum type) {
        this.type = type;
    }

    @Column(name = "VALUE")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Column(name = "person_id")
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String person) {
        this.personId = person;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", contactType=" + contactType +
                ", value='" + value + '\'' +
                ", personId='" + personId + '\'' +
                ", type=" + type +
                '}';
    }
}
