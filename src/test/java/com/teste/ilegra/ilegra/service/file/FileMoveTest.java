package com.teste.ilegra.ilegra.service.file;

import com.teste.ilegra.ilegra.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
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
@RunWith(SpringRunner.class)
public class FileMoveTest extends BaseTest {

    @MockBean
    FileMove fileMove;

    @Test
    public void moveFileShouldCallMoveMethod() {
        fileMove.moveFile("/something");

        verify(fileMove, times(1)).moveFile(any());
    }

}
