package es.egven.tjenterprise.controllers;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.AdditionalMatchers.or;
import static org.mockito.Mockito.isA;
import static org.mockito.Mockito.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import es.egven.tjenterprise.model.Product;
import es.egven.tjenterprise.model.ProductDAO;

import java.util.ArrayList;

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

@ContextConfiguration(classes = {IndexController.class})
@ExtendWith(SpringExtension.class)
public class IndexControllerTest {
    @Autowired
    private IndexController indexController;

    @MockBean
    private ProductDAO productDAO;

    @Test
    public void testShowAllProducts() {
        ArrayList<Product> productList = new ArrayList<Product>();
        when(this.productDAO.findAll()).thenReturn(productList);
        assertSame(productList, this.indexController.showAllProducts());
        assertTrue(((ArrayList<Product>) this.indexController.showAllProducts()).isEmpty());
        verify(this.productDAO).findAll();
    }

    @Test
    public void testShowFilteredProducts() throws Exception {
        when(this.productDAO.findByCategorie(or(isA(String.class), isNull()))).thenReturn(new ArrayList<Product>());
        when(this.productDAO.findAll()).thenReturn(new ArrayList<Product>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/index/{productCategorie}", "value");
        MockMvcBuilders.standaloneSetup(this.indexController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("allProducts"))
                .andExpect(MockMvcResultMatchers.view().name("index"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("index"));
    }

    @Test
    public void testShowFilteredProducts2() throws Exception {
        when(this.productDAO.findByCategorie(or(isA(String.class), isNull()))).thenReturn(new ArrayList<Product>());
        when(this.productDAO.findAll()).thenReturn(new ArrayList<Product>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/index/{productCategorie}", "",
                "uriVars");
        MockMvcBuilders.standaloneSetup(this.indexController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("allProducts"))
                .andExpect(MockMvcResultMatchers.view().name("index"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("index"));
    }

    @Test
    public void testShowIndex() throws Exception {
        when(this.productDAO.findAll()).thenReturn(new ArrayList<Product>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
        MockMvcBuilders.standaloneSetup(this.indexController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("allProducts"))
                .andExpect(MockMvcResultMatchers.view().name("index"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("index"));
    }

    @Test
    public void testShowIndex2() throws Exception {
        when(this.productDAO.findAll()).thenReturn(new ArrayList<Product>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.indexController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("allProducts"))
                .andExpect(MockMvcResultMatchers.view().name("index"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("index"));
    }
}

