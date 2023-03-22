import java.util.*;

public class LinkedList {

    public static class node {

        public int value;
        public node next;

        public node(int value) {
            this.value = value;
            next = null;
        }
    }

    public static node head = new node(1);

    public static void removeNode(node Node, int removeValue) {
        if ( Node.equals(head) && Node.value == removeValue ) {
            head = head.next;
        }
        else if ( Node.next.value == removeValue ) {
            Node.next = Node.next.next;
        }
        else {
            removeNode(Node.next, removeValue);
        }
    }

    public static void removeNode(node Node, int index, int removeIndex) {
        if ( Node.equals(head) && index == removeIndex ) {
            head = head.next;
        }
        else if ( index == removeIndex ) {
            Node.next = Node.next.next;
        }

        if ( Node.next != null ) {
            removeNode(Node.next, index + 1, removeIndex);
        }

    }

    public static void addNode(node Node, node targetNode) {
        if ( Node.next == null ) {
            Node.next = targetNode;
        }
        else {
            addNode(Node.next, targetNode);
        }
    }

    public static void addNode(node Node, node targetNode, int index, int targetIndex) { //the index starts with 0.
        if ( index+1 == targetIndex ) {
            targetNode.next = Node.next;
            Node.next = targetNode;
        }
        else {
            addNode(Node.next, targetNode, index + 1, targetIndex);
        }
    }

    public static void main(String args[]) {

        /*node two = new node(2);
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
        nine.next = ten;*/

        for ( int i = 2; i <= 10; i++ ) {
            addNode(head, new node(i));
        }

        //addNode(head, new node(4), 0, 4);
        for ( int i = 1; i <= 10; i++ ) {
            removeNode(head, i);

            node N = head;
            while (true) {
                try {
                    System.out.print(N.value + " ");
                } catch ( NullPointerException e ) {
                    System.out.println("All Nodes are successfully removed!");
                    break;
                }

                if ( N.next == null ) {
                    break;
                }
                else {
                    N = N.next;
                }
            }

            System.out.println();
        }
        /*
        Scanner sc = new Scanner(System.in);
        int removeValue = sc.nextInt();
        removeNode(head, 1);
        removeNode(head, 2);

        node N = head;
        while (true) {
            System.out.print(N.value + " ");
            if ( N.next == null ) {
                break;
            }
            else {
                N = N.next;
            }
        }*/
    }
}
