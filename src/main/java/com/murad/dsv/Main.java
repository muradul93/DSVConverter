package com.murad.dsv;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    private static String GIVEN_FILE_PATH;
    private static Pattern GIVEN_DELIMITER_PATTERN;

    public static void main(String[] args) throws IOException {
        getUserInput(args);
        DataProcessor jsonProcessedData = new JSONDataProcessor(
                GIVEN_DELIMITER_PATTERN,
                GIVEN_FILE_PATH);
        IFileWriter JSONFileWriter = new JSONFileWriter(jsonProcessedData,"/output.jsonl");
        JSONFileWriter.writeFile();

    }

    public static void getUserInput(String[] args) {
        if (args.length < 2) {
            System.out.println("Argument Not Provided With Jar.");

            Scanner scn = new Scanner(System.in);

            System.out.println("Please Enter file Path");
            String filePath = scn.nextLine();
            System.out.println("Entered file path : " + filePath);
            GIVEN_FILE_PATH = filePath;

            System.out.println("Please Enter DELIMITER_PATTERN");
            String DELIMITER_PATTERN = scn.nextLine();
            System.out.println("Entered DELIMITER_PATTERN : " + DELIMITER_PATTERN);
            GIVEN_DELIMITER_PATTERN = Pattern.compile(DELIMITER_PATTERN);
        } else {
            GIVEN_FILE_PATH = args[0];
            GIVEN_DELIMITER_PATTERN = Pattern.compile(args[1]);
        }


    }


}
