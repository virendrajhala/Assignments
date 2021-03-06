package org.fretron.day2;

import java.util.*;

public class Day2Assignment {

    public static void main(String[] args) {


       // NoAccidentQuestion();

       ApplesShareQuestion();
    }

    public static void NoAccidentQuestion(){

    }

    public static void ApplesShareQuestion(){

        ApplesShare.distributeApples();
    }


}

class ApplesShare{

    public static void distributeApples() {

        // get input from user in apples arraylist through handleInput() method
        ArrayList<Integer> appleWeights = handleInput();

        // make new arraylist to preserve the original one (appleWeights)
        ArrayList<Integer> apples = new ArrayList<>(appleWeights);

        // get iterator object to traverse in arraylist
        Iterator i = apples.iterator();
        int sum = 0;

        // get the total sum of weights
        // T.C : O(n)
        while(i.hasNext()){
            sum = sum + (Integer)i.next();
        }

        // determine the maximum share of each person
        int ramsMaxShare = sum/2;
        int shamsMaxShare = sum/3;
        int rahimsMaxShare = sum/5;

        // declare sum variables to check the sum of each person at each iteration
        int ramsApplesSum = 0;
        int shamsApplesSum = 0;
        int rahimsApplesSum = 0;

        // declare strings to store output
        String ramsApples = "";
        String shamsApples = "";
        String rahimsApples = "";

        // declare lists for each person to store their apple weights
        ArrayList<Integer> ramsAppleList = new ArrayList<>();
        ArrayList<Integer> shamsAppleList = new ArrayList<>();
        ArrayList<Integer> rahimsAppleList = new ArrayList<>();

        // sort arraylist in descending order
        // T.C : O(nlogn)
        Collections.sort(apples,new MyComparator());

        // traverse through arraylist to scan each element for the sum
        // T.C : O(n)
        for(int j=0;j<apples.size();j++){

            int appleWeight = apples.get(j);

            // if incoming weight's addition lies within max share of Ram
            if(ramsApplesSum + appleWeight <= ramsMaxShare){
                ramsApplesSum += appleWeight;

                // add apple weights to the ram's list of apple weights
                ramsAppleList.add(appleWeight);
            }

            // if incoming weight's addition lies within max share of Sham
            else if(shamsApplesSum + appleWeight <= shamsMaxShare){
                shamsApplesSum += appleWeight;

                // add apple weights to the sham's list of apple weights
                shamsAppleList.add(appleWeight);
            }

            // if incoming weight's addition lies within max share of Rahim
            else if(rahimsApplesSum + appleWeight <= rahimsMaxShare){
                rahimsApplesSum += appleWeight;

                // add apple weights to the rahim's list of apple weights
                rahimsAppleList.add(appleWeight);
            }
        }

        // print the output

         String ramsAppleWeights = ramsAppleList.toString();
         ramsAppleWeights = String.join(",",ramsAppleWeights);

         System.out.println("Ram : "+ramsAppleWeights);

        String shamsAppleWeights = shamsAppleList.toString();
        shamsAppleWeights = String.join(",",shamsAppleWeights);

        System.out.println("Sham : "+shamsAppleWeights);

        String rahimsAppleWeights = rahimsAppleList.toString();
        rahimsAppleWeights = String.join(",",rahimsAppleWeights);

        System.out.println("Rahim : "+ramsAppleWeights);

    }

    public static ArrayList<Integer> handleInput(){

        Scanner s = new Scanner(System.in);

        ArrayList<Integer> apples = new ArrayList<>();

        // run the loop till it finds break statement
        while(true){

            System.out.println("Enter apple weight in gram (-1 to stop) : ");
            int val = s.nextInt();
            if(val == -1)
                break;

            apples.add(val);
        }

        return apples;
    }
}

// custom comparator to sort arraylist<Integer> in descending order
class MyComparator implements Comparator<Integer>{

    public int compare(Integer i1, Integer i2){

        return -i1.compareTo(i2);
    }
}

class NoAccident{

}
