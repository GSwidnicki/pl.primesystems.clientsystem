package pl.primesystems.clientsystem.contact;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonValueInstantiator;
import pl.primesystems.clientsystem.customer.Customer;
import pl.primesystems.clientsystem.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "contact_date", nullable = false, columnDefinition = "DATE")
    private Date contactDate;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @OneToOne
    @JoinColumn(name = "assigned_user_id", nullable = false)
    private User assignedUser;

    @Column(name = "next_contact_date", nullable = false, columnDefinition = "DATE")
    private Date nextContactDate;

    @Column(name = "task_to_do", nullable = false, columnDefinition = "TEXT")
    private String taskToDo;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    /* CONSTRUCTORS */

    public Contact() {
    }

    public Contact(Customer customer) {
        this.customer = customer;
        customer.getContacts().add(this);
    }

    public Contact(User user, Date contactDate, String description, User assignedUser, Date nextContactDate, String taskToDo, Customer customer) {
        this.user = user;
        this.contactDate = contactDate;
        this.description = description;
        this.assignedUser = assignedUser;
        this.nextContactDate = nextContactDate;
        this.taskToDo = taskToDo;
        this.customer = customer;
    }

    /* GETTERS AND SETTERS */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getContactDate() {
        return contactDate;
    }

    public void setContactDate(Date contactDate) {
        this.contactDate = contactDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    public Date getNextContactDate() {
        return nextContactDate;
    }

    public void setNextContactDate(Date nextContactDate) {
        this.nextContactDate = nextContactDate;
    }

    public String getTaskToDo() {
        return taskToDo;
    }

    public void setTaskToDo(String taskToDo) {
        this.taskToDo = taskToDo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
