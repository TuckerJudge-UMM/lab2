import java.util.Random;

public class Quicksort {
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
        TestInteger[] arr = new TestInteger[10000];
        for (int i = 0; i<10000;i++){
            TestInteger num = new TestInteger(gen.nextInt(0,1000000));
            arr[i] = num;
        }

        Quicksort qs = new Quicksort();
        qs.qsort(arr,0, arr.length-1);
        for (int i = 0; i<10000;i++){
            System.out.println(arr[i].value);
        }
    }
}