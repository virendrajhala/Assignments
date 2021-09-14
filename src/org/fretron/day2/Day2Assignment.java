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
        ArrayList<Integer> apples = handleInput();

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
        String ramsApples = "Ram : ";
        String shamsApples = "Sham : ";
        String rahimsApples = "Rahim : ";

        // sort arraylist in descending order
        // T.C : O(nlogn)
        Collections.sort(apples,new MyComparator());

        // traverse through arraylist to scan each element for the sum
        // T.C : O(n)
        for(int j=0;j<apples.size();j++){

            int appleWeight = apples.get(j);

            // if appleWeight == -1 then it has already been used so skip the iteration
            if(appleWeight == -1)
                continue;

            // if incoming weight's addition lies within max share of Ram
            if(ramsApplesSum + appleWeight <= ramsMaxShare){
                ramsApplesSum += appleWeight;

                // if string is not having any value already then directly add
                if(ramsApples.equals("Ram : "))
                ramsApples = ramsApples + appleWeight;


                // otherwise add with comma in between
                else
                    ramsApples = ramsApples + ", "+appleWeight;

                // set used weight element to -1
                apples.set(j,-1);
            }

            // if incoming weight's addition lies within max share of Sham
            else if(shamsApplesSum + appleWeight <= shamsMaxShare){
                shamsApplesSum += appleWeight;

                // if string is not having any value already then directly add
                if(shamsApples.equals("Sham : "))
                    shamsApples = shamsApples + appleWeight;


                // otherwise add with comma in between
                else
                    shamsApples = shamsApples + ", "+appleWeight;

                // set used weight element to -1
                apples.set(j,-1);
            }

            // if incoming weight's addition lies within max share of Rahim
            else if(rahimsApplesSum + appleWeight <= rahimsMaxShare){
                rahimsApplesSum += appleWeight;

                // if string is not having any value already then directly add
                if(rahimsApples.equals("Rahim : "))
                    rahimsApples = rahimsApples + appleWeight;


                // otherwise add with comma in between
                else
                    rahimsApples = rahimsApples + ", "+appleWeight;

                // set used weight element to -1
                apples.set(j,-1);
            }
        }

        // print the output
        System.out.println(ramsApples);
        System.out.println(shamsApples);
        System.out.println(rahimsApples);

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
