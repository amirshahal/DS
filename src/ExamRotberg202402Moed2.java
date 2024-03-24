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

    public static void mergeToQ(Queue<Integer> q, Node<Integer> lst) {
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

    public static void mergeToList(Queue<Integer> q, Node<Integer> lst) {
        // insert a Q item on every other list item resulting with:
        // List: item from List, item from Q, item from List, item from Q, item from List, etc.
        // In case Q is shorter or equal in length to List, we are done.
        // In case Q is longer than List, add the remaining Q items at the end of the List.

        Node<Integer> n1;
        while(lst.hasNext() && !q.isEmpty()) {
            n1 = new Node<Integer>(q.remove(), lst.getNext());
            lst.setNext(n1);
            lst = lst.getNext().getNext();
        }

        // Add the remaining q items at the end of the list
        while (!q.isEmpty()) {
            n1 = new Node<Integer>(q.remove(), lst.getNext());
            lst.setNext(n1);
            lst = lst.getNext();
        }

    }

    public static void callMergeToQMergeToList() {
        Node<Integer> lst = new Node<Integer>(1,
                new Node<Integer>(2,
                        new Node<Integer>(4,
                                new Node<Integer>(9))));

        Queue<Integer> q = new Queue<Integer>();
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
        System.out.println();
    }

    public static boolean validQ(Queue<Patient> q) {
        // Q is valid has age in reverse sorted order ("ole")
        // with NO two adjacent patients who did not reserve appointments
        boolean rv = true; // so far no problems found :-)
        int prevPatientAge = -1;
        boolean prevPatientReserved = true;

        // Add a marker for the end of Q
        q.insert(null);

        while(q.head() != null) {
            Patient p = q.remove();

            // p becomes last now
            q.insert(p);

            // check age condition
            int pAge = p.getAge();
            if (pAge <= prevPatientAge)
                rv = false;

            // check reserved condition
            boolean pReserved = p.isReserved();
            if (!pReserved && !prevPatientReserved)
                rv = false;

            // update values for next round
            prevPatientAge = pAge;
            prevPatientReserved = pReserved;
        }

        q.remove(); // take out the null
        return rv;
    }

    public static void notReservedLast(Queue<Patient> q) {
        boolean lastWasFalse = false;
        Queue<Patient> shouldBeMovedToTheEnd = new Queue<Patient>();

        // insert a marker for end of Q
        q.insert(null);

        // run until we hit the marker
        while (q.head() != null) {
            Patient p = q.remove();

            if (lastWasFalse && !p.isReserved()) {
                // in this case we want to move p to the end
                shouldBeMovedToTheEnd.insert(p);
            }
            else {
                // put p back at the end
                q.insert(p);
            }

            // keep record of the previous patient reserved status
            lastWasFalse = !p.isReserved();
        }

        // remove the marker
        q.remove();

        // Add the "moved to the end patients"
        while (!shouldBeMovedToTheEnd.isEmpty()) {
            q.insert(shouldBeMovedToTheEnd.remove());
        }
    }

    public static void testQ5() {
        Patient p1 = new Patient("Alice", 88, true);
        Patient p2 = new Patient("Bob", 80, false);
        Patient p3 = new Patient("Charlie", 77, false);
        Patient p4 = new Patient("David", 60, false);
        Patient p5 = new Patient("Esmeralda", 55, true);
        Patient p6 = new Patient("Flora", 44, true);

        Queue<Patient> patientQ = new Queue<Patient>();
        patientQ.insert(p1);
        patientQ.insert(p2);
        patientQ.insert(p3);
        patientQ.insert(p4);
        patientQ.insert(p5);
        patientQ.insert(p6);

        System.out.println("------ BEFORE -----");
        System.out.println(patientQ);

        //System.out.println(validQ(patientQ));
        notReservedLast(patientQ);

        System.out.println("------ AFTER -----");
        System.out.println(patientQ);
    }


    public static void main(String[] arr) {
        // callSod();
        //callMergeToQMergeToList();
        testQ5();
    }

}
