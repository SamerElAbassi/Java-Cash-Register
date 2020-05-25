package com.company;

public interface CsvSerializable {

    String[] getColumnNames();
    String[] toStringArray();
    void fromStringArray(String[] data);
}