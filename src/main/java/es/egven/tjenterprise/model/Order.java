package es.egven.tjenterprise.model;

import javax.persistence.*;
//https://github.com/ikismail/ShoppingCart/blob/master/src/main/java/com/model/CustomerOrder.java
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
