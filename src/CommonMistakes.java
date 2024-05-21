public class CommonMistakes {

    // Find the problem and fix it!
    public static boolean isOleProblem1(Node<Integer> lst) {
        boolean rv = true;  // return value
        while(lst != null) {
            if (lst.getValue() >= lst.getNext().getValue())
                rv = false;

            lst = lst.getNext();
        }

        return rv;
    }

    // Find the problem and fix it!
    public static boolean isOleProblem2(Node<Integer> lst) {
        boolean rv = true;  // return value
        while(lst != null && lst.hasNext()) {
            if (lst.getValue() < lst.getNext().getValue())
                rv = false;
            else
                rv = false;
        }

        return rv;
    }

    // This is the right best solution IMHO,
    // Making the loop as simple as possible and keeping the required data from on each iteration.
    // The same logic should work for every similar question.
    public static boolean isOleNoProblem(Node<Integer> lst) {
        boolean rv = true;  // return value
        if (lst != null) {

            // last keeps the last value we ran into
            Integer last = lst.getValue();
            lst = lst.getNext();
            while (lst != null) {
                if (lst.getValue() <= last)
                    rv = false;
                // technically it is ok to break the loop here, but it is really needed
                // and since there is always a debate whether "break" is acceptable
                // in the Bagrut exam, I would rather avoid it just in case


                // keep the last value we ran into
                last = lst.getValue();

                // mve lst one step forward in the chain
                lst = lst.getNext();
            }
        }

        return rv;
    }


    public static void main(String[] arr) {

        Node<Integer> lst = new Node<Integer>(1);

        // tmp points to the end of the list, lst points to its head
        Node<Integer> tmp = lst;
        tmp.setNext(new Node<Integer>(20));
        tmp = tmp.getNext();
        tmp.setNext(new Node<Integer>(3));

        //boolean isOle1 = isOleProblem1(lst);
        //boolean isOle2 = isOleProblem2(lst);
        boolean isOle3 = isOleNoProblem(lst);

        System.out.println(isOle3);
    }
}
