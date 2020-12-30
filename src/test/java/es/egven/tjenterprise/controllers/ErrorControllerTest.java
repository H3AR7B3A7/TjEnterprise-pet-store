package es.egven.tjenterprise.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ErrorController.class})
@ExtendWith(SpringExtension.class)
public class ErrorControllerTest {
    @Autowired
    private ErrorController errorController;

    @Test
    public void testHandleError() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/products/error");
        MockMvcBuilders.standaloneSetup(this.errorController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("404"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("404"));
    }

    @Test
    public void testHandleError2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/products/error", "uriVars");
        MockMvcBuilders.standaloneSetup(this.errorController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("404"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("404"));
    }
}

