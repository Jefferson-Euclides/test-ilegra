package com.teste.ilegra.ilegra.service.data;

import com.teste.ilegra.ilegra.service.file.FileProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@Slf4j
public class DataService {

    @Autowired
    FileProcessor fileProcessor;

    @Value("${data.in}")
    public String dataInPath;

    @Scheduled(fixedDelay = 30000)
    public void process() {
        try (Stream<Path> walk = Files.walk(Paths.get(dataInPath))) {

            List<String> result = walk.filter(Files::isRegularFile)
                    .map(e -> e.toString())
                    .collect(Collectors.toList());

            fileProcessor.processFiles(result);

        } catch (IOException e) {
            log.error("Error while processing files, maybe the format is wrong");
            e.printStackTrace();
        }
    }

}