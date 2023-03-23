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

        while ( true ) {
            if ( Node.equals(head) && Node.value == removeValue ) {
                head = head.next;
            }
            while ( Node.next != null && Node.next.value == removeValue ) {
                Node.next = Node.next.next;
            }

            if ( Node.next != null ) {
                Node = Node.next;
            }
            else {
                return;
            }
        }

    }

    public static void removeNode(node Node, int index, int removeIndex) {

        while ( true ) {
            if ( Node.equals(head) && index == removeIndex ) {
                head = head.next;
            }

            if ( index + 1 == removeIndex ) {
                Node.next = Node.next.next;
            }

            if ( Node.next != null ) {
                Node = Node.next;
                index++;
            }
            else {
                return;
            }
        }

    }

    public static void addNode(node Node, node targetNode) {
        while ( true ) {
            if ( Node.next == null ) {
                Node.next = targetNode;
                return;
            }
            else {
                Node = Node.next;
            }
        }
    }

    public static void addNode(node Node, node targetNode, int index, int targetIndex) {

        while ( true ) {
            if ( Node.equals(head) && index == targetIndex ) {
                targetNode.next = head;
                head = targetNode;
                return;
            }

            if ( index + 1 == targetIndex ) {
                targetNode.next = Node.next;
                Node.next = targetNode;
            }

            if ( Node.next != null ) {
                Node = Node.next;
                index++;
            }
            else {
                return;
            }
        }
    }

    public static void main(String[] args) {

        addNode(head, new node(2));
        addNode(head, new node(2));
        addNode(head, new node(4));
        addNode(head, new node(2));
        addNode(head, new node(5), 0, 0);

        //removeNode(head, 0, 0);

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
}
