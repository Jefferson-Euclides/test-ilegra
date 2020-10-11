package com.teste.ilegra.ilegra.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Salesman {

    private Long cpf;
    private String name;
    private Double salary;

}
