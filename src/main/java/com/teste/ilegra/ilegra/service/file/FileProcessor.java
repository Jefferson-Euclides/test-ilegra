package com.teste.ilegra.ilegra.service.file;

import com.teste.ilegra.ilegra.model.Client;
import com.teste.ilegra.ilegra.model.Sale;
import com.teste.ilegra.ilegra.model.Salesman;
import com.teste.ilegra.ilegra.service.data.DataAnalyser;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {

    public static void processFiles(List<Path> result) {
        result.forEach(path -> {
            List<Client> listClients = new ArrayList<>();
            List<Salesman> listSalesman = new ArrayList<>();
            List<Sale> listSales = new ArrayList<>();

            List<Object> listObjects = FileReader.read(path.toString());

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

            DataAnalyser.analyzeFileData(listClients, listSalesman, listSales, path);
            FileMove.moveFile(path);
        });
    }

}
