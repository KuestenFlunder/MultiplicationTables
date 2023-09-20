package com.tjelvargames.mathlogic;

import java.util.Random;

public class MultiplicationTablesTask {
    public static int counter = 0;
    public static int level = 1;

    private int nextLevelThreshold = 5;
    private int taskVolumeThreshold = 3;

    private Random random = new Random();
    private int factor1, factor2, result;

    public MultiplicationTablesTask() {
    }

    public MultiplicationTablesTask(int factor1, int factor2, int result) {
        this.factor1 = factor1;
        this.factor2 = factor2;
        this.result = result;
    }


    public int getFactor1() {
        return factor1;
    }

    public int getFactor2() {
        return factor2;
    }

    public int getResult() {
        return result;
    }

    //! Wenn die Verteilung am level haengt, werden die unteren Zahlen zu oft gefragt
/*
    public MultiplicationTablesTask newTask() {
        factor1 = random.nextInt(1, level + 1);
        factor2 = random.nextInt(1, 10+1);
        result = factor1 * factor2;

        return new MultiplicationTablesTask(factor1, factor2, result);

    }*/

    //* now the threshold can be set and grows with the students knowleg. maybe to be set by the client in an options menu
    public MultiplicationTablesTask newTask() {
        factor1 = random.nextInt(1, taskVolumeThreshold + 1);
        factor2 = random.nextInt(2, 10 + 1);
        result = factor1 * factor2;

        return new MultiplicationTablesTask(factor1, factor2, result);
    }

    public void printInfo() {
        System.out.format("factor1 : %d\n factor 2: %d \n result: %d \n \n", factor1, factor2, result);
    }

    public String getInfo() {
        String info = String.format(" %d x %d = %d", factor1, factor2, result);
        return info;
    }

    public String returnCounterAsString() {
        return String.format("Punktestand : %d", counter);
    }

    public String returnLevelAsString() {
        return String.format("Level: %d", level);
    }

    public String returnTaskAsString() {
        return String.format("%d x %d = ", factor1, factor2);
    }

    public void updateCounterAndLevel(int enteredResult) {
        
        if (enteredResult == result) {
            counter++;
            if (counter == nextLevelThreshold) {
                counter = 0;
                level++;
            }
        } else {
            if (counter > 0) {
                counter--;
            }
            if (counter == 0 && level > 1) {
                counter = nextLevelThreshold - 1;
                level--;
            }

        }
    }


}

