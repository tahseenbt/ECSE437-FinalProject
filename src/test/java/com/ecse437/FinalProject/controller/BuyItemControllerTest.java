package com.ecse437.FinalProject.controller;
import com.ecse437.FinalProject.controller.AvailableInventoryController;
import com.ecse437.FinalProject.driver.Inventory;
import com.ecse437.FinalProject.model.FoodItem;
import com.ecse437.FinalProject.model.InventoryItem;
import com.ecse437.FinalProject.model.Receipt;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockHttpServletRequestDsl;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@AutoConfigureJsonTesters
@WebMvcTest(BuyItemController.class)

public class BuyItemControllerTest {
    @Autowired
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
    public void testBuyItemWhenAvailable() throws Exception
    {
        // the method in that controller should return a list of size 2
        // MockHttpServletResponse resp = mvc.perform(get("/available/Hellman\'s/Mayonnaise")).andReturn().getResponse();
        ResultActions performed = mvc.perform(get("/buy/Hellman\'s/Mayonnaise"));
        MvcResult res = performed.andReturn();
        MockHttpServletResponse resp = res.getResponse();

        assertEquals(HttpStatus.OK.value(), resp.getStatus());

        ObjectMapper mpr = new ObjectMapper();
        Receipt purchase = mpr.readValue(resp.getContentAsByteArray(), Receipt.class);
        assertEquals(String.valueOf(8.50), purchase.getContent()); // 8.50 is the price of mayonnaise
    }

    public void testBuyItemWhenUnavailable() throws Exception
    {
        // testing buying an item that is not in the inventory
        ResultActions performed = mvc.perform(get("/buy/Hellman\'s/Mayonnaise"));
        MvcResult res = performed.andReturn();
        MockHttpServletResponse resp = res.getResponse();

        assertEquals(HttpStatus.OK.value(), resp.getStatus());

        ObjectMapper mpr = new ObjectMapper();
        Receipt purchase = mpr.readValue(resp.getContentAsByteArray(), Receipt.class);
        assertEquals("OUT OF STOCK", purchase.getContent());
    }
}
