package com.example.Request.ControllerTest;


import com.example.Request.controllers.ReimbursementController;
import com.example.Request.models.Reimbursements;
import com.example.Request.services.ReimbursementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReimbursementController.class)
public class ControllerTest {

    @MockBean
    private ReimbursementService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnReimbursement() throws Exception {
        Long id = 1L;
        Reimbursements reimbursements = new Reimbursements();
        reimbursements.setId(id);
        when(service.getById(id)).thenReturn(Optional.of(reimbursements));

        mockMvc.perform(get("/models/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id));
    }
//
////    @Test
////    public void shouldSaveModel() throws Exception {
////        Model m = new Model(1, "test-value2");
////
////        when(modelService.saveNewModel(any())).thenReturn(m);
////        String location = "http://localhost:8080/models/" + m.getId();
////
////        mockMvc.perform(
////                        post("/models")
////                                .contentType("application/json")
////                                .content("{\"value\": \"test-value2\"}"))
////                .andExpect(status().isCreated())
////                .andExpect(header().string("Location", containsString("models/"+m.getId())));
////    }
}