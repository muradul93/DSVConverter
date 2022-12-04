package com.murad.dsv;


import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    public void whenFilesIdenticalFor_DSV_input_1_thenReturnTrue() throws IOException {
        String SOURCE_FILE_PATH = "src/test/java/data/DSV input 1.txt";
        String GIVEN_DELIMITER_PATTERN = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
        String EXPECTED_FILE_PATH = "src/test/java/data/expected_1.jsonl";
        String OUTPUT_FILE_NAME = "/output_1.jsonl";
        String userHome = System.getProperty("user.home");
        String ACTUAL_FILE_PATH = userHome + OUTPUT_FILE_NAME;

        DataProcessor jsonProcessedData = new JSONDataProcessor(
                Pattern.compile(GIVEN_DELIMITER_PATTERN),
                SOURCE_FILE_PATH);
        IFileWriter JSONFileWriter = new JSONFileWriter(jsonProcessedData,OUTPUT_FILE_NAME);
        JSONFileWriter.writeFile();

        File actualFile = new File(ACTUAL_FILE_PATH);
        File expectedFile = new File(EXPECTED_FILE_PATH);
        assertTrue(FileUtils.contentEquals(expectedFile,actualFile), "The files differ!");

    }

    @Test
    public void whenFilesIdenticalFor_DSV_input_2_thenReturnTrue() throws IOException {
        String SOURCE_FILE_PATH = "src/test/java/data/DSV input 2.txt";
        String GIVEN_DELIMITER_PATTERN = "\\|(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
        String EXPECTED_FILE_PATH = "src/test/java/data/expected_2.jsonl";
        String OUTPUT_FILE_NAME = "/output_2.jsonl";
        String userHome = System.getProperty("user.home");
        String ACTUAL_FILE_PATH = userHome + OUTPUT_FILE_NAME;
        DataProcessor jsonProcessedData = new JSONDataProcessor(
                Pattern.compile(GIVEN_DELIMITER_PATTERN),
                SOURCE_FILE_PATH);
        IFileWriter JSONFileWriter = new JSONFileWriter(jsonProcessedData,OUTPUT_FILE_NAME);
        JSONFileWriter.writeFile();

        File actualFile = new File(ACTUAL_FILE_PATH);
        File expectedFile = new File(EXPECTED_FILE_PATH);
        assertTrue(FileUtils.contentEquals(expectedFile,actualFile), "The files differ!");

    }



}