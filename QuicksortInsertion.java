import java.util.Random;

public class QuicksortInsertion implements QuicksortInterface {
    public String toString() {
        return "QuicksortInsertion";
    }

    public void qsort(TestInteger[] arr, int p, int r){
        if(p + 13 < r){
            int q = Partition(arr, p, r);

            qsort(arr, p, q-1);
            qsort(arr, q+1, r);
        } else if (p < r){
            insertionSort(arr, p, r); // Need to implement this fnc
        }
    }

    public void insertionSort(TestInteger[] arr, int p, int r){
        for(int i = p; i < r; i++){
            TestInteger key = arr[i];
            int j = i - 1;
            while(j >= p && arr[j].compareTo(key) > 0){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
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
        int n = 10000;
        TestInteger[] arr = new TestInteger[n];
        for (int i = 0; i<n;i++){
            TestInteger num = new TestInteger(gen.nextInt(0,1000000));
            arr[i] = num;
        }

        QuicksortInsertion qs = new QuicksortInsertion();
        qs.qsort(arr,0, arr.length-1);
        for (int i = 0; i<n;i++){
            System.out.println(arr[i].value);
        }
    }
}
