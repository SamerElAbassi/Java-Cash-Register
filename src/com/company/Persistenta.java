package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Persistenta {
    private static Persistenta instance = null;

    private Persistenta() {
    }

    public static Persistenta getInstance() {
        if (instance == null)
            instance = new Persistenta();

        return instance;
    }

    private static final String INSERT_STATEMENT_VEGETAL = "INSERT INTO `vegetal` (`idVegetale`, `Name`, `Price/Kg`)" +
            " VALUES (?, ?, ?)";


    public Vegetal saveVegetal(Vegetal vegetal) {
        try (PreparedStatement statement = databaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT_VEGETAL)) {
            statement.setInt(1, vegetal.getId());
            statement.setInt(2, vegetal.getName());
            statement.setString(3, vegetal.getPrice());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Vegetal adaugat cu succes!");
            }
        } catch (SQLException e) {
            System.out.println("Vegetal:" + e.getMessage());
            return new Vegetal();
        }
        return vegetal;
    }
}
