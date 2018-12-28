package pl.szbd.virtual.university.domain.commons.model.entities;

import pl.szbd.virtual.university.domain.commons.model.enums.AddressTypeEnum;

import javax.persistence.*;

@Entity(name = "ADDRESES")
public class Addres {

    private Long id;
    private Person person;
    private String town;
    private String street;
    private String zipCode;
    private Integer houseNumber;
    private Integer apartmentNumber;
    private AddressTypeEnum addressType;

    @Id
    @Column(name = "ID")
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Basic
    @Column(name = "TOWN")
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Basic
    @Column(name = "STREET")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "ZIP_CODE")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "HOUSE_NUMBER")
    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer hauseNumber) {
        this.houseNumber = hauseNumber;
    }

    @Basic
    @Column(name = "APARTMENT_NUMBER")
    public Integer getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(Integer apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    @Column
    @Enumerated(EnumType.STRING)
    public AddressTypeEnum getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressTypeEnum addressType) {
        this.addressType = addressType;
    }

    @Override
    public String toString() {
        return "Addres{" +
                "id=" + id +
                ", person=" + person +
                ", town='" + town + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", houseNumber=" + houseNumber +
                ", apartmentNumber=" + apartmentNumber +
                '}';
    }
}
