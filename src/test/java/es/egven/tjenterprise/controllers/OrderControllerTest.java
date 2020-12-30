package es.egven.tjenterprise.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalMatchers.or;
import static org.mockito.Mockito.isA;
import static org.mockito.Mockito.isNull;
import static org.mockito.Mockito.when;

import es.egven.tjenterprise.model.Order;
import es.egven.tjenterprise.model.OrderDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {OrderController.class})
@ExtendWith(SpringExtension.class)
public class OrderControllerTest {
    @Autowired
    private OrderController orderController;

    @MockBean
    private OrderDAO orderDAO;

    @Test
    public void testCreateNewCart() {
        assertEquals("0", this.orderController.createNewCart().getTotalPrice().toString());
    }

    @Test
    public void testOrderToSave() {
        // TODO: This test is incomplete.

        this.orderController.OrderToSave();
    }

    @Test
    public void testSaveOrder() throws Exception {
        Order order = new Order();
        order.setStreetName("Street Name");
        order.setCustomerName("Customer Name");
        order.setStreetNumber("Street Number");
        order.setMailAddress("42 Main St");
        order.setOrderId(123);
        when(this.orderDAO.save(or(isA(Order.class), isNull()))).thenReturn(order);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/cart");
        MockMvcBuilders.standaloneSetup(this.orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(2))
                .andExpect(MockMvcResultMatchers.model().attributeExists("nCart", "nOrder"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/cart/checkout"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/cart/checkout"));
    }
}

