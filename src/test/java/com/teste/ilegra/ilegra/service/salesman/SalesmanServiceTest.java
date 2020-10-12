package com.teste.ilegra.ilegra.service.salesman;

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

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SalesmanServiceTest extends BaseTest {

    @Autowired
    SalesmanService salesmanService;

    @Test
    public void getWorstSalesmanName() {
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

        String worstSalesmanNAme = salesmanService.getWorstSalesman(Arrays.asList(firstSale, secondSale));

        assertEquals(secondSale.getSalesmanName(), worstSalesmanNAme);
    }

    @Test
    public void getSalesmanTotalQuantity() {
        Long salesmanQuantity = salesmanService.getSalesmanTotalQuantity(Arrays.asList(buildSalesman()));

        assertEquals(salesmanQuantity, 1);
    }

}
