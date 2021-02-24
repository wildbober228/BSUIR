package input;

import models.Customer;
import services.CustomerService;

import models.Discount;
import services.DiscountService;

import utils.UserInput;

import java.io.IOException;

public class CustomerInput {
    static UserInput userInput;
    static DiscountService discountService;
    static Customer customer;
    static Discount discount;
    static CustomerService customerService;

    public CustomerInput(){
        userInput = new UserInput();
        customer = new Customer();
        discountService = new DiscountService();
        customerService = new CustomerService();
    }

    private static Discount addDiscount(int amountDiscount){
         Discount discount = new Discount(amountDiscount);
         discountService.saveDiscount(discount);
         return discount;
    }

    public static void showCustomers(){
        System.out.println(customerService.findAllCustomers().toString());
    }

    public static void deleteCustomer(){
        System.out.println("Input id customer to delete");
        int id = userInput.inputInt();
        customer = customerService.findCustomer(id);
        customerService.deleteCustomer(customer);
    }

    public static void addCustomer(){
        try {
            String name;
            String surName;

            System.out.println("Input name customer");
            name = userInput.inputString();

            System.out.println("Input surName customer");
            surName = userInput.inputString();


            System.out.println("Create new Discount for Customer ?");
            System.out.println("1 - YES ; 2 - NO");
            int _case = userInput.inputInt();
            while (true) {
                switch (_case) {

                    case 1:
                        System.out.println("input amount of Discount");
                        int amountDiscount = userInput.inputInt();
                        discount = addDiscount(amountDiscount);
                        break;

                    case 2:
                        System.out.println(discountService.findAllDiscounts().toString());
                        System.out.println("input id of Discount");
                        int id = userInput.inputInt();
                        discount = discountService.findDiscount(id);
                        break;

                    default:
                        System.out.println("You need type 1 or 2");
                        break;
                }
                if (_case == 1 || _case == 2) {
                    break;
                }
            }

            customer.setsName(name);
            customer.setSurname(surName);
            customer.setDiscount(discount);
            customer.setDiscountId(discount.getId());
            customerService.saveCustomer(customer);
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public static void updateCustomer(){
        try {
            String name;
            String surName;

            showCustomers();

            System.out.println("Input id customer to update");
            int id = userInput.inputInt();
            customer = customerService.findCustomer(id);

            System.out.println("Input name customer");
            name = userInput.inputString();

            System.out.println("Input surName customer");
            surName = userInput.inputString();

            System.out.println("Create new Discount for Customer ?");
            System.out.println("1 - YES ; 2 - NO");
            int _case = userInput.inputInt();
            while (true) {
                switch (_case) {
                    case 1:
                        System.out.println("input amount of Discount");
                        int amountDiscount = userInput.inputInt();
                        discount = addDiscount(amountDiscount);

                        break;

                    case 2:
                        System.out.println(discountService.findAllDiscounts().toString());
                        System.out.println("input id of Discount");
                        id = userInput.inputInt();
                        discount = discountService.findDiscount(id);
                        break;

                    default:
                        System.out.println("You need type 1 or 2");
                        break;
                }
                if (_case == 1 || _case == 2) {
                    break;
                }
            }

            customer.setsName(name);
            customer.setSurname(surName);
            customer.setDiscount(discount);
            customer.setDiscountId(discount.getId());
            customerService.updateCustomer(customer);
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }



}
