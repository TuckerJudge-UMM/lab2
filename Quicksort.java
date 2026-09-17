import java.util.Random;
import java.util.Arrays;

public class Quicksort implements QuicksortInterface {
    public void qsort(TestInteger[] arr, int p, int r){
        if(p < r){
            int q = Partition(arr, p, r);

            qsort(arr, p, q-1);
            qsort(arr, q+1, r); 
        }
    }

    public int Partition(TestInteger[] arr, int p, int r){
        TestInteger x = arr[r];
        int i = p-1;
        for(int j=p; j<r; j++){
            // stable??
            if(arr[j].compareTo(x)<=0){
                i=i+1;
                TestInteger temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        TestInteger temp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = temp;

        return i+1;
    }
    public static void main(String[] args){
        Random gen = new Random();
        int n = 10;
        TestInteger[] arr = new TestInteger[n];
        for (int i = 0; i<n;i++){
            TestInteger num = new TestInteger(gen.nextInt(0,1000000));
            arr[i] = num;
        }
        Quicksort qs = new Quicksort();
        Arrays.sort(arr);
        // qs.qsort(arr,0, arr.length-1);
        for (int i = 0; i<n;i++){
            System.out.println(arr[i].value);
        }
    }
}
