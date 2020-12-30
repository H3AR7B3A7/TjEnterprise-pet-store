package es.egven.tjenterprise.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OrderTest {
    @Test
    public void testSetOrderContent() {
        // TODO: This test is incomplete.

        (new Order()).setOrderContent("Not all who wander are lost");
    }

    @Test
    public void testSetOrderId() {
        Order order = new Order();
        order.setOrderId(123);
        assertEquals(123, order.getOrderId());
    }

    @Test
    public void testSetCustomerName() {
        Order order = new Order();
        order.setCustomerName("Customer Name");
        assertEquals("Customer Name", order.getCustomerName());
    }

    @Test
    public void testSetStreetName() {
        Order order = new Order();
        order.setStreetName("Street Name");
        assertEquals("Street Name", order.getStreetName());
    }

    @Test
    public void testSetStreetNumber() {
        Order order = new Order();
        order.setStreetNumber("Street Number");
        assertEquals("Street Number", order.getStreetNumber());
    }

    @Test
    public void testSetMailAddress() {
        Order order = new Order();
        order.setMailAddress("42 Main St");
        assertEquals("42 Main St", order.getMailAddress());
    }
}

