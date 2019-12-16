package es.egven.tjenterprise.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * ORDER MODEL
 * @author dog.D
 */
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @NotEmpty
    private String orderContent;


    // Constructor
    public Order() {
    }


    // Getters & Setters
    public String getOrderContent(String s) { return orderContent; }

    public void setOrderContent(String orderContent) { this.orderContent = orderContent; }

    public int getOrderId() { return orderId; }

    public void setOrderId(int orderId) { this.orderId = orderId; }
}
