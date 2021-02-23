package utils;

import input.CustomerInput;

public class ControlPage {
    private static boolean useProgram = true;
    private static UserInput userInput;
    private static CustomerInput customerInput;

    public ControlPage(){
        userInput = new UserInput();
        customerInput = new CustomerInput();
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
                        customerInput.showCustomer();
                        break;

                    case 2:
                        customerInput.deleteCustomer();
                        break;

                    case 3:
                        customerInput.addCustomer();
                        break;

                    case 4:
                        customerInput.updateCustomer();
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
