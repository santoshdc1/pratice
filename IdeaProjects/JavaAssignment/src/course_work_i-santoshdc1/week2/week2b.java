package week2;
import java.util.Stack;
public class week2b {
    int maxPop(int input, Stack<Integer> stacka, Stack<Integer> secondstack){
        int sum=0;
        int count=0;
        int limit = 0;
        if (stacka.size()>secondstack.size()) {
            limit= stacka.size();
        }
        else {
            limit= secondstack.size();
        }
        for(int i=0;i<limit;i++){
            int a= stacka.pop();
            sum= sum + a ;
            if(sum>input){
                break;
            }
            else{
                count++;
            }
            int b= secondstack.pop();
            sum = sum+b;
            if(sum>input){
                break;
            }
            else{
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Stack<Integer> stacka= new Stack<>();
        stacka.push(9);
        stacka.push(7);
        stacka.push(6);
        stacka.push(3);
        stacka.push(4);
        Stack<Integer> secondstack= new Stack<>();
        secondstack.push(5);
        secondstack.push(9);
        secondstack.push(2);
        secondstack.push(1);
        week2b myobj = new week2b();
        System.out.println(myobj.maxPop(11,stacka,secondstack));
    }
}