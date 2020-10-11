package com.teste.ilegra.ilegra.service.file;

import com.teste.ilegra.ilegra.utils.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileMove {

    private static void move(String src, String dest ) {
        Path result = null;
        try {
            result = Files.move(Paths.get(src), Paths.get(dest));
        } catch (IOException e) {
            System.out.println("Exception while moving file: " + e.getMessage());
        }
        if(result != null) {
            System.out.println("File moved successfully.");
        }else{
            System.out.println("File movement failed.");
        }
    }

    public static void moveFile(Path file) {
        move(file.toString(), Constants.DATA_PROCESSED_PATH + file.getFileName());
    }

}
