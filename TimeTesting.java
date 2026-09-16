import java.util.Random;
import java.lang.reflect.Array;

// import jdk.incubator.vector.VectorOperators.Test;

// import java.util.ArrayList;
import java.util.Arrays;


class TimeTesting {
    // ret n items of arr all between 0 and m
    public TestInteger[] getRandomArray(){
        Random gen = new Random();
        TestInteger[] arrRandom = new TestInteger[10000];
        for (int i = 0; i<10000;i++){
            TestInteger num = new TestInteger(gen.nextInt(0,1000000));
            arrRandom[i] = num;
        }
        return arrRandom;
    }

    public void getTwoRandArrs(TestInteger[] arr1, TestInteger[] arr2){
            arr1 = getRandomArray();
            arr2 = new TestInteger[arr1.length];
            for (int k = 0; k<arr1.length;k++){
                arr2[k] = arr1[k];
            }
    }
    public TestInteger[][] getTenSubSortedArrays(int size){
        TestInteger[][] arr = new TestInteger[10][size];
        for(int i=0;i<10;i++){
            arr[i] = getRandomArray();
            Arrays.sort(arr[i]);
        }

        return arr;
    }
    public void getTenSubSortedArraysReversed(TestInteger[][] arr){

        Random gen = new Random();
        int randInt = gen.nextInt();

        for (int i = 0; i<arr.length; i++){
            for (int j = 0; j<(arr[0].length/2);j++){
                // swap ith with -ith
                arr[i][j] = arr[i][arr[0].length - j];
            }
        }

    }
// 10,000 random TestIntegers in the range from 1 to 1,000,000 and put them (in the same order) into two arrays. Use Java random number generator Math.random (Links to an external site.). 
// The entire 10,000 element array is sorted in increasing order. 
// 10 sorted sequences of 1,000 elements each (randomly choose the starting number in each sequence). 
// 10 reverse-sorted (decreasing) sequences of 1,000 elements each (randomly choose the starting number in each sequence). 
// Make sure to reset the counter to 0 before each sorting and record its value after. Run all your tests (see below) 5 times on each of these sets.
    public void part1sortFiveTimes(Quicksort qs) {
        TestInteger.counter = 0;
        // two sets of arrs for calcs
        TestInteger[] arr1 = new TestInteger[10000];
        TestInteger[] arr2 = new TestInteger[arr1.length];

        for (int i = 0;i<5;i++){
            // set up 2 arrays of 10,000 elements in same order
            getTwoRandArrs(arr1, arr2);
            // Timmy sort
            Arrays.sort(arr1);
            System.out.print("\nTim sort: " + TestInteger.counter);
            TestInteger.counter = 0;
            // Our Quicksort Implementation
            qs.qsort(arr2, 0, 10000);
            System.out.print("\nOur Quicksort: " + TestInteger.counter);
            TestInteger.counter = 0;
        }
    }
    public int sortFiveTimes(QuicksortInterface qs) {
        TestInteger.counter = 0;
        for (int i = 0;i<5;i++){
            // set up 2 arrays of 10,000 elements in same order
            TestInteger[] arr1 = getRandomArray();
            TestInteger[] arr2 = new TestInteger[10000];
            for (int j = 0; j < 10000; j++) {
                arr2[j] = arr1[j];
            }
            // sort whole array
            qs.qsort(arr1, 0, 10000);
            // sort 10 subarrays w/ random pivots
            for (int k = 0; k < 10000; k++) {
                arr2[k] = arr1[k];
            }
        }
        return 0;
    }

    public static void main(String s[]){
        TestInteger.counter = 0;
        TimeTesting tt = new TimeTesting();
        TestInteger[] arr1 = tt.getRandomArray();
        Arrays.sort(arr1);

        System.out.println(TestInteger.counter);

        

        // Quicksort qs = new Quicksort();
        // long timeStart = System.currentTimeMillis();
        // qs.qsort(getRandomArray(), 0, 10000);
        // long timeEnd = System.currentTimeMillis();


    }
}
