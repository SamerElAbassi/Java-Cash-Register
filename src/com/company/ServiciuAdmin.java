package com.company;

public class ServiciuAdmin {
    Persistenta persistenta = Persistenta.getInstance();

    private static final String SELECT_name_FACULTATE = "SELECT * FROM `facultati` WHERE `name` = ?";
    private static final String SELECT_INDEX_EXAM = "SELECT * FROM `examen` WHERE `index` = ?";
    private static final String SELECT_INDEX_FRECV = "SELECT * FROM `frecventa` WHERE `index` = ?";
    private static final String SELECT_INDEX_DIST = "SELECT * FROM `distanta` WHERE `index` = ?";
    private static final String SELECT_INDEX_FACULTATE = "SELECT * FROM `facultati` WHERE `index` = ?";
    private static final String COUNT_STATEMENT_STUD = "SELECT * FROM `students`";
    private static final String COUNT_STATEMENT_FAC = "SELECT * FROM `facultati`";
    private static final String SELECT_name_FACULTATI = "SELECT * FROM `facultati`";
    private static final String UPDATE_EXAMEN = "UPDATE `examen` SET `luna` = ?, `zi` = ? WHERE `index` = ? AND `materie` = ?";
    private static final String UPDATE_INTERVIU = "UPDATE `distanta` SET `luna` = ?, `zi` = ? WHERE `index` = ?";
    private static final String DELETE_FACULTATE = "DELETE FROM `facultati` WHERE `name` = ?";
    private static final String DELETE_EXAMEN = "DELETE FROM `examen` WHERE `index` = ?";
    private static final String DELETE_FRECVENTA = "DELETE FROM `frecventa` WHERE `index` = ?";
    private static final String DELETE_DISTANTA = "DELETE FROM `distanta` WHERE `index` = ?";
}
