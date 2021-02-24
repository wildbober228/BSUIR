package utils;

import input.CustomerInput;
import input.GoodInput;
import input.OrderInput;

public class ControlPage {
    private static boolean useProgram = true;
    private static UserInput userInput;
    private static CustomerInput customerInput;
    private static GoodInput goodInput;
    private static OrderInput orderInput;

    public ControlPage(){
        userInput = new UserInput();
        customerInput = new CustomerInput();
        goodInput = new GoodInput();
        orderInput = new OrderInput();
    }

    private void showTables() {
        boolean useWhile = true;
        System.out.println("1 - Customer ; 2 - Good; 3 - Order");
        int num = userInput.inputInt();
        while (useWhile) {
            switch (num){
                case 1:
                    customerInput.showCustomers();
                    break;

                case 2:
                    goodInput.showGoods();
                    break;

                case 3:
                    orderInput.showOrders();
                    break;

                default:
                    System.out.println("Only 1-7 degrees");
                    break;
            }
            if (num >=1 && num <=7) {
                break;
            }
        }
    }

    private void addInfoToTables(){
        boolean useWhile = true;
        System.out.println("1 - Customer ; 2 - Good ; 3 - Order");
        int num = userInput.inputInt();
        while (useWhile) {
            switch (num){
                case 1:
                    customerInput.addCustomer();
                    break;

                case 2:
                    goodInput.addGood();
                    break;

                case 3:
                    orderInput.addOrder();
                    break;

                default:
                    System.out.println("Only 1-7 degrees");
                    break;
            }
            if (num >=1 && num <=7) {
                break;
            }
        }
    }

    private void deleteInfoFromTables(){
        boolean useWhile = true;
        System.out.println("1 - Customer ; 2 - Good ; 3 - Order");
        int num = userInput.inputInt();
        while (useWhile) {
            switch (num){
                case 1:
                    customerInput.deleteCustomer();
                    break;

                case 2:
                    goodInput.deleteGood();
                    break;

                case 3:
                    orderInput.deleteOrder();
                    break;

                default:
                    System.out.println("Only 1-7 degrees");
                    break;
            }
            if (num >=1 && num <=7) {
                break;
            }
        }
    }

    private void updateInfoFromTables(){
        boolean useWhile = true;
        System.out.println("1 - Customer ; 2 - Good ; 3 - Order");
        int num = userInput.inputInt();
        while (useWhile) {
            switch (num){
                case 1:
                    customerInput.updateCustomer();
                    break;

                case 2:
                    goodInput.updateGood();
                    break;

                case 3:
                    orderInput.updateOrder();
                    break;

                default:
                    System.out.println("Only 1-7 degrees");
                    break;
            }
            if (num >=1 && num <=7) {
                break;
            }
        }
    }

    public void start() {
        try {
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
                        showTables();
                        break;

                    case 2:
                        deleteInfoFromTables();
                        break;

                    case 3:
                        addInfoToTables();
                        break;

                    case 4:
                        updateInfoFromTables();
                        break;

                    case 5:
                        useProgram = false;
                        break;

                    default:
                        System.out.println("Only 1-5 degrees");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }



}
