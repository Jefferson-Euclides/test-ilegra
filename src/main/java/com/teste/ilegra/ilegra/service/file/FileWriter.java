package com.teste.ilegra.ilegra.service.file;

import com.teste.ilegra.ilegra.utils.Constants;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriter {
    private static final String NEW_LINE = System.lineSeparator();

    public static void write(Long quantidadeClientes, Long quantidadeVendedores, Long maiorVenda, String piorVendedor, Path oldFilepath)
            throws IOException {

        String content = "Quantidade total de clientes: " + quantidadeClientes +
                NEW_LINE + "Quantidade total de vendedores: " + quantidadeVendedores +
                NEW_LINE + "Maior venda: " + maiorVenda +
                NEW_LINE + "Pior vendedor: " + piorVendedor;

        Path newFilePath = Paths.get(Constants.DATA_OUT_PATH + oldFilepath.getFileName());

        Files.write(newFilePath, content.getBytes(StandardCharsets.UTF_8));

    }

    public static void writeOutFile(Long quantidadeClientes, Long quantidadeVendedores, Long maiorVenda, String piorVendedor, Path path) {
        try {
            write(quantidadeClientes, quantidadeVendedores, maiorVenda, piorVendedor, path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
