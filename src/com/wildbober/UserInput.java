package com.wildbober;

import java.util.Scanner;

public class UserInput {
        Scanner in;
    UserInput(){
        in = new Scanner(System.in);
    }

    public int inputInt(){
        int result = in.nextInt();
        return  result;
    }

    public String inputString(){
        String result = in.next();
        return  result;
    }

    public Float inputFloat(){
        Float result = in.nextFloat();
        return  result;
    }
}
