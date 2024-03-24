public class ExamRotberg202402Moed2 {
    public static void sod(Node<Integer> lst)
    {
        if (lst == null || !lst.hasNext())
            return ;
        int x = lst.getNext().getValue() - lst.getValue();
        Node<Integer> n=new Node<Integer>(x, lst.getNext());
        lst.setNext(n);
        sod(lst.getNext().getNext());
    }

    public static void callSod() {
        Node<Integer> lst = new Node<Integer>(1,
                new Node<Integer>(2,
                        new Node<Integer>(4,
                                new Node<Integer>(10))));
        sod(lst);
        System.out.println(lst);
    }

    public static void mergeToQ(Queue q, Node lst) {
        // insert a list item on every other q item resulting with:
        // Q: item from Q, item from List, item from Q, item from List, etc.
        // In case list is shorter or equal in length to Q, we are done.
        // In case list is longer than Q, add the remaining list items at the end of the Q.
        q.insert(null);
        while (q.head() != null) {
            q.insert(q.remove());
            if (lst!= null) {
                q.insert(lst.getValue());
                lst = lst.getNext();
            }
        }

        q.remove();
        while(lst != null) {
            q.insert(lst.getValue());
            lst = lst.getNext();
        }
    }

    public static void mergeToList(Queue q, Node lst) {
        // insert a Q item on every other list item resulting with:
        // List: item from List, item from Q, item from List, item from Q, item from List, etc.
        // In case Q is shorter or equal in length to List, we are done.
        // In case Q is longer than List, add the remaining Q items at the end of the List.

        Node n1;
        while(lst.hasNext() && !q.isEmpty()) {
            n1 = new Node(q.remove(), lst.getNext());
            lst.setNext(n1);
            lst = lst.getNext().getNext();
        }

        // Add the remaining q items at the end of the list
        while (!q.isEmpty()) {
            n1 = new Node(q.remove(), lst.getNext());
            lst.setNext(n1);
            lst = lst.getNext();
        }

    }

    public static void callMergeToQ() {
        Node<Integer> lst = new Node<Integer>(1,
                new Node<Integer>(2,
                        new Node<Integer>(4,
                                new Node<Integer>(9))));

        Queue q = new Queue<Integer>();
        q.insert(10);
        q.insert(20);
        //q.insert(30);
        //q.insert(40);
        //q.insert(50);


        boolean testMergeToQ = false;
        if (testMergeToQ) {
            System.out.println("------ BEFORE -----");
            System.out.println(q);
            printList(lst);

            mergeToQ(q, lst);

            System.out.println("------ AFTER -----");
            System.out.println(q);
        }
        else {
            // test testMergeToList

            System.out.println("------ BEFORE -----");
            System.out.println(q);
            printList(lst);

            mergeToList(q, lst);

            System.out.println("------ AFTER -----");
            printList(lst);

        }


    }

    // Auxiliary function
    public static void printList(Node<Integer> lst) {
        // נעבור על הרשימה איבא איבר ונדפיס את ערכו
        while(lst != null) {
            System.out.print(" -> " + lst.getValue());
            lst = lst.getNext();
        }

        // נרד שורה לאחר האיבר האחרון ברשימה
        System.out.println("");
    }


    public static void main(String[] arr) {
        // callSod();
        callMergeToQ();
    }

}
