package pl.primesystems.clientsystem.customer;

import pl.primesystems.clientsystem.contact.Contact;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @ElementCollection
    @CollectionTable(
            name = "phones",
            joinColumns = @JoinColumn(name = "customer_id", nullable = false))
    private Set<Phone> phoneNumbers = new HashSet<>();

    @Column(name = "email", columnDefinition = "VARCHAR(80)")
    private String email;

    @Column(name = "website", columnDefinition = "VARCHAR(80)")
    private String website;

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

    public Set<Phone> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<Phone> phoneNumbers) {
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
}