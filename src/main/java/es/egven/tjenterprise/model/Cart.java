package es.egven.tjenterprise.model;

import java.math.BigDecimal;
import java.util.HashMap;

public class Cart {

    private HashMap<String,BigDecimal> cartContent;
    private BigDecimal totalPrice;

    public Cart(HashMap<String, BigDecimal> cartContent, BigDecimal totalPrice) {
        this.cartContent = new HashMap<>();
        this.totalPrice = totalPrice;
    }

    /**
     * ADD item to cart
     */
    public void addItemToCart(String s,BigDecimal b){
        cartContent.put(s, b);
        totalPrice.add(b);
    }

    /**
     * REMOVE item from cart
     */
    public void removeItemFromCart(String s, BigDecimal b){
        cartContent.remove(s, b);
        totalPrice.subtract(b);
    }

    /**
     * CLEAR all items from cart
     */
    public void clearCart(){
        cartContent.clear();
        totalPrice = new BigDecimal(0);
    }



    public HashMap<String, BigDecimal> getCartContent() {
        return cartContent;
    }

    public void setCartContent(HashMap<String, BigDecimal> cartContent) {
        this.cartContent = cartContent;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }


    @Override
    public String toString() {
        return "Cart{" +
                "cartContent=" + cartContent +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
