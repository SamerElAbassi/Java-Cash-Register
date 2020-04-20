package com.company;


import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Citire {
    public ColumnPositionMappingStrategy cuvant = new ColumnPositionMappingStrategy();

    void Reader(String fileName) {

        Map<String, String> mapping = new
                HashMap<String, String>();
        mapping.put("Nume", "Nume");
        mapping.put("Pret", "Pret");

        HeaderColumnNameTranslateMappingStrategy<Produs> strategy = new HeaderColumnNameTranslateMappingStrategy<>();
        strategy.setType(Produs.class);
        strategy.setColumnMapping(mapping);

        // Create castobaen and csvreader object
        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader
                    (fileName));
        }
        catch (FileNotFoundException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        CsvToBean csvToBean = new CsvToBean();
        csvToBean.setMappingStrategy(strategy);
        csvToBean.setCsvReader(csvReader);

        List<Produs> list = csvToBean.parse();

        // print details of Bean object
        for (Produs e : list) {
            e.Show();
        }
    }



}
