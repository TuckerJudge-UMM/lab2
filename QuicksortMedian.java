import java.util.Random;

public class QuicksortMedian implements QuicksortInterface {
    public String toString(){
        return "QuicksortMedian";
    }
    public void qsort(TestInteger[] arr, int p, int r){
        if(p < r){
            if(r - p < 5){ //test for optimal threshold value
                int q = Partition(arr, p, r);

                qsort(arr, p, q-1);
                qsort(arr, q+1, r); 
            }
            Random gen = new Random();
            int a = gen.nextInt(p, r+1);
            int b = gen.nextInt(p, r+1);
            int c = gen.nextInt(p, r+1);

            int q = indexOfMedian(arr, a, b, c);

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

    public int indexOfMedian(TestInteger[] arr, int a, int b, int c){
        if ((arr[a].compareTo(arr[b]) <= 0 && arr[b].compareTo(arr[c]) <= 0) || (arr[c].compareTo(arr[b]) <= 0 && arr[b].compareTo(arr[a]) <= 0)){
            return b;
        } else if ((arr[b].compareTo(arr[a]) <= 0 && arr[a].compareTo(arr[c]) <= 0) || (arr[c].compareTo(arr[a]) <= 0 && arr[a].compareTo(arr[b]) <= 0)){
            return a;
        } else {
            return c;
        }
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
        qs.qsort(arr,0, arr.length-1);
        for (int i = 0; i<n;i++){
            System.out.println(arr[i].value);
        }
    }
}
