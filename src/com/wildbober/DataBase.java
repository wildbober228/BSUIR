package com.wildbober;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.util.Calendar;
import java.sql.*;
import java.util.Scanner;

public class DataBase {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/shop_bd1";
    private static final String USER = "root";
    private static final String PASS = "1234";

    private Connection connection;
    private Statement statement;

    DataBase() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        statement = connection.createStatement();
    }

    public void ShowTables(String name) throws SQLException {
        String sql = "SELECT * FROM "+ name;

        System.out.println("Displaying retrieved data:");
        ResultSet resultSet = statement.executeQuery(sql);
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int column_count = rsmd.getColumnCount();

        while (resultSet.next()) {
            System.out.println("\n===================\n");
            for (int i =1; i <= column_count ; i ++){
                System.out.println(resultSet.getString(i));
            }
            System.out.print("\n===================\n");
        }
    }

    private String GenerateQuery(String nameTable, int id,ResultSetMetaData rsmd, int column_count) throws SQLException {
        String query = " UPDATE "+nameTable+" SET ";
        for (int i =1; i <= column_count; i ++){
            if(i !=1)
                query +=", ";
            query+=rsmd.getColumnName(i) +" = ? ";

        }

        query+= " WHERE id = "+id+";";
        return  query;
    }

    private String GenerateQuery(String nameTable,ResultSetMetaData rsmd, int column_count) throws SQLException {
        String query = " insert into "+nameTable+" (";
        for (int i =1; i <= column_count; i ++){
            if(i !=1)
                query +=",";
            query+=rsmd.getColumnName(i);

        }
        query+= ") values (";
        for (int i =1; i <= column_count; i ++){
            if(i !=1) {
                query += ",";

            }
            query += "?";
        }
        query+= ");";
        return  query;
    }

    public void UpdateDataInTable(String nameTable, int rowId) throws SQLException {
        String sql = "SELECT * FROM " + nameTable;
        ResultSet resultSet = statement.executeQuery(sql);
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int column_count = rsmd.getColumnCount();

        String query = GenerateQuery(nameTable,rowId, rsmd, column_count);
        System.out.println("Generated Query = "+ query);
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setInt (1, rowId);
        for (int i =2; i <= column_count; i++){
            System.out.println("Update data for " +rsmd.getColumnName(i) +" with type "+ rsmd.getColumnTypeName(i)) ;
            Scanner in = new Scanner(System.in);
            if(rsmd.getColumnTypeName(i) == "INT"){
                preparedStmt.setInt (i, in.nextInt());
            }
            if(rsmd.getColumnTypeName(i)=="VARCHAR"){
                preparedStmt.setString (i, in.next());
            }
            if(rsmd.getColumnTypeName(i)=="FLOAT"){
                preparedStmt.setFloat (i, in.nextFloat());
            }

            if(rsmd.getColumnTypeName(i) == "DATE"){
                Calendar calendar = Calendar.getInstance();
                java.sql.Date Date = new java.sql.Date(calendar.getTime().getTime());
                preparedStmt.setDate (i, Date);
            }

        }
        preparedStmt.execute();

    }

    public void AddDataToTable(String nameTable) throws SQLException {
        String sql = "SELECT * FROM " + nameTable;
        ResultSet resultSet = statement.executeQuery(sql);
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int column_count = rsmd.getColumnCount();

        String query = GenerateQuery(nameTable, rsmd, column_count);
        System.out.println("Generated Query = "+ query);
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setInt (1, 0);
        for (int i =2; i <= column_count; i++){
            System.out.println("Enter data for " +rsmd.getColumnName(i) +" with type "+ rsmd.getColumnTypeName(i));


            Scanner in = new Scanner(System.in);
            if(rsmd.getColumnTypeName(i) == "INT"){
                preparedStmt.setInt (i, in.nextInt());
            }
            if(rsmd.getColumnTypeName(i)=="VARCHAR"){
                preparedStmt.setString (i, in.next());
            }
            if(rsmd.getColumnTypeName(i)=="FLOAT"){
                preparedStmt.setFloat (i, in.nextFloat());
            }

            if(rsmd.getColumnTypeName(i) == "DATE"){
                Calendar calendar = Calendar.getInstance();
                java.sql.Date Date = new java.sql.Date(calendar.getTime().getTime());
                preparedStmt.setDate (i, Date);
            }

        }
        preparedStmt.execute();
    }

    public void ShowNameTables() throws SQLException {
        ResultSet rs = statement.executeQuery("Show tables");
        System.out.println("Tables in the current database: ");
        while(rs.next()) {
            System.out.print(rs.getString(1));
            System.out.println();
        }
    }

    public void DeleteInfoFromTable(String tableName, int Id) throws SQLException {
        System.out.println("Delete info ");
        PreparedStatement st = connection.prepareStatement("DELETE FROM "+tableName+" WHERE id = ?");
        st.setInt(1,Id);
        st.executeUpdate();
    }
}
