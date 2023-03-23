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
        else {
            while ( Node.next != null && Node.next.value == removeValue ) {
                Node.next = Node.next.next;
            }
        }

        if ( Node.next != null ) {
            removeNode(Node.next, removeValue);
        }

    }

    public static void removeNode(node Node, int index, int removeIndex) {
        if ( Node.equals(head) && index == removeIndex ) {
            head = head.next;
        }
        else if ( index == removeIndex ) {
            Node.next = Node.next.next;
        }else {
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

    public static void addNode(node Node, node targetNode, int index, int targetIndex) {
        if ( index+1 == targetIndex ) {
            targetNode.next = Node.next;
            Node.next = targetNode;
        }
        else {
            addNode(Node.next, targetNode, index + 1, targetIndex);
        }
    }

    public static void main(String args[]) {

        for ( int i = 2; i <= 10; i++ ) {
            addNode(head, new node(i));
        }

        addNode(head, new node(10), 0, 10);
        //removeNode(head, 10);

        //for ( int i = 1; i <= 10; i++ ) {
            removeNode(head, 10);

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
        //}

        /*Scanner sc = new Scanner(System.in);
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
        }*/
    }
}
