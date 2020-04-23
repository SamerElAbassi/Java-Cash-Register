package com.company;

public class MyGeneric implements CsvSerializable {
    @Override
    public String[] getColumnNames() {
        return new String[0];
    }

    @Override
    public String[] toStringArray() {
        return new String[0];
    }

    @Override
    public void fromStringArray(String[] data) {

    }

    public static <T> T castObject(Class<T> clazz, Object object) {
        return (T) object;
    }
}
