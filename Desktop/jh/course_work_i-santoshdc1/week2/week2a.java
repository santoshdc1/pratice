package week2;


//importing stack
import java.util.Stack;
//checking balance parenthesis within a string
public class week2a {
    boolean checkStatus(String input) {
        Stack<Character> stk= new Stack<>();
        String openingpara ="[{(";
        String closingpara= "]})";
        for(int i=0; i<input.length(); i++) {
            char current = input.charAt(i);
            if (openingpara.indexOf(current)!=-1) {
                stk.push(current);
            }
            else{
                int paraindex= closingpara.indexOf(current);
                char correspnd= openingpara.charAt(paraindex);
                if(stk.pop()!= correspnd) {
                    return false;

                }
            }
        }
        if(stk.size()==0) {
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String[] args) {
        String parathesis ="{()}{}";
        week2a para = new week2a();
        boolean ab= para.checkStatus(parathesis);
        if (ab==false) {
            System.out.println("False");
        }
        else {
            System.out.println("True");
        }
    }
}
