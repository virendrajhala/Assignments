package org.fretron.day1;

import java.util.*;

// program to find the second smallest element in the given array
class SecondMax {
    public static void main(String[] args) {

        // create Scanner object for standard input
        Scanner scn = new Scanner(System.in);

        // take user input for array size
        int n = scn.nextInt();

        // create new array object with size specified by the user
        int[] arr = new int[n];

        // take all array elements from user as input
        for(int i = 0;i<n;i++)
        {
            arr[i] = scn.nextInt();
        }

        // print second minimum element by calling findSecondMin() in System.out.println()
        System.out.println(findSecondMin(arr));
    }

    public static int findSecondMin(int[] arr){

    // declare and initialize minimum and secondMin two variables
    int min =arr[0],secondMin =arr[1];

    // loop through array and update the minimum and secondMin variables accordingly
    //  T.C : O(n)
    // S.C : O(1)
        for(int i = 1;i<arr.length;i++)
    {
        if (arr[i] < min) {
            secondMin = min;
            min = arr[i];
        }
    }

      return secondMin;
    }

}


// program to find target sum pair
class PairSum{

    public static void main(String[] args) {

        // create Scanner object for standard input
        Scanner scn = new Scanner(System.in);

        // take user input for array size
        int n = scn.nextInt();

        // create new array object with size specified by the user
        int[] arr = new int[n];

        // take all array elements from user as input
        for(int i = 0;i<n;i++)
        {
            arr[i] = scn.nextInt();
        }

        // get the target sum from user input
        int target = scn.nextInt();

        // call findTargetSumPairs(arr,target)
        findTargetSumPairs(arr,target);
    }

    public static void findTargetSumPairs(int[] arr, int target){

        // sort the given array
        // T.C : O(nlogn)
        Arrays.sort(arr);

        // take two index pointers low and high and initialise them with 0 and arr.length-1 respectively
        int low=0, high = arr.length-1;

        // execute till low is less than high
        while(low < high){

            if(arr[low] + arr[high] == target){
                System.out.println(arr[low]+","+arr[high]);
                low++;
                high--;
            }

            else if(arr[low] + arr[high] < target){
                low++;
            }

            else{
                high--;
            }
        }
    }
}
