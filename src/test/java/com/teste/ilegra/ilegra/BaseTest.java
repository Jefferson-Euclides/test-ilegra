package com.teste.ilegra.ilegra;

import com.teste.ilegra.ilegra.model.Client;
import com.teste.ilegra.ilegra.model.Item;
import com.teste.ilegra.ilegra.model.Sale;
import com.teste.ilegra.ilegra.model.Salesman;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

public class BaseTest {

    public Salesman buildSalesman() {
        return Salesman.builder()
                .cpf(generateRandomLong())
                .name(generateRandomString(10))
                .salary(Double.valueOf(100)).build();
    }

    public Client buildClient() {
        return Client.builder()
                .cnpj(generateRandomLong())
                .name(generateRandomString(10))
                .businessArea(generateRandomString(10)).build();
    }

    public Sale buildSale(List<Item> listItems) {
        return Sale.builder()
                .id(generateRandomLong())
                .salesmanName(generateRandomString(10))
                .listItens(listItems).build();
    }

    public Item buildItem(Double price, Integer quantity) {
        return Item.builder().id(generateRandomLong()).price(price).quantity(quantity).build();
    }

    public static String generateRandomString(int length) {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        return generatedString;
    }

    public static Long generateRandomLong() {
        Long generatedLong = new Random().nextLong();

        return generatedLong;
    }

}
