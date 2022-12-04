package com.murad.dsv;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class JSONFileWriterTest {

    @Test
    void whenTestingForEqualityOf_writeFile_ShouldBeEqual() throws IOException {
        String jsonProperty1="{\"firstName\":\"Wolfgang\",\"lastName\":\"Mozart\",\"gender\":\"Male\",\"middleName\":\"Amadeus\",\"dateOfBirth\":\"1756-01-27\",\"salary\":\"1000\"}";
        String jsonProperty2="{\"firstName\":\"Albert\",\"lastName\":\"Einstein\",\"gender\":\"Male\",\"middleName\":\"\",\"dateOfBirth\":\"1955-04-18\",\"salary\":\"2000\"}";
        String jsonProperty3="{\"firstName\":\"Marie, Salomea\",\"lastName\":\"Curie\",\"gender\":\"Female\",\"middleName\":\"\\\"Skłodowska |\\\"\",\"dateOfBirth\":\"1934-07-04\",\"salary\":\"3000\"}";


        String SOURCE_FILE_PATH = "src/test/java/data/DSV input 1.txt";
        String GIVEN_DELIMITER_PATTERN = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
        String OUTPUT_FILE_NAME = "/output_2.jsonl";
        String userHome = System.getProperty("user.home");
        String ACTUAL_FILE_PATH = userHome + OUTPUT_FILE_NAME;
        DataProcessor dataProcessor=new JSONDataProcessor(Pattern.compile(GIVEN_DELIMITER_PATTERN),SOURCE_FILE_PATH);
        IFileWriter fileWriter=new JSONFileWriter(dataProcessor,"/output.jsonl");
        fileWriter.writeFile();

            List<String> actualWrittenData = new ArrayList<>();
            File actualFile = new File(ACTUAL_FILE_PATH);
            if (!actualFile.exists()) {
                throw new FileNotFoundException();
            }
            try (Stream<String> stream = Files.lines((actualFile.toPath()))) {
                stream.forEachOrdered(line->actualWrittenData.add(line));
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        List<String> expectedProcessedData= Arrays.asList(
                jsonProperty1,
                jsonProperty2,
                jsonProperty3);

        assertEquals(expectedProcessedData, actualWrittenData,"File Data doesn't match");

    }



}