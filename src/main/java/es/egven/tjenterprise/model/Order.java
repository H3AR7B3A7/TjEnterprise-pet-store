package es.egven.tjenterprise.model;

import javax.persistence.*;
import java.math.BigDecimal;

//https://github.com/ikismail/ShoppingCart/blob/master/src/main/java/com/model/CustomerOrder.java
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    private String orderContent;

    public Order() {
    }

    public String getOrderContent(String s) { return orderContent; }

    public void setOrderContent(String orderContent) { this.orderContent = orderContent; }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


}
