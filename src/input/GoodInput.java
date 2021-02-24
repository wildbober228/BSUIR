package input;

import models.Good;
import services.GoodService;

import utils.UserInput;

public class GoodInput {
    static UserInput userInput;
    static GoodService goodService;
    static Good good;

    public GoodInput(){
        userInput = new UserInput();
        goodService = new GoodService();
        good = new Good();
    }

    public static void showGoods(){
        System.out.println(goodService.findAllGoods().toString());
    }

    public static void deleteGood(){
        showGoods();
        System.out.println("Input id good to delete");
        int id = userInput.inputInt();
        good = goodService.findGood(id);
        goodService.deleteGood(good);
    }

    public static void addGood(){
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
    }

    public static void updateGood(){
        String goodName;
        int goodCount;
        int goodPrice;

        showGoods();
        System.out.println("Input id good to update");
        int id = userInput.inputInt();
        good = goodService.findGood(id);

        System.out.println("Input name good");
        goodName = userInput.inputString();

        System.out.println("Input count good");
        goodCount = userInput.inputInt();

        System.out.println("Input price good");
        goodPrice = userInput.inputInt();

        good.setName(goodName);
        good.setGoodPrice(goodPrice);
        good.setGoodCount(goodCount);

        goodService.updateGood(good);
    }

}
