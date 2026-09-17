import java.util.Random;
import java.util.Arrays;


class TimeTesting {
    // ret n items of arr all between 0 and m
    public TestInteger[] getRandomArray(TestInteger[] arr1){
        Random gen = new Random();
        for (int i = 0; i<10000;i++){
            TestInteger num = new TestInteger(gen.nextInt(0,1000000));
            arr1[i] = num;
        }
        return arr1;
    }

    public void getTwoRandArrs(TestInteger[] arr1, TestInteger[] arr2){
            getRandomArray(arr1);
            for (int k = 0; k<10000;k++){
                arr2[k] = arr1[k];
            }
    }
    public TestInteger[][] getTenSubSortedArrays(int size){
        // Sorted rand arr
        TestInteger[] randArr = new TestInteger[10000];
        getRandomArray(randArr);
        Arrays.sort(randArr);

        Random gen = new Random();
        TestInteger[][] arr = new TestInteger[10][size/10];
        for(int i=0;i<10;i++) {
            int randInt = gen.nextInt(0, 9000);
            for (int j = 0; j<1000; j++){
                arr[i][j] = randArr[randInt+j];
            }
        }
        TestInteger.counter=0;
        return arr;
    }
    public void getTenSubSortedArraysReversed(TestInteger[][] arr){
        for (int i = 0; i<arr.length; i++){
            for (int j = 0; j<(arr[0].length/2);j++){
                // swap ith with -ith
                arr[i][j] = arr[i][arr[0].length - j - 1];
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
        TestInteger[] arr2 = new TestInteger[10000];

        for (int i=0;i<5;i++){
            // set up 2 arrays of 10,000 elements in same order
            getTwoRandArrs(arr1, arr2);
            // Timmy sort
            Arrays.sort(arr1);
            System.out.print("\nTim sort: " + TestInteger.counter);
            TestInteger.counter = 0;
            // Our Quicksort Implementation
            qs.qsort(arr2, 0, 9999);
            System.out.print("\nOur Quicksort: " + TestInteger.counter);
            TestInteger.counter = 0;
        }

        // Repeat the sorting, but instead of random elements use the arrays where elements are stored in increasing order. Write down your results.
        for (int j = 0;j<5;j++){
            getRandomArray(arr1);
            Arrays.sort(arr1);
            // Our Quicksort Sorted
            qs.qsort(arr1, 0, 9999);
            System.out.print("\nOur Quicksort Sorted: " + TestInteger.counter);
            TestInteger.counter = 0;

            // Timmy sort Sorted
            Arrays.sort(arr1);
            System.out.print("\nTim sort sorted: " + TestInteger.counter);
            TestInteger.counter = 0;
        }

        for (int k = 0;k<5;k++){
            TestInteger[][] subarrs = getTenSubSortedArrays(10000);
            for (int m = 0; m<10;m++){
                // Our Quicksort Sorted
                qs.qsort(subarrs[m], 0, 999);
            }
            System.out.print("\nSubArray Quicksort: " + TestInteger.counter);
            TestInteger.counter = 0;
        }
        for (int kk = 0;kk<5;kk++){
            TestInteger[][] subarrs = getTenSubSortedArrays(10000);
            for (int mm = 0; mm<10;mm++){
                // Timmy sort Sorted
                Arrays.sort(subarrs[mm]);
            }
            System.out.print("\nSubArray Tim sort: " + TestInteger.counter);
            TestInteger.counter = 0;
        }
        for (int z = 0;z<5;z++){
            TestInteger[][] subarrsreversed = getTenSubSortedArrays(10000);
            getTenSubSortedArraysReversed(subarrsreversed);
            for (int l = 0; l<10;l++){
                // Our Quicksort Sorted
                qs.qsort(subarrsreversed[l], 0, 999);
            }
            System.out.print("\nSubArray Reversed Quicksort: " + TestInteger.counter);
            TestInteger.counter = 0;
            for (int ll = 0; ll<10;ll++){
                // Timmy sort Sorted
                Arrays.sort(subarrsreversed[ll]);
            }
            System.out.print("\nSubArray Reversed Tim sort: " + TestInteger.counter);
            TestInteger.counter = 0;
        }
    }

    public void sortFiveTimes(QuicksortInterface qs) {
        TestInteger.counter = 0;
        TestInteger[] arr1 = new TestInteger[10000];

        // Regular sort of 10k items
        for (int i=0;i<5;i++){
            getRandomArray(arr1);
            qs.qsort(arr1, 0, 9999);
            System.out.print("\nRegular Sort: " + qs.toString() + " " + TestInteger.counter);
            TestInteger.counter = 0;
        }

        // Sub Arrays Sorted Forwards
        for (int k = 0;k<5;k++){
            TestInteger[][] subarrs = getTenSubSortedArrays(10000);
            for (int m = 0; m<10;m++){
                qs.qsort(subarrs[m], 0, 999);
            }
            System.out.print("\nSubArray Quicksort: " + qs.toString() + " " + TestInteger.counter);
            TestInteger.counter = 0;
        }
        // Sub Arrays Sorted Reverse
        for (int z = 0;z<5;z++){
            TestInteger[][] subarrsreversed = getTenSubSortedArrays(10000);
            getTenSubSortedArraysReversed(subarrsreversed);
            for (int l = 0; l<10;l++){
                // Our Quicksort Sorted
                qs.qsort(subarrsreversed[l], 0, 999);
            }
            System.out.print("\nSubArray Reversed Quicksort: " + qs.toString() + " " + TestInteger.counter);
            TestInteger.counter = 0;
        }
    }


    public static void main(String s[]){
        TestInteger.counter = 0;
        TimeTesting tt = new TimeTesting();
        QuicksortRandom qs = new QuicksortRandom();
        QuicksortMedian qs1 = new QuicksortMedian();
        QuicksortInsertion qs2 = new QuicksortInsertion();
        // We stdout to part2measurements.txt file
        tt.sortFiveTimes(qs);
        tt.sortFiveTimes(qs1);
        tt.sortFiveTimes(qs2);

        // tt.part1sortFiveTimes(qs);
    }
}
