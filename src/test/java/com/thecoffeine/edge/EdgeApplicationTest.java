package com.thecoffeine.edge;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for application.
 *
 * @version 1.0
 */
@ActiveProfiles( "tests" )
@RunWith( SpringRunner.class )
@AutoConfigureMockMvc
@SpringBootTest
public class EdgeApplicationTest {

    @Autowired
    protected MockMvc mockMvc;

    @Test
    public void testAvailability() throws Exception {
        this.mockMvc.perform(
            get( "/info" )
                .contentType( MediaType.APPLICATION_JSON_UTF8 )
        )
            .andExpect( status().isUnauthorized() );
    }
}
