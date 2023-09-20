package com.tjelvargames.mathlogic;

import java.util.ArrayList;

public class Test {
    static MultiplicationTablesTask task;
    static ArrayList<String> results = new ArrayList<>();
    static int j = 5;
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            for (int n =1; n<20;n++) {

                task = new MultiplicationTablesTask().newTask();
                task.printInfo();
                results.add(String.format("%d X %d", task.getFactor1(), task.getFactor2()));

            }

        results.add("///////////");

        }
        System.out.println(results);
    }
}
