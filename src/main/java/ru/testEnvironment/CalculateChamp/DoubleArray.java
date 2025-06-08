package ru.testEnvironment.CalculateChamp;

import java.util.*;

public class DoubleArray  {

    public static void main(String[] args) {
        MemberStat[][] stat = {
                {new MemberStat(1, 5), new MemberStat(2, 6), new MemberStat(3, 20)},
                {new MemberStat(1, 15), new MemberStat(2, 10)},
                {new MemberStat(1, 4), new MemberStat(2, 15), new MemberStat(3, 25)}
        };

        Champs champs = getChamps(stat);
        System.out.printf("Champs: %s, %d", champs.ids(), champs.amount());
    }

    public static Champs getChamps(MemberStat[][] stat) {
        Map<Integer, Integer> sums = new HashMap<>();

        Map<Integer, Boolean> memberIdsPresent = new HashMap<>();
        Set<Integer> memberIds = new HashSet<>();

        boolean initialize = false;
        for (MemberStat[] group : stat) {
            for (MemberStat member : group) {
                if (!initialize) {
                    memberIds.add(member.id());
                } else if (!memberIds.contains(member.id())) {
                    continue;
                }
                memberIdsPresent.put(member.id(), true);
                sums.merge(member.id(), member.amount(), Integer::sum);
            }
            for (Integer memberId : memberIds) {
                boolean value = memberIdsPresent.get(memberId);
                if (!value) {
                    memberIds.remove(memberId);
                    sums.remove(memberId);
                }
                memberIdsPresent.put(memberId, false);
            }
            initialize = true;
        }

        Map.Entry<Integer, Integer> champEntry = sums.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow();

        return new Champs(List.of(champEntry.getKey()), champEntry.getValue());
    }
}

record MemberStat(int id, int amount) {
}

record Champs(List<Integer> ids, int amount) {
}


