package ru.testEnvironment.customerdissatisfaction;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerServiceTest {

    @Test
    public void testCalculateDissatisfaction() {
        int[] goods = {1, 3, 4};
        int[] buyers = {2, 4, 6};

        int actual = CustomerService.calculateDissatisfaction(goods, buyers);
        int expected = 3;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testCalculateDissatisfaction2() {
        int[] goods = {4};
        int[] buyers = {2, 4, 6};

        int actual = CustomerService.calculateDissatisfaction(goods, buyers);
        int expected = 4;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenGoodsIsEmptyThen0() {
        int[] goods = {};
        int[] buyers = {2, 4, 6};

        int actual = CustomerService.calculateDissatisfaction(goods, buyers);
        int expected = 12;

        assertThat(actual).isEqualTo(expected);
    }
}