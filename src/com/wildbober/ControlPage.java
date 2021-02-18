package com.wildbober;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class ControlPage {
    private static DataBase db;
    private static boolean useProgram = true;
    private static UserInput userInput;
    ControlPage() throws SQLException, ClassNotFoundException {
        db = new DataBase();
        userInput = new UserInput();
    }

    public void start() {
            while (useProgram) {
                System.out.println(
                        "1 - show tables " + "\n" +
                        "2 - delete rows from tables" + "\n" +
                        "3 - insert data to table" + "\n" +
                        "4 - update data in a table" + "\n" +
                        "5 - exit program"
                );
                int num = userInput.inputInt();
                String nameTable = "";
                int id = 0;
                switch (num) {
                    case 1:
                        db.showNameTables();
                        System.out.println("Print name Table to look all rows of this table");
                        nameTable = userInput.inputString();
                        db.showTables(nameTable);
                        break;

                    case 2:
                        db.showNameTables();
                        System.out.println("Print name Table");
                        nameTable = userInput.inputString();
                        System.out.println("Print id of deletable row");
                        id = userInput.inputInt();
                        db.deleteInfoFromTable(nameTable, id);
                        break;

                    case 3:
                        System.out.println("Print name Table");
                        nameTable = userInput.inputString();
                        db.addDataToTable(nameTable);
                        break;

                    case 4:
                        System.out.println("Print name Table");
                        nameTable = userInput.inputString();
                        System.out.println("Print id of updatable row");
                        id = userInput.inputInt();
                        db.updateDataInTable(nameTable, id);
                        break;

                    case 5:
                        useProgram = false;
                        break;

                    default:
                        System.out.println("Only 1-5 degrees");
                        break;
                }
            }
        }

    }

