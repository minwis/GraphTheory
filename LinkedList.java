import java.util.*;

public class LinkedList {

    public static node head = new node(1);
    public static node two = new node(2);

    public static void removeNode(node Node, int removeValue) {
        if ( Node.equals(head) && Node.value == removeValue ) {
            head = two;
        }
        else if ( Node.next.value == removeValue ) {
            Node.next = Node.next.next;
        }
        else {
            removeNode(Node.next, removeValue);
        }
    }

    public static void main(String args[]) {
        //node start = new node

        node three = new node(3);
        node four = new node(4);
        node five = new node(5);
        node six = new node(6);
        node seven = new node(7);
        node eight = new node(8);
        node nine = new node(9);
        node ten = new node(10);

        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;

        Scanner sc = new Scanner(System.in);
        int removeValue = sc.nextInt();

        removeNode(head, removeValue);

        node N = head;
        while (true) {
            System.out.print(N.value + " ");
            if ( N.next == null ) {
                break;
            }
            else {
                N = N.next;
            }
        }
    }
}
