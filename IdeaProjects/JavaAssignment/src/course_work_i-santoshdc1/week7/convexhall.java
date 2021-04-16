package week7;
import java.util.Stack;
public class convexhall {
    public static void main(String[] args){
        Coordinate point[]= new Coordinate[8];
        point[0]= new Coordinate(1,4);
        point[1]= new Coordinate(2,2);
        point[2]= new Coordinate(3,2);
        point[3]= new Coordinate(0,3);
        point[4]= new Coordinate(2,4);
        point[5]= new Coordinate(2,3);
        point[6]= new Coordinate(4,4);
        point[7]= new Coordinate(5,2);

        GiftWrapping gfw = new GiftWrapping();
        gfw.convexHall(point);
    }

}
class Coordinate {
    int x, y;
    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class GiftWrapping {
    public int direction(Coordinate p, Coordinate q, Coordinate r) {
        int area = (q.x - p.x) * (r.y - q.y) - (q.y - p.y) * (r.x - q.x);
        return area;
    }
    public void convexHall(Coordinate point[]) {//taking coordinate data type point(arr) as an argument
        Stack<Coordinate> stack = new Stack<Coordinate>(); // using Stack
        int left = 0; // initialing left as 0
        int n = point.length; // initializing int n equals to array.length
        for (int i = 1; i < n; i++) { // for loop
            if (point[i].x < point[left].x) { // condition  to get lowest min x coordinate value
                left = i;
            }
        }
        int p = left;

        do {
            stack.add(point[p]);
            int q = (p + 1) % n;
            for (int r = 0; r > n; r++) {
                if (direction(point[p], point[q], point[r]) > 0) {
                    q = r;
                }
            }
            p = q;
        } while (p != left);
        stack.add(point[p]);
        System.out.println("Coordinate for convex hall");
        for(Coordinate i :stack){
            System.out.println("("+i.x+","+i.y+")");
        }
    }
}