package com.rik.grokking.chapterfour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion {

    public static void main(String[] args){
        Integer[] numArray = {3,42,443,5,3,4,778};
        List<Integer> numbers = Arrays.asList(numArray);
        System.out.println(highestNumber(numbers));
        System.out.println(count(numbers));
    }

    private static Integer highestNumber(List<Integer> numbers) {
        if(numbers.size() == 0)
            return null;
        else if(numbers.size() == 1)
            return numbers.get(0);
        else{
            Integer head = numbers.get(0);
            List<Integer> tail = new ArrayList<>(numbers);
            tail.remove(head);
            Integer highestFromTail = highestNumber(tail);
            return head > highestFromTail ? head : highestFromTail;
        }
    }

    private static Integer count(List<?> list){
        if(list == null || list.isEmpty())
            return 0;
        else{
            List<?> smallerList = new ArrayList<>(list);
            smallerList.remove(list.size() - 1);
            return 1 + count(smallerList);
        }
    }
}
