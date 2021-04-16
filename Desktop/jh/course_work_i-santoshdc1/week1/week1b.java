package week1;

import java.util.ArrayList;
import java.util.Arrays;

public class week1b {
    public static void main(String args[]) {

        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(2,3,5,11,17,23));
        int begin = list.get(0);
        int indx = list.size()-1;
        int last = list.get(indx);

        ArrayList<Integer> primenbr = new ArrayList<>();

        while (begin <= last) {
            boolean flag = false;

            for(int i = 2; i <= begin/2; ++i) {

                if(begin % i == 0) {

                    flag = true;
                    break;

                }
            }

            if (!flag && begin != 0 && begin != 1)

                primenbr.add(begin);

            ++begin;
        }

        for(int i =0 ; i<list.size(); i++) {

            for(int j = 0; j<primenbr.size(); j++) {

                if(list.get(i) == primenbr.get(j)) {

                    primenbr.remove(j);

                }
            }
        }

        System.out.println(primenbr);

    }

}

