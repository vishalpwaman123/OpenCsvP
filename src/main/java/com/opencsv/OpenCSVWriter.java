package com.opencsv;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OpenCSVWriter {
    private static final String OBJECT_LIST_SAMPLE = "./src/main/resources/sampleWrite.csv";

    public static void main(String[] args) throws IOException,
            CsvDataTypeMismatchException,
            CsvRequiredFieldEmptyException {
        try (
                Writer writer = Files.newBufferedWriter(Paths.get(OBJECT_LIST_SAMPLE));
                ) {
            StatefulBeanToCsv<CSVUser> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            List<CSVUser> myUsers = new ArrayList<>();
            myUsers.add(new CSVUser("Vishal Waman", "vishal.waman@gmail.com", "1-1111111111", "India"));
            myUsers.add(new CSVUser("Rahul Waman", "rahul.waman@outlook.com","91-39293932828", "England"));
            myUsers.add(new CSVUser("Ravi Vaishanav", "ravi.vaishanav@outlook.com","91-39293932828", "Saddle"));
            myUsers.add(new CSVUser("Abhi Shinde", "abhi.shinde@outlook.com","91-39293932828", "Saddle"));
            myUsers.add(new CSVUser("ga jayesh", "kumar.nadella@outlook.com","91-39293932828", "Saddle"));
            myUsers.add(new CSVUser("Uday Nadella", "satya.nadella@outlook.com","91-61493642686", "japan"));


            beanToCsv.write(myUsers);
            writer.append((CharSequence) myUsers);
        }
    }
}
