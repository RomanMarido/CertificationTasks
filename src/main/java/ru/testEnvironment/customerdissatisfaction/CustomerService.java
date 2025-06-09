package ru.testEnvironment.customerdissatisfaction;


import java.util.Arrays;

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
        Arrays.sort(goods);
        for (int buyerId : buyers) {
            if (Arrays.binarySearch(goods, buyerId) >= 0) {
                continue;
            }
            total += findNearest(goods, buyerId);
        }

        return total;
    }

    private static int findNearest(int[] sortedArray, int value) {
        int left = 0;
        int right = sortedArray.length - 1;
        int minDiff = Math.abs(value - sortedArray[0]);

        //Binary search
        while (left <= right) {
            int aroundMid = left + (right - left) / 2;
            int currentDiff = Math.abs(value - sortedArray[aroundMid]);

            if (currentDiff < minDiff) {
                minDiff = currentDiff;
            }

            if (sortedArray[aroundMid] < value) {
                left = aroundMid + 1;
            } else {
                right = aroundMid - 1;
            }
        }

        return minDiff;
    }
}
