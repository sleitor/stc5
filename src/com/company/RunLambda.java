package com.company;

import java.util.List;

/**
 * Created by User on 25.04.2017.
 */
public class RunLambda implements Runnable {
    private Interfc interfc;
    private List<Integer> num1;

    public RunLambda(Interfc interfc, List<Integer> num1) {
        this.interfc = interfc;
        this.num1 = num1;
    }

    @Override
    public void run() { start(); }

    private void start() {
        int sum = 0;
        for (int num :num1) {
            sum = interfc.sumFunc(sum, num);
            System.out.printf("%s: число: %4d    сумма: %4d \n", Thread.currentThread().getName(), num, sum );
            Thread.yield();
        }
    }
}
