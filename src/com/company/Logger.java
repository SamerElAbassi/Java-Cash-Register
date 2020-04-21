package com.company;


import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    void Update(int Choice) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String strDate =Choice+","+ dateFormat.format(date);
        System.out.println(dateFormat.format(date));
        String filePath = "src/com/baza_date/audit.csv";
        File file=new File(filePath);
        FileWriter filew= new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(filew);
        writer.write(strDate);
        writer.flush();
        writer.newLine();
        writer.close();

    }
}
