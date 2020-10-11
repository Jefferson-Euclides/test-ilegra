package com.teste.ilegra.ilegra.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {

    private long id;
    private Integer quantity;
    private Double price;

}
