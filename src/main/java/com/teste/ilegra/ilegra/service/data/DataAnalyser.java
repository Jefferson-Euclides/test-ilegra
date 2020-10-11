package com.teste.ilegra.ilegra.service.data;

import com.teste.ilegra.ilegra.model.Client;
import com.teste.ilegra.ilegra.model.Item;
import com.teste.ilegra.ilegra.model.Sale;
import com.teste.ilegra.ilegra.model.Salesman;
import com.teste.ilegra.ilegra.service.file.FileWriter;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataAnalyser {

    public static void analyzeFileData(List<Client> listClients, List<Salesman> listSalesman, List<Sale> listSales, Path path) {
        Long clientsTotalQuantity = getClientsTotalQuantity(listClients);

        Long salesmanTotalQuantity = getSalesmanTotalQuantity(listSalesman);

        Long biggestSale = getBiggestSale(listSales);

        String worstSalesman = getWorstSalesman(listSales);

        FileWriter.writeOutFile(clientsTotalQuantity, salesmanTotalQuantity, biggestSale, worstSalesman, path);
    }

    private static Long getBiggestSale(List<Sale> listSales) {
        Map<Long, Item> mapMaioresPrecos = new HashMap<>();

        listSales.forEach(sale -> {
            Item item = sale.getListItens().stream()
                    .max(Comparator.comparing(Item::getPrice))
                    .get();

            mapMaioresPrecos.put(sale.getId(), item);
        });

        Map.Entry<Long, Item> entry = mapMaioresPrecos.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue(Comparator.comparing(Item::getPrice)))
                .get();

        return entry.getKey();
    }

    private static String getWorstSalesman(List<Sale> listSales) {
        Map<String, Double> mapSalesmans = new HashMap<>();

        listSales.forEach(sale -> {
            Double totalSalePrices = sale.getListItens().stream()
                    .mapToDouble(item -> item.getPrice())
                    .sum();

            if (mapSalesmans.containsKey(sale.getSalesmanName())) {
                mapSalesmans.put(sale.getSalesmanName(), mapSalesmans.get(sale.getSalesmanName()) + totalSalePrices);
            } else {
                mapSalesmans.put(sale.getSalesmanName(), totalSalePrices);
            }
        });

        Map.Entry<String, Double> entry = mapSalesmans.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .get();

        return entry.getKey();
    }

    private static Long getClientsTotalQuantity(List<Client> listClients) {
        return listClients.stream().count();
    }

    private static Long getSalesmanTotalQuantity(List<Salesman> listSalesman) {
        return listSalesman.stream().count();
    }

}
