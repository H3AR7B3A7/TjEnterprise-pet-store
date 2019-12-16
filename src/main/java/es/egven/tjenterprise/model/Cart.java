package es.egven.tjenterprise.model;

import java.math.BigDecimal;
import java.util.HashMap;

public class Cart {

    private HashMap<String, BigDecimal> cartContent;
    private BigDecimal totalPrice;

    public Cart(HashMap<String, BigDecimal> cartContent, BigDecimal totalPrice) {
        this.cartContent = new HashMap<>();
        this.totalPrice = totalPrice;
    }

    /**
     * ADD item to cart
     */
    public void addItemToCart(String s, BigDecimal b){
        cartContent.put(s, b);
        BigDecimal currentTotal = new BigDecimal(String.valueOf(totalPrice));
        BigDecimal toBeAdded = new BigDecimal(String.valueOf(b));
        totalPrice = new BigDecimal(String.valueOf(currentTotal.add(toBeAdded)));
    }

    /**
     * REMOVE item from cart
     */
    public void removeItemFromCart(String s, BigDecimal b){
        cartContent.remove(s, b);
        BigDecimal currentTotal = new BigDecimal(String.valueOf(totalPrice));
        BigDecimal toBeSubtracted = new BigDecimal(String.valueOf(b));
        totalPrice = new BigDecimal(String.valueOf(currentTotal.subtract(toBeSubtracted)));
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

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }



    @Override
    public static String toString() {
        return "Cart{" +
                "cartContent=" + cartContent +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
