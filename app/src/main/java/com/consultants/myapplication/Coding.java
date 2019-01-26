package com.consultants.myapplication;

public class Coding {



    public int findSum(int[] arr){

        int maxNumber =0;
        int secondMax = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>maxNumber) {
                secondMax = maxNumber;
                maxNumber = arr[i];
            }else if (arr[i]>secondMax ){
                secondMax = arr[i];

            }
        }

        return maxNumber + secondMax;

    }


}
