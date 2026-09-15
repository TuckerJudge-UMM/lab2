import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;


class TimeTesting {
    public TestInteger[] getRandomArray(){

        Random gen = new Random();
        TestInteger[] arrRandom = new TestInteger[10000];
        for (int i = 0; i<10000;i++){
            TestInteger num = new TestInteger(gen.nextInt(0,1000000));
            arrRandom[i] = num;
        }
        return arrRandom;
    }

    // public int sortFiveTimes(){                                                                                                                                                                                                                      
        
    //     TestInteger.counter = 0;
    //     for (int i = 0;i<5;i++){
    //         long timeStart = System.currentTimeMillis();
    //         //qs.qsort(getRandomArray(), 0, 10000);
    //         long timeEnd = System.currentTimeMillis();
    //     }
    // }

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