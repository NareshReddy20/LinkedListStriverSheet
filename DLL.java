import java.util.*;

class Node {
    int data;
    Node next;
    Node back;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }

    Node(int data, Node back, Node next) {
        this.data = data;
        this.back = back;
        this.next = next;
    }
}

// Double Linked List
public class DLL {
    private static void print(Node head) {
        while (head != null) {
            System.out.println(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static Node contoArr(int arr[]) {
        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            temp.back = prev;
            temp.next = null;
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    private static Node deleteHead(Node head) {

        if (head == null || head.next == null) {
            return null;
        }
        Node prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;// Properly disconnect the old head to prevent memory leaks
        return head;
    }

    private static Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        // Node temp=head;
        // Node prev=null;
        // while(temp.next!=null){
        // prev=temp;
        // temp=temp.next;
        // }
        // prev.next=null;
        // temp.back=null;
        // return head;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newTail = temp.back;
        newTail.next = null;
        temp.back = null;
        return head;
    }

    private static Node deleteK(Node head, int k) {
        if (head == null) {
            return null;
        }

        int c = 0;
        Node knode = head;
        while (knode != null) {
            c++;
            if (c == k) {
                break;
            }
            knode = knode.next;
        }
        Node prev = knode.back;
        Node front = knode.next;
        if (prev == null && front == null) {
            return null;
        } else if (prev == null) {
            return deleteHead(head);
        } else if (front == null) {
            return deleteTail(head);
        }

        prev.next = front;
        front.back = prev;
        knode.back = null;
        knode.next = null;

        // if(head==null)
        // {
        // return null;
        // }

        // if(k==1)
        // {
        // head=head.next;
        // if(head!=null){
        // head.back=null;
        // }
        // return head;
        // }
        // int c=1;
        // Node temp=head;
        // while(temp!=null&&c<k)
        // {
        // temp=temp.next;
        // c++;
        // }
        // if(temp==null){
        // return head;
        // }
        // Node prev=temp.back;
        // Node nextTemp=temp.next;
        // prev.next=nextTemp;
        // if(nextTemp!=null){
        // nextTemp.back=prev;
        // }
        // return head;

        // Node prev=null;
        // Node temp=head;
        // int c=1;
        // while(temp!=null){
        // if(c==k){
        // Node nextTemp=temp.next;
        // prev.next=nextTemp;
        // nextTemp.back=prev;
        // break;
        // }
        // prev=temp;
        // temp=temp.next;
        // c++;
        // }
        return head;
    }

    private static void deleteNode(Node temp) {

        Node back = temp.back;
        Node front = temp.next;
        if (front == null) {
            back.next = null;
            temp.back = null;
            return;
        }
        back.next = front;
        front.back = back;
        temp.next = null;
        temp.back = null;
        return;

    }

    private static Node insertBeforeHead(Node head1, int val) {
        Node nn = new Node(val);
        nn.next = head1;
        nn.back = null;
        head1.back = nn;
        return nn;
    }

    private static Node insertBeforeTail(Node head1, int val) {
        if (head1.next == null) {
            return insertBeforeHead(head1, val);
        }
        Node nn = new Node(val);
        Node temp = head1;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        Node nextTemp = temp.next;
        temp.next = nn;
        nn.back = temp;
        nn.next = nextTemp;
        nextTemp.back = nn;
        return head1;
    }

    private static Node insertBeforeK(Node head1, int k) {
        Node tail = head1;
        int c = 0;
        if (k == 1) {
            return insertBeforeHead(head1, 1);
        }
        while (tail != null) {
            c++;
            if (c == k) {
                break;
            }
            tail = tail.next;
        }
        Node nn = new Node(45);
        Node back = tail.back;
        nn.back = back;
        nn.next = tail;
        tail.back = nn;
        back.next = nn;
        return head1;
    }

    private static void insertBeforeNode(Node node, int val) {
        Node prev = node.back;
        Node nn = new Node(val);
        nn.next = node;
        nn.back = prev;
        prev.next = nn;
        node.back = nn;

    }

    public static void main(String[] args) {
        int arr[] = { 12, 5, 6, 8 };
        // Node head=contoArr(arr);
        // print(head);
        // head=deleteHead(head);
        // print(head);
        // head=deleteTail(head);
        // print(head);
        int arr1[] = { 10, 20, 30, 40, 50 };
        Node head1 = contoArr(arr1);
        print(head1);
        head1 = deleteK(head1, 1);
        print(head1);

        deleteNode(head1.next.next.next);
        print(head1);

        head1 = insertBeforeHead(head1, 5);
        print(head1);

        head1 = insertBeforeTail(head1, 35);
        print(head1);

        head1 = insertBeforeK(head1, 1);
        print(head1);

        insertBeforeNode(head1.next.next, 10);
        print(head1);

    }
}
