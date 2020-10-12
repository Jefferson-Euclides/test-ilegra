package com.teste.ilegra.ilegra.service;

import com.teste.ilegra.ilegra.exception.ObjectBuilderException;
import com.teste.ilegra.ilegra.model.Client;
import com.teste.ilegra.ilegra.model.Item;
import com.teste.ilegra.ilegra.model.Sale;
import com.teste.ilegra.ilegra.model.Salesman;

import java.util.ArrayList;
import java.util.List;

public class ObjectBuilder {

    public static Object build(String[] item) {
        try{
            if (item[0].equals("001")) {
                return Salesman.builder()
                        .cpf(Long.valueOf(item[1]))
                        .name(item[2])
                        .salary(Double.parseDouble(item[3])).build();

            } else if (item[0].equals("002")) {
                return Client.builder()
                        .cnpj(Long.valueOf(item[1]))
                        .name(item[2])
                        .businessArea(item[3]).build();

            } else if (item[0].equals("003")){
                List<Item> listItems = splitItens(item[2]);

                return Sale.builder()
                        .id(Long.valueOf(item[1]))
                        .listItens(listItems)
                        .salesmanName(item[3]).build();
            }
        } catch (ObjectBuilderException ex) {
            throw new ObjectBuilderException(ex);
        }

        return null;
    }

    private static List<Item> splitItens(String itens) {
        String[]listItens = itens.replace("[", "")
                .replace("]", "")
                .split(",");

        List<Item> listDefinitiveItems = new ArrayList<>();

        for (String item : listItens) {
            String[]tokens = item.split("-");

            Item definitiveItem = Item.builder()
                    .id(Long.valueOf(tokens[0]))
                    .quantity(Integer.valueOf(tokens[1]))
                    .price(Double.valueOf(tokens[2])).build();

            listDefinitiveItems.add(definitiveItem);
        }

        return listDefinitiveItems;

    }

}
