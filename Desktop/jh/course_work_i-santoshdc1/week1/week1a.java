package week1;

import java.util.HashSet;
import java.util.LinkedList;

public class week1a {

    @SuppressWarnings("unchecked")

    static LinkedList<Integer> li = new LinkedList();

    public static void printArray(int[] a) {

        System.out.println("");

        for(int i=0; i<a.length; i++) {

            System.out.print(a[i]);

        }

    }

    public static void swap(int[] a, int i, int j) {

        int temp=a[i];

        a[i]=a[j];

        a[j]=temp;

    }

    public static void printPermutation(int[] a, int per) {

        if (per == a.length-1) {

            toBinary(a);
            return;

        }

        HashSet<Integer> hash = new HashSet<Integer>();

        for (int i=per; i<a.length; i++) {

            if(hash.contains(a[i])==true) {
                continue;
            }

            hash.add(a[i]);

            swap(a, i , per);

            printPermutation(a, per+1);

            swap(a, i, per);

        }
    }

    public static void toBinary(int binary[]) {

        int decimal = 0;

        int length = binary.length;

        for (int i=length-1;i>=0;i--){

            decimal = (int) (decimal + binary[i]* Math.pow(2,length-1-i));
        }

        li.add(decimal);

    }
    public static void main(String[] args) {

        int[] a= {1,0,1};

        printPermutation(a, 0);

        System.out.println(li);
    }
}