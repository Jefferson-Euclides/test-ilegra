package com.teste.ilegra.ilegra.service.client;

import com.teste.ilegra.ilegra.model.Client;
import com.teste.ilegra.ilegra.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration
@SpringBootTest
@RunWith(SpringRunner.class)
public class ClientServiceTest extends BaseTest {

    @Autowired
    ClientService clientService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getClientsTotalQuantityShouldCountAllList() {
        List<Client> listClients = Arrays.asList(buildClient());

        Long totalQuantity = clientService.getClientsTotalQuantity(listClients);

        assertEquals(totalQuantity.intValue(), listClients.size());
    }
}
