package com.murad.dsv;
import java.io.FileNotFoundException;
import java.util.List;


public interface DataProcessor {
    List<String> getProcessedData() throws FileNotFoundException;
}
