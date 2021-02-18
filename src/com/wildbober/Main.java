package com.wildbober;
import java.sql.*;
import java.util.Scanner;

public class Main {
    private static DataBase db;
    private static ControlPage controlPage;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        db = new DataBase();
        controlPage = new ControlPage();
        controlPage.start();
    }
}
