package pl.szbd.virtual.university.domain.commons.model.entities;


import pl.szbd.virtual.university.domain.commons.model.enums.ConcactType2Enum;
import pl.szbd.virtual.university.domain.commons.model.enums.ContactTypeEnum;

import javax.persistence.*;

@Entity(name = "CONTACTS")
public class Contact {
    private Long id;
    private ContactTypeEnum contactType;
    private String Value;
    private Person person;
    private ConcactType2Enum type;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    @Enumerated(EnumType.STRING)
    public ContactTypeEnum getContactType() {
        return contactType;
    }

    @Column
    @Enumerated(EnumType.STRING)
    public void setContactType(ContactTypeEnum contactType) {
        this.contactType = contactType;
    }

    public ConcactType2Enum getType() {
        return type;
    }

    public void setType(ConcactType2Enum type) {
        this.type = type;
    }

    @Column(name = "VALUE")
    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", contactType='" + contactType.toString() + '\'' +
                ", Value='" + Value + '\'' +
                ", person=" + person +
                '}';
    }
}
