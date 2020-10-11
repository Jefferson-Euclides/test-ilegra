package com.teste.ilegra.ilegra.service.data;

import com.teste.ilegra.ilegra.service.file.FileProcessor;
import com.teste.ilegra.ilegra.utils.Constants;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DataService {

    @Scheduled(fixedDelay = 30000)
    public void process() {
        try (Stream<Path> walk = Files.walk(Paths.get(Constants.DATA_IN_PATH))) {

            List<Path> result = walk.filter(Files::isRegularFile)
                    .collect(Collectors.toList());

            FileProcessor.processFiles(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}