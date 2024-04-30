public class Gimnasia24Matkonet {
    /*
    סעיף א: יש לכתוב פעולה חיצונית בשם wide, המקבלת מערך לא ריק של תורים לא ריקים מטיפוס
מספר שלם, ומחזירה תור של שרשרת חוליות מטיפוס מספר שלם, לפי הכללים הבאים:
     */
    public static Queue<Node> wide(Queue[] qs) {
        Queue<Node> rv = new Queue<Node>();
        boolean allQsAreEmpty = false;

        while(!allQsAreEmpty) {
            Node<Integer> node = null;

            // Keep a pointer to the last node in the chain
            Node<Integer> first = node;
            boolean foundNonEmptyQ = false;
            for (int i = 0; i < qs.length; i++) {
                if (!qs[i].isEmpty()) {
                    // Add at the end of the linked list
                    Integer value = (Integer)qs[i].remove();

                    // Use the following line in order to insert at head
                    //node = new Node<Integer>(value, node);

                    // Use the following lines in order to insert at tail as required
                    if (node == null)
                        first = node = new Node<Integer>(value);
                    else {
                        node.setNext(new Node<Integer>(value));
                        node = node.getNext();
                    }

                    foundNonEmptyQ = true;
                }
            }
            if (foundNonEmptyQ)
                rv.insert(first);
            else
                allQsAreEmpty = true;
        }

        return rv;
    }

    public static void printQueue(String s, Queue<Integer> q) {
        System.out.print(s + " ");
        Queue<Integer> tempQ = new Queue<Integer>();
        while(!q.isEmpty()) {
            Integer i = q.remove();
            tempQ.insert(i);
            System.out.print(i + " -> ");
        }
        System.out.println();

        // restore the Q
        while(!tempQ.isEmpty()) {
            q.insert(tempQ.remove());
        }
    }

    public static void printLinkedList(Node<Integer> node) {
        while (node != null) {
            System.out.print(node.getValue() + " -> ");
            node = node.getNext();
        }

        System.out.println();

    }

    public static void main(String[] arr) {
        // Initialize an array of Queues of Integers
        int arraySize = 4;
        Queue<Integer>[] qi = (Queue<Integer>[]) new Queue[arraySize];
        for (int i=0; i < arraySize; i++)
            qi[i] = new Queue<Integer>();

        // Populate the queues
        qi[0].insert(3);
        qi[0].insert(4);
        qi[0].insert(9);
        printQueue("Q0:", qi[0]);

        qi[1].insert(2);
        qi[1].insert(5);
        printQueue("Q1:", qi[1]);

        qi[2].insert(5);
        qi[2].insert(7);
        qi[2].insert(3);
        printQueue("Q2:", qi[2]);

        qi[3].insert(3);
        qi[3].insert(4);
        qi[3].insert(0);
        qi[3].insert(5);
        printQueue("Q3:", qi[3]);

        // call wide!
        Queue<Node> qn = wide(qi);

        System.out.println("\n*******\nResults:\n");

        while (!qn.isEmpty()) {
            printLinkedList(qn.remove());
        }
    }
}
