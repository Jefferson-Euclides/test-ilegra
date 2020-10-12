package com.teste.ilegra.ilegra.service.data;

import com.teste.ilegra.ilegra.service.file.FileProcessor;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@AutoConfigureMockMvc
@SpringBootTest
public class DataServiceTest {

    @MockBean
    FileProcessor fileProcessor;

    @Autowired
    DataService dataService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void processFilesShouldBeCalledTwoTimes() {
        dataService.process();

        verify(fileProcessor, times(2)).processFiles(any());
    }

}
