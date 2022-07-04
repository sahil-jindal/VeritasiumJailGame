package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Main {
    static boolean isPrisonersFree(Integer[] boxNumbers) {
        int maxCount = 50;

        for (Integer prisonNumber: boxNumbers) {
            int count = 0;
            Integer temp = prisonNumber;

            while(true) {
                Integer ticketNumber = boxNumbers[temp];
                ++count;
                if(Objects.equals(ticketNumber, prisonNumber)) break;
                temp = ticketNumber;
            }

            if(count > maxCount) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Integer[] boxNumbers = new Integer[100];

        for(int i = 0; i < boxNumbers.length; i++) {
            boxNumbers[i] = i;
        }

        List<Integer> intList = Arrays.asList(boxNumbers);

        int totalTrials = 0;
        int wins = 0;
        int fails = 0;

        while(++totalTrials < 100000) {
            Collections.shuffle(intList);
            intList.toArray(boxNumbers);

            boolean result = isPrisonersFree(boxNumbers);
            if(result) wins++; else fails++;
        }

        System.out.println(totalTrials);
        System.out.println("winning percentage: " + ((float) wins / (float) totalTrials) * 100);
        System.out.println("winning percentage: " + ((float) fails / (float) totalTrials) * 100);
    }
}