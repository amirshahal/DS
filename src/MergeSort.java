public class MergeSort {

    /*
    כיתבו פעולה MergeSort המקבלת שתי רשימות של מספרים ממוינים חיוביים (מהקטן לגדול)
    ומחזירה רשימה אחת של מספרים ממוינים (מהטן לגדול).
    הרשימה המוחזרת תכיל את כל המספרים הנמצאים באחד התורים
        כלומר אורכה יהיה שווה בדיוק לסכום האורכים של שתי רשימות הקלט
     */

    public static Node<Integer> addNumberAtTheEnd(Node<Integer> n, int x) {
        // פעולה זו מוסיפה את המספר x כחוליה אחרונה בשרשרת n
        Node<Integer> head = n;
        Node<Integer> tmp = new Node<Integer>(x);
        if (n == null) {
            // n is empty - return the nw Node (only)
            head = tmp;
        }
        else {
            // n is not empty, set n as the last node and add the new node after n.
            while(n.hasNext())
                n = n.getNext();

            n.setNext(tmp);
        }

        return head;
    }

    public static Node<Integer> MergeSort(Node<Integer> lst1, Node<Integer> lst2) {
        Node<Integer> rv = null;

        // נמשיך לרוץ על 2 הרשימות כל עוד יש לפחות באחת מהן איברים נוספים.
        while(lst1 != null || lst2 != null) {

            // מקרה ראשון, רשימה 1 ריקה
            if (lst1 == null) {
                while (lst2 != null) {
                    rv = addNumberAtTheEnd(rv, lst2.getValue());
                    lst2 = lst2.getNext();
                }
            }

            // מקרה שני, רשימה 2 ריקה
            if (lst2 == null) {
                while (lst1 != null) {
                    rv = addNumberAtTheEnd(rv, lst1.getValue());
                    lst1 = lst1.getNext();
                }
            }

            // מקרה שלישי - שתי הרשימות לא ריקות.
            // יש לקחת את האיבר הקטן מבין שני האיברים שבראש כל אחת מהרשימות
            if (lst1 != null && lst2 != null) {
                if (lst1.getValue() <= lst2.getValue()) {
                    rv = addNumberAtTheEnd(rv, lst1.getValue());
                    lst1 = lst1.getNext();
                } else {
                    rv = addNumberAtTheEnd(rv, lst2.getValue());
                    lst2 = lst2.getNext();
                }
            }
        }

        return rv;
    }

    public static void printList(Node<Integer> lst) {
        // פעולה זו מדפיסה למסך את האיברים ברשימה
        while(lst != null) {
            System.out.print(lst.getValue() + " -> ");
            lst = lst.getNext();
        }

        System.out.println("");
    }

    public static void main(String[] arr) {
        Node<Integer> n1 = new Node<Integer>(9);
        Node<Integer> n2 = new Node<Integer>(8, n1);
        Node<Integer> lst1 = new Node<Integer>(7, n2);
        printList(lst1);

        Node<Integer> m1 = new Node<Integer>(12);
        Node<Integer> m2 = new Node<Integer>(8, m1);
        Node<Integer> m3 = new Node<Integer>(4, m2);
        Node<Integer> m4 = new Node<Integer>(3, m3);
        Node<Integer> m5 = new Node<Integer>(2, m4);
        Node<Integer> lst2 = new Node<Integer>(1, m5);
        printList(lst2);

        Node<Integer> merged = MergeSort(lst1, lst2);
        printList(merged);
    }
}
