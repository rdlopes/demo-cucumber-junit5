package org.rdlopes.demo.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.http.MediaType.valueOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RestSteps {

    @Autowired
    protected MockMvc mvc;

    private ResultActions performedActions;

    @When("I send a message {string}")
    public void iSendAMessage(String message) throws Exception {
        performedActions = mvc.perform(get("/echo")
                                               .queryParam("message", message))
                              .andDo(print());
    }

    @Then("API replies {string}")
    public void apiReplies(String expectedReply) throws Exception {
        performedActions.andExpect(status().isOk())
                        .andExpect(content().contentType(valueOf("text/plain;charset=UTF-8")))
                        .andExpect(content().string(expectedReply));
    }
}
