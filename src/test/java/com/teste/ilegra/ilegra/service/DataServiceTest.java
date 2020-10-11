package com.teste.ilegra.ilegra.service;

import com.teste.ilegra.ilegra.service.data.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataServiceTest {

    @Autowired
    DataService dataService;

    public void shouldProcessAllFiles() {
        dataService.process();
    }

}
