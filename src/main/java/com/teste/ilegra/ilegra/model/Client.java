package com.teste.ilegra.ilegra.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Client {

    private Long cnpj;
    private String name;
    private String businessArea;

}
