package es.egven.tjenterprise.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * ORDER MODEL
 * @author dog.D
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @NotEmpty
    private static String orderContent;

    @NotBlank(message = "Mag niet leeg zijn")
    private String deliveryAddress;

    // Constructor
    public Order() {
    }


    // Getters & Setters

    public static String getOrderContent() { return orderContent; }

    public String getDeliveryAddress() { return deliveryAddress; }

    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }

    public void setOrderContent(String orderContent) { this.orderContent = orderContent; }

    public int getOrderId() { return orderId; }

    public void setOrderId(int orderId) { this.orderId = orderId; }
}
