package ru.testEnvironment.customerdissatisfaction;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CustomerService {
    public static void main(String[] args) {
        int[] goods = {3, 1, 4};
        int[] buyers = {2, 4, 6};

        System.out.println(calculateDissatisfaction(goods, buyers));
    }

    public static int calculateDissatisfaction(int[] goods, int[] buyers) {
        if (goods.length == 0) {
            return Arrays.stream(buyers).sum();
        }

        int total = 0;
        List<int[]> goodsList = Collections.singletonList(goods);
        for (int buyerId : buyers) {
            if (goodsList.contains(buyers)) {
                continue;
            }
            total += findNearest(goods, buyerId);
        }

        return total;
    }

    private static int findNearest(int[] array, int value) {
        int minDiff = Math.abs(value - array[0]);

        for (int i = 1; i < array.length; i++) {
            int currentDiff = Math.abs(value - array[i]);
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
            }
        }

        return minDiff;
    }
}
