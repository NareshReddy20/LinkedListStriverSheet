import java.util.*;
public class CLL {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static Node head=null;
    static Node tail=null;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        insertAtHead(10);
        insertAtHead(20);
        insertAtHead(30);
        insertAtTail(40);
        insertAtTail(50);
        deleteAtHead();
        deleteAtHead();
        deleteAtTail();
        
        print(head);

    }

    public static void insertAtHead(int data)
    {
          Node nn=new Node(data);
           if(head==null)
           {
            head=tail=nn;
            tail.next=nn;
           }
           else{
            nn.next=head;
            head=nn;
            tail.next=head;
            // nn.next=tail.next;
            // tail.next=nn;
           }
    } 

    public static void insertAtTail(int data){
        Node temp=head;
        Node nn=new Node(data);
        if(head==null){
            head=tail=nn;
            tail.next=nn;
        }
        else{
            tail.next=nn;
            tail=nn;
            tail.next=head;
        }
    }

    public static void deleteAtHead()
    {
        if(head==null){
            head=null;
            tail=null;
        }
        else if(head==tail){
            head=null;
            tail=null;
        }
        else{
            Node temp=head.next;
            head=temp;
            tail.next=head;
        }
    }

    public static void deleteAtTail(){
        if(head==null){
            head=tail=null;
        }
        else if(head==tail){
            head=null;
            tail=null;
        }
        else
        {
            Node temp=tail;
            Node prev=head;
            while(prev.next!=temp)
            {
                prev=prev.next;
            }
            tail=prev;
            prev.next=head;

            
        }
    }
    public static void print(Node head)
    {
        Node temp=head.next;
        while(temp!=head){
            System.out.println(temp.data);
            temp=temp.next;
        }
        System.out.print(temp.data+" ");

    }
}
