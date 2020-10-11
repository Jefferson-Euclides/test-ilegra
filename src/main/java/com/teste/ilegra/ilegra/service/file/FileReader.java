package com.teste.ilegra.ilegra.service.file;

import com.teste.ilegra.ilegra.exception.ObjectBuilderException;
import com.teste.ilegra.ilegra.model.Client;
import com.teste.ilegra.ilegra.model.Item;
import com.teste.ilegra.ilegra.model.Sale;
import com.teste.ilegra.ilegra.model.Salesman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileReader {

    public static List<Object> read(String path) {

        List<Object> listObjects = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(path))) {

            stream.forEach(line -> {
                String[] lineObject = line.split("ç");

                Object object = objectBuilder(lineObject);
                listObjects.add(object);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listObjects;
    }

    private static Object objectBuilder(String[] item) {
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
                List<Item> listItens = splitItens(item[2]);

                return Sale.builder()
                        .id(Long.valueOf(item[1]))
                        .listItens(listItens)
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

        List<Item> listItensDefinitivo = new ArrayList<>();

        for (String item : listItens) {
            String[]x = item.split("-");

            Item itemDefinitivo = Item.builder()
                    .id(Long.valueOf(x[0]))
                    .quantity(Integer.valueOf(x[1]))
                    .price(Double.valueOf(x[2])).build();

            listItensDefinitivo.add(itemDefinitivo);
        }

        return listItensDefinitivo;

    }

}
