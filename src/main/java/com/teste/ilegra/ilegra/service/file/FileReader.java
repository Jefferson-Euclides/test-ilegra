package com.teste.ilegra.ilegra.service.file;

import com.teste.ilegra.ilegra.service.ObjectBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
@Slf4j
public class FileReader {

    public List<Object> read(String path) {

        List<Object> listObjects = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(path))) {

            stream.forEach(line -> {
                String[] lineObject = line.split("ç");

                Object object = ObjectBuilder.build(lineObject);
                listObjects.add(object);
            });
        } catch (IOException e) {
            log.debug("Error while reading the file");
            e.printStackTrace();
        }

        return listObjects;
    }

}
