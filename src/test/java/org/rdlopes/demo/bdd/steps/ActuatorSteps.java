package org.rdlopes.demo.bdd.steps;

import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ActuatorSteps {

    @Autowired
    protected MockMvc mvc;

    @Given("application is up")
    public void applicationIsUp() throws Exception {
        mvc.perform(get("/actuator/health"))
           .andDo(print())
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.status", is("UP")));
    }
}
