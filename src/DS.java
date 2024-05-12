public class DS {

    public static Node<Integer> odds(Node<Integer> lst) {
        Node<Integer> rv = null;

        // נעבור על הרשימה וניקח איבר לא, איבר כן
        while (lst != null) {
            if (lst.hasNext()) {
                lst = lst.getNext();
                if (rv == null)
                    rv = lst;
                else
                    rv.setNext(lst);
                // נדלג על האיבר במקום הזוגי
                lst = lst.getNext();
            }
        }

        return rv;
    }




    public static int maxZeroes(Node<Integer> lst) {

        // default value
        int rv =0;
        int numOfZerosInRv=0;

        // Go through the list and find the number with most zeroes
        while (lst != null) {
            int numOfZeroes = 0; //zeroes(lst.getValue());

            if (numOfZeroes > numOfZerosInRv) {
                // update the return value
                rv = lst.getValue();
                numOfZerosInRv = numOfZeroes;
            }

            lst = lst.getNext();
        }
        return rv;
    }

    public static boolean isInt(double d) {
        if ((int)(d) == d)
            return true;
        else
            return false;
    }


    // Auxiliary function
    public static void printList(Node<Integer> lst) {
        // נעבור על הרשימה איבא איבר ונדפיס את ערכו
        while(lst != null) {
            System.out.print(lst.getValue() + " -> ");
            lst = lst.getNext();
        }

        // נרד שורה לאחר האיבר האחרון ברשימה
        System.out.println();
    }







    public static void doubleList(Node<Integer> lst) {

        // נעבור כל איברי הרשימה
        while (lst != null) {

            // עבור כל חוליה נייצר חוליה חדשה בעלת ערך זהה לזה של החוליה הנוכחית
            // החוליה החדשה תצביע על החוליה הבאה אחרי החוליה הנוכחית
            Node<Integer> n = new Node<Integer>(lst.getValue(), lst.getNext());

            // החוליה המקורית תצביע על החוליה החדשה
            lst.setNext(n);

            // נשנה את המצביע הנוכחי לחוליה הבאה ברשימה המקורית (נדלג על החוליה החדשה)
            lst = lst.getNext().getNext();
        }
    }





    public static Node<Integer> reverseListChatGPT(Node<Integer> head) {
        // Base case: If the list is empty or has only one element
        if (head == null || head.getNext() == null) {
            return head;
        }

        // Recursively reverse the rest of the list
        Node<Integer> reversedHead = reverseListChatGPT(head.getNext());

        // Reverse the current node's link
        head.getNext().setNext(head);
        head.setNext(null);

        // Return the new head of the reversed list
        return reversedHead;
    }


    public static Node reverseList(Node<Integer> lst) {
        if (lst.getNext() != null) {
            Node<Integer> reverseRestOfTheList = reverseList(lst.getNext());

            // Now we want to put "lst" after "reverseRestOfTheList"
            // make tmp point at the last Node of reverseRestOfTheList
            Node<Integer> tmp = reverseRestOfTheList;
            while (tmp.hasNext()) {
                tmp = tmp.getNext();
            }

            // put lst after tmp
            tmp.setNext(lst);
            lst.setNext(null);

            // since we return lst, we should make lst point to the new lst
            lst = reverseRestOfTheList;
        }

        return lst;
    }










    public static void main(String[] args)
    {

        Node<Integer> n1 = new Node<Integer>(7);
        Node<Integer> n2 = new Node<Integer>(6, n1);
        Node<Integer> lst = new Node<Integer>(5, n2);
        System.out.println("\n\n----- BEFORE -----");
        printList(lst);

        //lst =  reverseList(lst);
        lst =  reverseListChatGPT(lst);
        // doubleList(lst);

        System.out.println("\n\n----- AFTER -----");
        printList(lst);

    }

}
