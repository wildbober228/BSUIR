package com.wildbober;
import java.sql.*;
import java.util.Scanner;

public class Main {
    private static DataBase db;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        db = new DataBase();

        while (true) {
            System.out.println("1 - show tables " + "\n" +
                    "2 - delete rows from tables" + "\n" +
                    "3 - insert data to table" + "\n" +
                    "4 - update data in a table");
            Scanner in = new Scanner(System.in);

            int num = in.nextInt();
            String nameTable = "";
            int id = 0;
            switch (num) {
                case 1:
                    db.ShowNameTables();
                    System.out.println("Print name Table to look all rows of this table");
                    nameTable = in.next();
                    db.ShowTables(nameTable);
                    break;
                case 2:
                    db.ShowNameTables();
                    System.out.println("Print name Table");
                    nameTable = in.next();
                    System.out.println("Print id of deletable row");
                    id = in.nextInt();
                    db.DeleteInfoFromTable(nameTable, id);
                    break;
                case 3:
                    System.out.println("Print name Table");
                    nameTable = in.next();
                    db.AddDataToTable(nameTable);
                    break;
                case 4:
                    System.out.println("Print name Table");
                    nameTable = in.next();
                    System.out.println("Print id of updatable row");
                    id = in.nextInt();
                    db.UpdateDataInTable(nameTable,id);
                    break;
            }
        }
    }
}
