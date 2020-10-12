package com.teste.ilegra.ilegra.service.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Component
public class FileWriter {

    private static final String NEW_LINE = System.lineSeparator();

    @Value("${data.out}")
    public String dataOutPath;

    private void write(Long totalClients, Long totalSalesman, Long biggestSale, String worstSalesman, String path)
            throws IOException {

        String fileName = path.substring(path.lastIndexOf("/"));

        String content = "Quantidade total de clientes: " + totalClients +
                NEW_LINE + "Quantidade total de vendedores: " + totalSalesman +
                NEW_LINE + "Maior venda: " + biggestSale +
                NEW_LINE + "Pior vendedor: " + worstSalesman;

        Path newFilePath = Paths.get(dataOutPath + fileName);

        log.info("Writing file " + fileName);
        Files.write(newFilePath, content.getBytes(StandardCharsets.UTF_8));

    }

    public void writeOutFile(Long totalClients, Long totalSalesman, Long biggestSale, String worstSalesman, String path) {
        try {
            write(totalClients, totalSalesman, biggestSale, worstSalesman, path);
        } catch (IOException e) {
            log.debug("Error while writing the file");
            e.printStackTrace();
        }
    }

}
