package com.wildbober;

import java.io.IOException;
import java.util.Calendar;
import java.sql.*;
import java.util.Scanner;

public class DataBase {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/shop_bd1";
    private static final String USER = "root";
    private static final String PASS = "1234";

    private Connection connection;
    private Statement statement;
    private static UserInput userInput;

    DataBase() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        statement = connection.createStatement();
        userInput = new UserInput();
    }

    public void showTables(String name) {
        try {
            String sql = "SELECT * FROM " + name;
            System.out.println("Displaying retrieved data:");
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int column_count = rsmd.getColumnCount();
            while (resultSet.next()) {
                System.out.println("\n===================\n");
                for (int i = 1; i <= column_count; i++) {
                    System.out.println(resultSet.getString(i));
                }
                System.out.print("\n===================\n");
            }
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    private String generateQuery(String nameTable, int id, ResultSetMetaData rsmd, int column_count) throws SQLException {
        String query = "";
        try {
            query = "UPDATE " + nameTable + " SET ";
            for (int i = 1; i <= column_count; i++) {
                if (i != 1)
                    query += ", ";
                query += rsmd.getColumnName(i) + " = ? ";

            }
            query += " WHERE id = " + id + ";";
        } catch (SQLException exception) {
            System.out.println(exception);
        }
        return query;
    }

    private String generateQuery(String nameTable, ResultSetMetaData rsmd, int column_count){
        String query ="";
        try {
            query = "insert into " + nameTable + " (";
            for (int i = 1; i <= column_count; i++) {
                if (i != 1)
                    query += ",";
                query += rsmd.getColumnName(i);

            }
            query += ") values (";
            for (int i = 1; i <= column_count; i++) {
                if (i != 1) {
                    query += ",";

                }
                query += "?";
            }
            query += ");";
        } catch (SQLException exception) {
            System.out.println(exception);
        }
        return query;
    }

    public void updateDataInTable(String nameTable, int rowId){
        try {
            String sql = "SELECT * FROM " + nameTable;
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int column_count = rsmd.getColumnCount();
            String query = generateQuery(nameTable, rowId, rsmd, column_count);
            System.out.println("Generated Query = " + query);
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, rowId);
            for (int i = 2; i <= column_count; i++) {
                System.out.println("Update data for " + rsmd.getColumnName(i) + " with type " + rsmd.getColumnTypeName(i));
                if (rsmd.getColumnTypeName(i) == "INT") {
                    preparedStmt.setInt(i, userInput.inputInt());
                }

                if (rsmd.getColumnTypeName(i) == "VARCHAR") {
                    preparedStmt.setString(i, userInput.inputString());
                }

                if (rsmd.getColumnTypeName(i) == "FLOAT") {
                    preparedStmt.setFloat(i, userInput.inputFloat());
                }

                if (rsmd.getColumnTypeName(i) == "DATE") {
                    Calendar calendar = Calendar.getInstance();
                    java.sql.Date Date = new java.sql.Date(calendar.getTime().getTime());
                    preparedStmt.setDate(i, Date);
                }
            }
            preparedStmt.execute();
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    public void addDataToTable(String nameTable) {
        try {
            String sql = "SELECT * FROM " + nameTable;
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int column_count = rsmd.getColumnCount();
            String query = generateQuery(nameTable, rsmd, column_count);
            System.out.println("Generated Query = " + query);
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, 0);
            for (int i = 2; i <= column_count; i++) {
                System.out.println("Enter data for " + rsmd.getColumnName(i) + " with type " + rsmd.getColumnTypeName(i));
                if (rsmd.getColumnTypeName(i) == "INT") {
                    preparedStmt.setInt(i, userInput.inputInt());
                }

                if (rsmd.getColumnTypeName(i) == "VARCHAR") {
                    preparedStmt.setString(i, userInput.inputString());
                }

                if (rsmd.getColumnTypeName(i) == "FLOAT") {
                    preparedStmt.setFloat(i, userInput.inputFloat());
                }

                if (rsmd.getColumnTypeName(i) == "DATE") {
                    Calendar calendar = Calendar.getInstance();
                    java.sql.Date Date = new java.sql.Date(calendar.getTime().getTime());
                    preparedStmt.setDate(i, Date);
                }

            }
            preparedStmt.execute();
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    public void showNameTables(){
        try {
            ResultSet rs = statement.executeQuery("Show tables");
            System.out.println("Tables in the current database: ");
            while (rs.next()) {
                System.out.print(rs.getString(1));
                System.out.println();
            }
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    public void deleteInfoFromTable(String tableName, int Id) {
        try {
            System.out.println("Delete info ");
            PreparedStatement st = connection.prepareStatement("DELETE FROM " + tableName + " WHERE id = ?");
            st.setInt(1, Id);
            st.executeUpdate();
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }
}
