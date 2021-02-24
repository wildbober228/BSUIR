package input;

import models.Customer;
import models.Discount;
import models.Good;
import models.Order;
import services.CustomerService;
import services.DiscountService;
import services.GoodService;
import services.OrderService;
import utils.UserInput;

import java.util.Date;

public class OrderInput {
    static UserInput userInput;
    static GoodService goodService;
    static Good good;
    static Customer customer;
    static CustomerService customerService;
    static Order order;
    static OrderService orderService;

    public OrderInput(){
        userInput = new UserInput();
        customer = new Customer();
        customerService = new CustomerService();
        good = new Good();
        goodService = new GoodService();
        order = new Order();
        orderService = new OrderService();

    }

    private static Good addGood(){
        String goodName;
        int goodCount;
        int goodPrice;

        System.out.println("Input name good");
        goodName = userInput.inputString();

        System.out.println("Input count good");
        goodCount = userInput.inputInt();

        System.out.println("Input price good");
        goodPrice = userInput.inputInt();

        good.setName(goodName);
        good.setGoodPrice(goodPrice);
        good.setGoodCount(goodCount);

        goodService.saveGood(good);

        return good;
    }

    public static void showOrders(){
        System.out.println(orderService.findAllOrders().toString());
    }

    public static void deleteOrder(){
        showOrders();
        System.out.println("Input id order to delete");
        int id = userInput.inputInt();
        order = orderService.findOrder(id);
        orderService.deleteOrder(order);
    }

    public static void addOrder(){
        try {
            Date date;

            System.out.println("Input date");
            date = userInput.inputData();

            System.out.println("Create new Good for Order ?");
            System.out.println("1 - YES ; 2 - NO");
            int _case = userInput.inputInt();
            while (true) {
                switch (_case) {

                    case 1:
                        good = addGood();
                        break;

                    case 2:
                        System.out.println(goodService.findAllGoods().toString());
                        System.out.println("input id of Good");
                        int id = userInput.inputInt();
                        good = goodService.findGood(id);
                        break;

                    default:
                        System.out.println("You need type 1 or 2");
                        break;
                }
                if (_case == 1 || _case == 2) {
                    break;
                }
            }

            System.out.println(customerService.findAllCustomers().toString());
            System.out.println("input id of Custmer");
            int id = userInput.inputInt();
            customer = customerService.findCustomer(id);

            order.setCreatedAt(date);
            order.setGood(good);
            order.setGoodId(good.getId());
            order.setCustomer(customer);
            order.setCustomerId(customer.getId());
            orderService.saveOrder(order);
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public static void updateOrder(){
        try {
            showOrders();
            System.out.println("Input id order to update");
            int id = userInput.inputInt();
            order = orderService.findOrder(id);

            Date date;

            System.out.println("Input date");
            date = userInput.inputData();

            System.out.println("Create new Good for Order ?");
            System.out.println("1 - YES ; 2 - NO");
            int _case = userInput.inputInt();
            while (true) {
                switch (_case) {

                    case 1:
                        good = addGood();
                        break;

                    case 2:
                        System.out.println(goodService.findAllGoods().toString());
                        System.out.println("input id of Good");
                        id = userInput.inputInt();
                        good = goodService.findGood(id);
                        break;

                    default:
                        System.out.println("You need type 1 or 2");
                        break;
                }
                if (_case == 1 || _case == 2) {
                    break;
                }
            }

            System.out.println(customerService.findAllCustomers().toString());
            System.out.println("input id of Custmer");
            id = userInput.inputInt();
            customer = customerService.findCustomer(id);

            order.setCreatedAt(date);
            order.setGood(good);
            order.setGoodId(good.getId());
            order.setCustomer(customer);
            order.setCustomerId(customer.getId());
            orderService.updateOrder(order);
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }


}
