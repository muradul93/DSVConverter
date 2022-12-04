package com.murad.dsv;

import com.murad.util.DateUtil;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class JSONDataProcessor implements DataProcessor {

    private final Pattern FIELD_DELIMITER_PATTERN;
    private final String GIVEN_FILE_PATH;
    private final String GIVEN_DATE_PATTERN="YYYY-MM-dd";

    public JSONDataProcessor(Pattern FIELD_DELIMITER_PATTERN, String GIVEN_FILE_PATH) {
        this.FIELD_DELIMITER_PATTERN = FIELD_DELIMITER_PATTERN;
        this.GIVEN_FILE_PATH = GIVEN_FILE_PATH;
    }

    @Override
    public List<String> getProcessedData() throws FileNotFoundException {
        return readFileUsingStreams();
    }

    private  List<String> readFileUsingStreams() throws FileNotFoundException {
        List<String> jsonObjectsAsString = new ArrayList<>();
        List<String> jsonProperties = new ArrayList<>();
        File file = new File(GIVEN_FILE_PATH);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        try (Stream<String> stream = Files.lines((file.toPath()))) {
            Spliterator<String> sp = stream.spliterator();
            sp.tryAdvance(firstLine -> {
                mapJSONProperties(firstLine,jsonProperties);
            });
            sp.forEachRemaining(line -> process(
                    line,
                    jsonObjectsAsString,
                    jsonProperties));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return jsonObjectsAsString;
    }


    public void mapJSONProperties(String lineContainingHeader, List<String> jsonProperties) {

        FIELD_DELIMITER_PATTERN.splitAsStream(lineContainingHeader)
                .forEachOrdered(jsonProperty -> jsonProperties.add(jsonProperty));
    }

    private void process(String line, List<String> jsonObjectsAsString, List<String> jsonProperties) {
        JSONObject jsonObject = createJsonObject(line,jsonProperties);
        bindJsonObjectToString(jsonObject,jsonObjectsAsString);
    }

    private void bindJsonObjectToString(JSONObject jsonObject, List<String> jsonObjectsAsString) {
        jsonObjectsAsString.add(jsonObject.toString());
    }

    private JSONObject createJsonObject(String line, List<String> jsonProperties) {
        JSONObject jsonObject = new JSONObject();
        String[] propertyValues = FIELD_DELIMITER_PATTERN.split(line);
        for (ListIterator<String> it = jsonProperties.listIterator(); it.hasNext(); ) {
            int index = it.nextIndex();
            jsonObject.put(it.next(), getPropertyValue(propertyValues, index));
        }
        return jsonObject;

    }

    private String getPropertyValue(String[] propertyValues, int index) {
        String propertyValue = null;
        if (index < propertyValues.length) {
            propertyValue = propertyValues[index];
            if (DateUtil.isDateString(propertyValue)) {
                try {
                    propertyValue = getDateAsString(propertyValue);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return propertyValue;

    }

    private String getDateAsString(String propertyValue) throws ParseException {
        String dateFormatPattern = DateUtil.determineDateFormat(propertyValue);
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);
        Date date = dateFormat.parse(propertyValue);
        propertyValue = DateUtil.convertDateToString(date, GIVEN_DATE_PATTERN);
        return propertyValue;
    }


}
