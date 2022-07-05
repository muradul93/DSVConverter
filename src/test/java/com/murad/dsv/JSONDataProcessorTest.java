package com.murad.dsv;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class JSONDataProcessorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void whenTestingForEqualityOf_getProcessedData_ShouldBeEqual() throws FileNotFoundException {
        String jsonProperty1="{\"firstName\":\"Wolfgang\",\"lastName\":\"Mozart\",\"gender\":\"Male\",\"middleName\":\"Amadeus\",\"dateOfBirth\":\"1756-01-27\",\"salary\":\"1000\"}";
        String jsonProperty2="{\"firstName\":\"Albert\",\"lastName\":\"Einstein\",\"gender\":\"Male\",\"middleName\":\"\",\"dateOfBirth\":\"1955-04-18\",\"salary\":\"2000\"}";
        String jsonProperty3="{\"firstName\":\"\\\"Marie, Salomea\\\"\",\"lastName\":\"Curie\",\"gender\":\"Female\",\"middleName\":\"Skłodowska |\",\"dateOfBirth\":\"1934-07-04\",\"salary\":\"3000\"}";
        List<String> expectedProcessedData= Arrays.asList(
                jsonProperty1,
                jsonProperty2,
                jsonProperty3);

        String SOURCE_FILE_PATH = "src/test/java/data/DSV input 1.txt";
        String GIVEN_DELIMITER_PATTERN = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

        DataProcessor dataProcessor=new JSONDataProcessor(Pattern.compile(GIVEN_DELIMITER_PATTERN),SOURCE_FILE_PATH);
        List<String> actualProcessedData = dataProcessor.getProcessedData();
        assertEquals(expectedProcessedData, actualProcessedData);

    }

    @Test
    void mapJSONProperties() {
    }
}