package com.teste.ilegra.ilegra.service.file;

import com.teste.ilegra.ilegra.BaseTest;
import com.teste.ilegra.ilegra.service.data.DataAnalyser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@AutoConfigureMockMvc
@SpringBootTest
@RunWith(SpringRunner.class)
public class FileProcessorTest extends BaseTest {

    @Mock
    DataAnalyser dataAnalyser;
    @Mock
    FileMove fileMove;
    @Mock
    FileReader fileReader;

    @InjectMocks
    FileProcessor fileProcessor;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void analyzeFileDataShouldBeCalledOneTime() {
        when(fileReader.read(any())).thenReturn(Arrays.asList(""));

        fileProcessor.processFiles(Arrays.asList(""));

        verify(dataAnalyser, times(1)).analyzeFileData(any(), any(), any(), any());
    }

    @Test
    public void moveFileShouldBeCalledOneTime() {
        when(fileReader.read(any())).thenReturn(Arrays.asList(""));

        fileProcessor.processFiles(Arrays.asList(""));

        verify(fileMove, times(1)).moveFile(any());
    }

}
