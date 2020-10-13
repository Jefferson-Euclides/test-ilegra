package com.teste.ilegra.ilegra.service.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
@Slf4j
public class FileMove {

    @Value("${data.processed}")
    public String dataProcessedPath;

    private void move(String src, String dest ) {
        try {
            Files.move(Paths.get(src), Paths.get(dest), StandardCopyOption.REPLACE_EXISTING);
            log.info("File moved to the Processed folder");
        } catch (IOException e) {
            log.error("Exception while moving file: " + e.getMessage());
        }
    }

    public void moveFile(String path) {
        String fileName = path.substring(path.lastIndexOf("/"));

        move(path, dataProcessedPath + fileName);
    }

}
