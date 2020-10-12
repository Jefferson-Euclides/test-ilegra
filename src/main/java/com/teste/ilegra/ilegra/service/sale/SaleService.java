package com.teste.ilegra.ilegra.service.sale;

import com.teste.ilegra.ilegra.model.Item;
import com.teste.ilegra.ilegra.model.Sale;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SaleService {

    public Long getBiggestSaleId(List<Sale> listSales) {
        Map<Long, Item> mapBiggestSales = new HashMap<>();

        listSales.forEach(sale -> {
            Item item = sale.getListItens().stream()
                    .max(Comparator.comparing(Item::getPrice))
                    .get();

            mapBiggestSales.put(sale.getId(), item);
        });

        Map.Entry<Long, Item> entry = mapBiggestSales.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue(Comparator.comparing(Item::getPrice)))
                .get();

        return entry.getKey();
    }

}
