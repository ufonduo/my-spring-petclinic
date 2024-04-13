package org.springframework.samples.petclinic.system;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Test class for {@link CrashController}
 *
 * @author Colin But
 */
@Disabled
@WebMvcTest(controllers = CrashController.class)
class CrashControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void triggerException() throws Exception {
        mockMvc.perform(get("/oups")).andExpect(view().name("exception"))
                .andExpect(model().attributeExists("exception"))
                .andExpect(forwardedUrl("exception")).andExpect(status().isOk());
    }
}
