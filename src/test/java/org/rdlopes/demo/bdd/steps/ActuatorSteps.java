package org.rdlopes.demo.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.rdlopes.demo.bdd.tooling.SpringEnabledSteps;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ActuatorSteps extends SpringEnabledSteps {

    @Given("application is up")
    public void applicationIsUp() throws Exception {
        mvc.perform(get("/actuator/health"))
           .andDo(print())
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.status", is("UP")));
    }
}
