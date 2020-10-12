package com.teste.ilegra.ilegra.service.data;

import com.teste.ilegra.ilegra.BaseTest;
import com.teste.ilegra.ilegra.service.client.ClientService;
import com.teste.ilegra.ilegra.service.file.FileWriter;
import com.teste.ilegra.ilegra.service.sale.SaleService;
import com.teste.ilegra.ilegra.service.salesman.SalesmanService;
import com.teste.ilegra.ilegra.service.salesman.SalesmanServiceTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

@AutoConfigureMockMvc
@SpringBootTest
@RunWith(SpringRunner.class)
public class DataAnalyserTest extends BaseTest {

    @Mock
    FileWriter fileWriter;

    @Mock
    ClientService clientService;

    @Mock
    SalesmanService salesmanService;

    @Mock
    SaleService saleService;

    @InjectMocks
    DataAnalyser dataAnalyser;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldCallGetClientsTotalQuantityOneTime() {
        when(clientService.getClientsTotalQuantity(anyList())).thenReturn(Long.valueOf(1l));
        when(salesmanService.getSalesmanTotalQuantity(anyList())).thenReturn(Long.valueOf(1l));
        when(saleService.getBiggestSaleId(anyList())).thenReturn(Long.valueOf(1l));
        when(salesmanService.getWorstSalesman(anyList())).thenReturn(String.valueOf('a'));

        dataAnalyser.analyzeFileData(Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), "");

        verify(clientService, times(1)).getClientsTotalQuantity(anyList());
    }

    @Test
    public void shouldCallGetSalesmanTotalQuantityOneTime() {
        when(clientService.getClientsTotalQuantity(anyList())).thenReturn(Long.valueOf(1l));
        when(salesmanService.getSalesmanTotalQuantity(anyList())).thenReturn(Long.valueOf(1l));
        when(saleService.getBiggestSaleId(anyList())).thenReturn(Long.valueOf(1l));
        when(salesmanService.getWorstSalesman(anyList())).thenReturn(String.valueOf('a'));

        dataAnalyser.analyzeFileData(Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), "");

        verify(salesmanService, times(1)).getSalesmanTotalQuantity(anyList());
    }

    @Test
    public void shouldCallGetBiggestSaleOneTime() {
        when(clientService.getClientsTotalQuantity(anyList())).thenReturn(Long.valueOf(1l));
        when(salesmanService.getSalesmanTotalQuantity(anyList())).thenReturn(Long.valueOf(1l));
        when(saleService.getBiggestSaleId(anyList())).thenReturn(Long.valueOf(1l));
        when(salesmanService.getWorstSalesman(anyList())).thenReturn(String.valueOf('a'));

        dataAnalyser.analyzeFileData(Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), "");

        verify(saleService, times(1)).getBiggestSaleId(anyList());
    }

    @Test
    public void shouldCallGetWorstSalesmanOneTime() {
        when(clientService.getClientsTotalQuantity(anyList())).thenReturn(Long.valueOf(1l));
        when(salesmanService.getSalesmanTotalQuantity(anyList())).thenReturn(Long.valueOf(1l));
        when(saleService.getBiggestSaleId(anyList())).thenReturn(Long.valueOf(1l));
        when(salesmanService.getWorstSalesman(anyList())).thenReturn(String.valueOf('a'));

        dataAnalyser.analyzeFileData(Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), "");

        verify(salesmanService, times(1)).getWorstSalesman(anyList());
    }

}
