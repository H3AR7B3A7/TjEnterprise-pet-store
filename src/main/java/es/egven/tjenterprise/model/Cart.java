package es.egven.tjenterprise.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
//https://github.com/ikismail/ShoppingCart/blob/master/src/main/java/com/model/Cart.java

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int CartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<CartItem> cartContent;

    private BigDecimal totalPrice;

    public Cart() {
    }

    public int getCartId() {
        return CartId;
    }

    public void setCartId(int cartId) {
        CartId = cartId;
    }

    public List<CartItem> getCartContent() {
        return cartContent;
    }

    public void setCartContent(List<CartItem> cartContent) {
        this.cartContent = cartContent;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
