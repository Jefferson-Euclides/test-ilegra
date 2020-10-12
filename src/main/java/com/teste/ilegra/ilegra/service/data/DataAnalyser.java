package com.teste.ilegra.ilegra.service.data;

import com.teste.ilegra.ilegra.model.Client;
import com.teste.ilegra.ilegra.model.Sale;
import com.teste.ilegra.ilegra.model.Salesman;
import com.teste.ilegra.ilegra.service.client.ClientService;
import com.teste.ilegra.ilegra.service.file.FileWriter;
import com.teste.ilegra.ilegra.service.sale.SaleService;
import com.teste.ilegra.ilegra.service.salesman.SalesmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataAnalyser {

    @Autowired
    FileWriter fileWriter;

    @Autowired
    SalesmanService salesmanService;

    @Autowired
    SaleService saleService;

    @Autowired
    ClientService clientService;

    public void analyzeFileData(List<Client> listClients, List<Salesman> listSalesman, List<Sale> listSales, String path) {
        Long clientsTotalQuantity = clientService.getClientsTotalQuantity(listClients);

        Long salesmanTotalQuantity = salesmanService.getSalesmanTotalQuantity(listSalesman);

        Long biggestSale = saleService.getBiggestSaleId(listSales);

        String worstSalesman = salesmanService.getWorstSalesman(listSales);

        fileWriter.writeOutFile(clientsTotalQuantity, salesmanTotalQuantity, biggestSale, worstSalesman, path);
    }

}
