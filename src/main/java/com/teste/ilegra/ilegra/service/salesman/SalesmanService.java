package com.teste.ilegra.ilegra.service.salesman;

import com.teste.ilegra.ilegra.model.Sale;
import com.teste.ilegra.ilegra.model.Salesman;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SalesmanService {

    public String getWorstSalesman(List<Sale> listSales) {
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

    public Long getSalesmanTotalQuantity(List<Salesman> listSalesman) {
        return listSalesman.stream().count();
    }

}
