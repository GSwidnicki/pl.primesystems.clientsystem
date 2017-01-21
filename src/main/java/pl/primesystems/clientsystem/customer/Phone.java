package pl.primesystems.clientsystem.customer;

import javax.persistence.*;

@Entity
@Table(name = "phones")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone_number", nullable = false, columnDefinition = "CHAR(10)")
    private String phoneNumber;

    @Column(name = "number_desc", columnDefinition = "VARCHAR(160)")
    private String phoneNumberDescription;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    /* GETTERS AND SETTERS */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumberDescription() {
        return phoneNumberDescription;
    }

    public void setPhoneNumberDescription(String phoneNumberDescription) {
        this.phoneNumberDescription = phoneNumberDescription;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
