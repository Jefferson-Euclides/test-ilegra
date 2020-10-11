package com.teste.ilegra.ilegra.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Sale {

    private Long id;
    private List<Item> listItens;
    private String salesmanName;

}
