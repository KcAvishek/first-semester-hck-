import java.util.*;

public class mergesort_np03cs4a220181{
    void merge(int []arr, int m, int n, int o)
    {

        int n1 = n - m + 1;
        int n2 = o - n;

        int []M = new int[n1];
        int []O = new int[n2];


        for (int i = 0; i < n1; ++i)
            M[i] = arr[m + i];
        for (int j = 0; j < n2; ++j)
            O[j] = arr[n + 1 + j];



        int i = 0, j = 0;


        int k = m;
        while (i < n1 && j < n2) {
            if (M[i] <= O[j]) {
                arr[k] = M[i];
                i++;
            }
            else {
                arr[k] = O[j];
                j++;
            }
            k++;
        }


        while (i < n1) {
            arr[k] = M[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = O[j];
            j++;
            k++;
        }
    }

    void mergesort_np03cs4a220181 (int arr[], int m, int o)
    {
        if (m < o) {

            int n = m + (o - m) / 2;

            mergesort_np03cs4a220181(arr, m, n);
            mergesort_np03cs4a220181(arr, m + 1, o);


            merge(arr, m, n, o);
        }
    }


    static void printArray(int []arr)
    {
        int n = arr.length;
        for (int A = 0; A < n; ++A)
            System.out.print(arr[A] + " ");
        System.out.println();
    }

    public static void main (String [] args)
    {
        int size,A;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of elements in the array:");
        size = s.nextInt();
        int arr[]= new int[size];;
        System.out.println("Enter "+size+" elements ");
        for( A=0; A < size; A++)
        {
            arr[A] = s.nextInt();
        }

        System.out.println("given arrey  ");
        printArray(arr);

        mergesort_np03cs4a220181 ob = new mergesort_np03cs4a220181();
        ob.mergesort_np03cs4a220181(arr, 0, arr.length - 1);

        System.out.println("\n Main array");
        printArray(arr);
    }
}
