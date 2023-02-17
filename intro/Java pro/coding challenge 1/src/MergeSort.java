
import java.util.*;

public class MergeSort{

    ArrayList getInput(ArrayList<Integer> al){
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter your Arraylist size: ");
        int num1 = scan.nextInt();
        System.out.println("Please enter your element: ");
        for(int i = 0; i < num1; i++){
            al.add(scan.nextInt());
        }
        return al;
    }

    void getOutput(ArrayList<Integer> al){

        System.out.println("Unsorted Array List: ");
        System.out.println(al);
        sort(al, 0, al.size()-1);
        System.out.println("Sorted Array List: ");
        System.out.println(al);

    }

    void merge(ArrayList<Integer> al,int begin,int middle, int end){


        int num2 = middle - begin + 1;
        int num3 = end - middle;

        ArrayList <Integer> tem1 = new ArrayList<Integer>();
        ArrayList<Integer> tem2 = new ArrayList<Integer>();

        for(int i = 0; i < num2;i++){
            tem1.add(al.get(begin + i));
        }
        for(int i = 0; i < num3;i++){
            tem2.add(al.get(middle + 1 + i));
        }


        int i = 0, j = 0;
        int y = begin;

        while(i <num2 && j <num3){
            if(tem1.get(i).compareTo(tem2.get(j)) < 0){
                al.set(y,tem1.get(i));
                i++;
            }
            else{
                al.set(y,tem2.get(j));
                j++;
            }
            y++;
        }
        while (i < num2)
        {
            al.set(y,tem1.get(i));
            i++;
            y++;
        }

        while (j < num3)
        {
            al.set(y,tem2.get(j));
            j++;
            y++;
        }
    }
    void sort(ArrayList<Integer> al, int begin, int end){

        if(begin == end){
            return;
        }

        if(begin<end){

            int middle = (begin+end)/2;
            sort(al,begin,middle);
            sort(al,middle+1,end);

            merge(al,begin,middle,end);
        }

    }
    public static void main(String[] args){
        MergeSort sub = new MergeSort();
        ArrayList<Integer> given = new ArrayList<Integer>();
        given = sub.getInput(given);
        sub.getOutput(given);
    }
}
