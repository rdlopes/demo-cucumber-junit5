package org.rdlopes.demo.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class DocumentationSteps {

    @Autowired
    protected MockMvc mvc;

    private ResultActions performedActions;

    @When("I request the Open API specifications")
    public void iRequestTheOpenAPISpecifications() throws Exception {
        performedActions = mvc.perform(get("/v3/api-docs"))
                              .andDo(print());
    }

    @Then("I receive the specs for the application")
    public void iReceiveTheSpecsForTheApplication() throws Exception {
        performedActions.andExpect(status().isOk())
                        .andExpect(content().contentType(APPLICATION_JSON))
                        .andExpect(jsonPath("$.openapi", is("3.0.1")));
    }
}
