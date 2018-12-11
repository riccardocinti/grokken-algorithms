package com.rik.grokking.chapterone;

public class BinarySearch {

    private static int[] arrayN = new int[] {1,2,3,4,5,10,44,55};

    public static void main(String[] args) {
        Integer inputToSearch = 55;
        Integer inputPosition = findInputPosition(inputToSearch);
        Integer inputPositionRec = findInputPositionRecursive(inputToSearch);
	    System.out.println("The given input is at the: " + inputPosition + " index of the array N");
        System.out.println("(Recursive) The given input is at the: " + inputPositionRec + " index of the array N");
    }

    private static Integer findInputPosition(Integer inputToSearch) {
        return binarySearchNotRecursive(inputToSearch);
    }

    private static Integer findInputPositionRecursive(Integer inputToSearch) {
        return binarySearchRecursive(inputToSearch, 0, arrayN.length - 1);
    }

    private static Integer binarySearchRecursive(Integer inputToSearch, int low, int high) {
        if(low > high)
            return null;
        int midPosition = (low + high) / 2;
        Integer guessedResult = arrayN[midPosition];
        if(inputToSearch.equals(guessedResult))
            return midPosition;
        if(inputToSearch > guessedResult){
            low = midPosition + 1;
        }else{
            high = midPosition - 1;
        }
        return binarySearchRecursive(inputToSearch, low, high);
    }

    private static Integer binarySearchNotRecursive(Integer inputToSearch){
        int high = arrayN.length - 1;
        int low = 0;
        while(low <= high){
            int midPosition = (low + high) / 2;
            Integer guessedResult = arrayN[midPosition];
            if(inputToSearch.equals(guessedResult))
                return midPosition;
            if(inputToSearch > guessedResult){
                low = midPosition + 1;
            }else{
                high = midPosition - 1;
            }
        }
        return null;
    }
}
