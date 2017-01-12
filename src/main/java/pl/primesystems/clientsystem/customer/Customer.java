package pl.primesystems.clientsystem.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.primesystems.clientsystem.contact.Contact;
import pl.primesystems.clientsystem.phone.Phone;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tax_number", nullable = false, columnDefinition = "BIGINT(10)")
    private Long taxNumber;

    @Column(name = "company_name", nullable = false, columnDefinition = "VARCHAR(300)")
    private String companyName;

    @Column(name = "street", nullable = false, columnDefinition = "VARCHAR(80)")
    private String street;

    @Column(name = "building_number", nullable = false, columnDefinition = "VARCHAR(10)")
    private String buildingNumber;

    @Column(name = "office_number", columnDefinition = "VARCHAR(10)")
    private String officeNumber;

    @OneToMany(mappedBy = "customer")
    private List<Phone> phoneNumbers;

    @Column(name = "email", columnDefinition = "VARCHAR(80)")
    private String email;

    @Column(name = "website", columnDefinition = "VARCHAR(80)")
    private String website;

    @OneToMany(mappedBy = "customer")
    private List<Contact> contacts;

    /* CONSTRUCTORS */

    public Customer() {
    }

    /* GETTERS AND SETTERS */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(Long taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    public List<Phone> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<Phone> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}