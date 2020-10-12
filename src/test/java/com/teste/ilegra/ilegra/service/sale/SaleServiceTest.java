package com.teste.ilegra.ilegra.service.sale;

import com.teste.ilegra.ilegra.BaseTest;
import com.teste.ilegra.ilegra.model.Item;
import com.teste.ilegra.ilegra.model.Sale;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SaleServiceTest extends BaseTest {

    @Autowired
    SaleService saleService;

    @Test
    public void getBiggestSaleId() {
        Item firstItem = buildItem(Double.valueOf(200), 1);
        Item secondItem = buildItem(Double.valueOf(300), 1);
        List<Item> firstListItems = Arrays.asList(
                firstItem,
                secondItem);

        Sale firstSale = buildSale(firstListItems);

        Item thirdItem = buildItem(Double.valueOf(100), 1);
        Item fourthItem = buildItem(Double.valueOf(100), 1);
        List<Item> secondListItems = Arrays.asList(
                thirdItem,
                fourthItem);

        Sale secondSale = buildSale(secondListItems);

        Long biggestSaleId = saleService.getBiggestSaleId(Arrays.asList(firstSale, secondSale));

        assertEquals(biggestSaleId, firstSale.getId());
    }

}
