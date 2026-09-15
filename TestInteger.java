// Guadalupe D. Tucker J.

import java.util.Random;
// import java.lang.ClassCastException;
// import java.lang.NullPointerException;

public class TestInteger implements Comparable<TestInteger> {
    public static long counter = 0;
    int value;
    public TestInteger(int val){
        this.value = val;
    }
    public int compareTo(TestInteger two){
    //  if(this.value =ll | two == null){throw NullPointerException();}
    //    if(!(two instanceof TestInteger )){throw ClassCastException("doesn'twrokr");}
        counter += 1;
        if(this.value < two.value){
            return -1;
        } else if (this.value > two.value){
            return 1;
        } else {
            return 0;
        }
    }
    public static void main(String[] args){
        Random gen = new Random();
        TestInteger[] arr = new TestInteger[10000];
        for (int i = 0; i<10000;i++){
            TestInteger num = new TestInteger(gen.nextInt(0,1000000));
            arr[i] = num;
        }

        Quicksort qs = new Quicksort();
        qs.qsort(arr,0, arr.length-1);
        // for (int i = 0; i<10000;i++){
        //     System.out.println(arr[i].value);
        // }
    }

}