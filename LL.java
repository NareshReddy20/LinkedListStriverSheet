package HelloWorld.LLstriver;
import java.util.*;

public class LL { 
    static class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }
    public static void main(String[] args) {
        int a[]={10,20,30};
        Node head=contoLL(a);
        print(head);
    }
    public static Node contoLL(int a[])
    {
        Node head=new Node(a[0]);
        Node mover=head;
        for(int i=1;i<a.length;i++)
        {
            Node temp=new Node(a[i]);
            mover.next=temp;
            mover=temp;
        }
        return head;
    }
    public static void print(Node head)
    {
        while(head!=null)
        {
            System.out.println(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }
}
