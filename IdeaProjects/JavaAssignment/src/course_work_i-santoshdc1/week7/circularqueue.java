package week7;

import java.util.ArrayList;
public class circularqueue {

    ArrayList<Integer> queue = new ArrayList<Integer>();
    int rear;
    int front;
    int size;
    circularqueue(int size)
    {
        this.size = size;
        System.out.println("Size:"+size);
        this.front = this.rear = -1;
    }
    public void enQueue(int data)
    {

        if((front == 0 && rear == size - 1) ||
                (rear == (front - 1) % (size - 1)))
        {
            System.out.print("Queue is Full");
        }
        // condition for empty queue.
        else if(front == -1)
        {
            front = 0;
            rear = 0;
            queue.add(rear, data);
        }
        else if(rear == size - 1 && front != 0)
        {
            rear = 0;
            queue.set(rear, data);
        }
        else
        {
            rear = (rear + 1);
            // Adding a new element if
            if(front <= rear)
            {
                queue.add(rear, data);
            }
            // Else updating old value
            else
            {
                queue.set(rear, data);
            }
        }
    }
    // Function to dequeue an element
// form th queue.
    public int deQueue()
    {
        int temp;
        // Condition for empty queue.
        if(front == -1)
        {
            System.out.print("Queue is Empty");
            // Return -1 in case of empty queue
            return -1;
        }
        temp = queue.get(front);
        // Condition for only one element
        if(front == rear)
        {
            front = -1;
            rear = -1;
        }
        else if(front == size - 1)
        {
            front = 0;
        }
        else
        {
            front = front + 1;
        }

        return temp;
    }

    public void displayQueue()
    {
        if(front == -1)
        {
            System.out.print("Queue is Empty");
            return;
        }

        System.out.print("Elements in the " +
                "circular queue are: ");
        if(rear >= front)
        {
            // Loop to print elements from
            // front to rear.
            for(int i = front; i <= rear; i++)
            {
                System.out.print(queue.get(i));
                System.out.print(" ");
            }
            System.out.println();
        }
        // If rear crossed the max index and
        // indexing has started in loop
        else
        {

            for(int i = front; i < size; i++)
            {
                System.out.print(queue.get(i));
                System.out.print(" ");
            }

            for(int i = 0; i <= rear; i++)
            {
                System.out.print(queue.get(i));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    // Driver code
    public static void main(String[] args)
    {
        circularqueue q = new circularqueue(5);
        q.enQueue(14);
        q.enQueue(22);
        q.enQueue(13);
        q.enQueue(-6);
        q.displayQueue();
        int x = q.deQueue();
        // Checking for empty queue.
        if(x != -1)
        {
            System.out.print("Deleted value = ");
            System.out.println(x);
        }
        x = q.deQueue();
        if(x != -1)
        {
            System.out.print("Deleted value = ");
            System.out.println(x);
        }
        q.displayQueue();
        q.enQueue(9);
        q.enQueue(20);
        q.enQueue(5);
        int o = q.deQueue();
        q.enQueue(40);
        q.displayQueue();

    }



}