package com.ecse437.FinalProject.controller;
import com.ecse437.FinalProject.controller.AvailableInventoryController;
import com.ecse437.FinalProject.driver.Inventory;
import com.ecse437.FinalProject.model.InventoryItem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockHttpServletRequestDsl;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@AutoConfigureJsonTesters
@WebMvcTest(AvailableInventoryController.class)
public class AvailableInventoryControllerTest
{
    private MockMvc mvc;
    private ResultActions MockHttpServletResponse;

    @BeforeEach
    public void setUpTest()
    {
        // init variables and such
        Inventory inv = Inventory.getInstance();
    }

    @AfterEach
    public void cleanUpTest()
    {
        // reset the inventory
        Inventory.resetInstance();
    }

    @Test
    public void testGetAvailableItems() throws Exception
    {
        // the method in that controller should return a list of size 2
        MockHttpServletResponse resp = mvc.perform(get("/Hellman's/Mayonnaise")).andReturn().getResponse();
        assertEquals(HttpStatus.OK.value(), resp.getStatus());
        // made sure status is 200, now let's make sure the list has two items
        ObjectMapper mpr = new ObjectMapper();
        List<InventoryItem> items = new ObjectMapper().readValue(resp.getContentAsByteArray(), new TypeReference<List<InventoryItem>>() {});
        assertEquals(2, items.size());
    }
}

