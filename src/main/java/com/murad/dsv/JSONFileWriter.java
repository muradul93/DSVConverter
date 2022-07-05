package com.murad.dsv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONFileWriter implements IFileWriter {
    private DataProcessor dataProcessor;
    private final String OUTPUT_FILE_NAME;

    public JSONFileWriter(DataProcessor dataProcessor, String OUTPUT_FILE_NAME) {
        this.dataProcessor = dataProcessor;
        this.OUTPUT_FILE_NAME = OUTPUT_FILE_NAME;
    }



    @Override
    public void writeFile() throws IOException {
        String userHome = System.getProperty("user.home");
        String OUTPUT_FILE_PATH = userHome + OUTPUT_FILE_NAME;
        Path path = Paths.get(OUTPUT_FILE_PATH);
        BufferedWriter writer =Files.newBufferedWriter(path, StandardCharsets.UTF_8);
        File file = new File(OUTPUT_FILE_PATH);
        cleanExistingFile(file);
        System.out.println("--------- JSON converted data --------");
        dataProcessor.getProcessedData()
                .stream()
                .forEach(data -> {
                    System.out.println(data);
                    writeTofFle(data, writer);
                });
        writer.close();
        System.out.println("JSON File Created . You Can Find JSONl File At Path :" + file.getAbsolutePath());
    }

    public void writeTofFle(String data, BufferedWriter writer) {
        try {
            writer.append(data);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cleanExistingFile(File file) {
        try {
            Files.newBufferedWriter(
                    file.toPath(),
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}