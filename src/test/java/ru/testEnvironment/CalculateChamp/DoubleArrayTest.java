package ru.testEnvironment.CalculateChamp;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DoubleArrayTest {

    @Test
    public void whenFirstChampMaxAmountThenWinFirstChap() {
        MemberStat[][] stat = {
                {new MemberStat(1, 5), new MemberStat(2, 6)},
                {new MemberStat(1, 15), new MemberStat(2, 5)},
                {new MemberStat(1, 4), new MemberStat(2, 10)}
        };

        Champs actual = DoubleArray.getChamps(stat);
        Champs expected = new Champs(List.of(1), 24);

        assertThat(actual.ids()).containsExactlyElementsOf(expected.ids());
        assertThat(actual.amount()).isEqualTo(expected.amount());
    }

    @Test
    public void whenSecondChampIsNotPresentInAnyRowThenWinFirstChap() {
        MemberStat[][] stat = {
                {new MemberStat(1, 5), new MemberStat(2, 20)},
                {new MemberStat(1, 15)},
                {new MemberStat(1, 4), new MemberStat(2, 15)}
        };

        Champs actual = DoubleArray.getChamps(stat);
        Champs expected = new Champs(List.of(1), 24);

        assertThat(actual.ids()).containsExactlyElementsOf(expected.ids());
        assertThat(actual.amount()).isEqualTo(expected.amount());
    }

    @Test
    public void whenSecondChampHasMaxAmountThenWinSecondChap() {
        MemberStat[][] stat = {
                {new MemberStat(1, 5), new MemberStat(2, 20)},
                {new MemberStat(1, 15), new MemberStat(2, 40)},
                {new MemberStat(1, 4), new MemberStat(2, 15), new MemberStat(3, 120)}
        };

        Champs actual = DoubleArray.getChamps(stat);
        Champs expected = new Champs(List.of(2), 75);

        assertThat(actual.ids()).containsExactlyElementsOf(expected.ids());
        assertThat(actual.amount()).isEqualTo(expected.amount());
    }

}