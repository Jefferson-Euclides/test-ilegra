package com.teste.ilegra.ilegra.service.file;

import com.teste.ilegra.ilegra.model.Client;
import com.teste.ilegra.ilegra.model.Sale;
import com.teste.ilegra.ilegra.model.Salesman;
import com.teste.ilegra.ilegra.service.data.DataAnalyser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FileProcessor {

    @Autowired
    FileMove fileMove;

    @Autowired
    DataAnalyser dataAnalyser;

    @Autowired
    FileReader fileReader;

    public void processFiles(List<String> listPaths) {
        listPaths.forEach(path -> {
            List<Client> listClients = new ArrayList<>();
            List<Salesman> listSalesman = new ArrayList<>();
            List<Sale> listSales = new ArrayList<>();

            List<Object> listObjects = fileReader.read(path);

            listObjects.forEach(object -> {
                if (object.getClass() == Client.class) {
                    Client client = (Client) object;

                    listClients.add(client);
                } else if (object.getClass() == Salesman.class) {
                    Salesman salesman = (Salesman) object;

                    listSalesman.add(salesman);
                } else if (object.getClass() == Sale.class) {
                    Sale sale = (Sale) object;

                    listSales.add(sale);
                }
            });

            dataAnalyser.analyzeFileData(listClients, listSalesman, listSales, path);
            fileMove.moveFile(path);
        });
    }

}
