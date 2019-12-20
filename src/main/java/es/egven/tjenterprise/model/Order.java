package es.egven.tjenterprise.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * ORDER MODEL
 * @author Egven
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @NotEmpty(message ="{blank_error}")
    private static String orderContent;

    @Size(min = 3, max = 50, message = "{name_error}")
    private String customerName;

    @Size(min = 5, max = 50, message = "{street_name_error}")
    private String streetName;

    @Pattern(regexp = "^\\d{1,4}([a-zA-Z]{1,2}\\d{1,3}|[a-zA-Z]{1,2}|)$",message = "{street_number_error}")
    private String streetNumber;

    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",message = "{mail_error}")
    private String mailAddress;


    // Constructor
    public Order() {
        // Not empty
    }


    // Getters & Setters

    public static String getOrderContent() { return orderContent; }

    public void setOrderContent(String orderContent) { this.orderContent = orderContent; }

    public int getOrderId() { return orderId; }

    public void setOrderId(int orderId) { this.orderId = orderId; }


    // For order form

    public String getCustomerName() { return customerName; }

    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getStreetName() { return streetName; }

    public void setStreetName(String streetName) { this.streetName = streetName; }

    public String getStreetNumber() { return streetNumber; }

    public void setStreetNumber(String streetNumber) { this.streetNumber = streetNumber; }

    public String getMailAddress() { return mailAddress; }

    public void setMailAddress(String mailAddress) { this.mailAddress = mailAddress; }
}
