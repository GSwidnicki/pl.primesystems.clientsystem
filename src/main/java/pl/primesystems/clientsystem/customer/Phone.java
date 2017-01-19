package pl.primesystems.clientsystem.customer;

import javax.persistence.*;

@Embeddable
public class Phone {

    @Column(name = "phone_number", nullable = false, columnDefinition = "CHAR(10)")
    private String phoneNumber;

    @Column(name = "number_desc", columnDefinition = "VARCHAR(160)")
    private String phoneNumberDescription;

    /* CONSTRUCTORS */

    public Phone() {
    }

    /* GETTERS AND SETTERS */

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
}
