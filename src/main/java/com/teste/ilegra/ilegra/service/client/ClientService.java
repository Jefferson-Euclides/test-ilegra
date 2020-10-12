package com.teste.ilegra.ilegra.service.client;

import com.teste.ilegra.ilegra.model.Client;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientService {

    public Long getClientsTotalQuantity(List<Client> listClients) {
        return listClients.stream().count();
    }

}
