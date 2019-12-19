package es.egven.tjenterprise.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * CART MODEL
 * @author Egven
 */
public class Cart {

    // Fields - ps: Made these protected and list final
    protected static final List<Product> cartContent = new ArrayList<>();
    protected static BigDecimal totalPrice = BigDecimal.valueOf(0);


    // Constructor
    public Cart() {
        // Not empty
    }


    /**
     * ADD item to cart
     */
    public static void addItemToCart(Product product){
        totalPrice = totalPrice.add(product.getPrijs());
        cartContent.add(product);
//        totalPrice = totalPrice.add(product.getPrijs());
    }

    /**
     * REMOVE item from cart
     */
    public static void removeItemFromCart(Product product) {
        cartContent.remove(product);
        totalPrice = totalPrice.subtract(product.getPrijs());
//        totalPrice = totalPrice.subtract(product.getPrijs());
    }

    /**
     * CLEAR all items from cart
     */
    public static void clearCart(){
        cartContent.clear();
//        totalPrice = new BigDecimal(0);
    }

    // TODO : Optional - Make methods to write/load cartContent to local file (in absence of user DB)
    //  and find price for each product again to add to totalPrice. ^^

    // Only getters
    public List<Product> getCartContent() {
        return cartContent;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }


    /**
     * ToString Method to make Order
     * @return Order/cartContent in Json
     */
    @Override
    public String toString() {
        return "Cart{" +
                "cartContent=" + cartContent +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
