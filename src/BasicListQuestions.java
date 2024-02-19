public class BasicListQuestions {

     // 1. כתבו פונקציה המקבלת רשימה של שלמים ומדפיסה אץ הרשימה
    public static void printList(Node<Integer> lst) {
        // נעבור על הרשימה איבא איבר ונדפיס את ערכו
        while(lst != null) {
            System.out.print(" -> " + lst.getValue());
            lst = lst.getNext();
        }

        // נרד שורה לאחר האיבר האחרון ברשימה
        System.out.println("");
    }

    // 2. כתבו םונקציה המקבלת רשימה ומדפיסה אותה בסדר הפוך
    public static void printListBackwards(Node<Integer> lst) {
        if(lst != null) {

            // קריאה רקרוסיבית לרשימה שמתחילה באיבר הבא של הרשימה הנוכחית
            printListBackwards(lst.getNext());
        }

        // לכאן נגיע לאחר שקראנו רקורסיבית לכל האיברים ברשימה
        // בפעה הראשונה נגיע לכאן כאשר lst==null
        // בפעם השניה נגיע לכאן כאשר list מצביע לאיבר האחרון
        // בפעם השלישית נגיע לפה כאשר lst מצביע לאיבר הלפני אחרון
        // וכן הלאה עד שנגיע לכאן כאשר lst מצביע לאיבר הראשון בסדרה
        if (lst != null)
            System.out.print(" -> " + lst.getValue());
    }

    // 3 כתבו פונקציה המקבלת רשימה ומדפיסה את סכום האיברים שברשימה
    public static int getSum(Node<Integer> lst) {
        // נעבור על כל איברי הרשימה ונסכום אותם למשתנה rv
        int rv = 0;
        while(lst != null) {
            rv += lst.getValue();
            lst = lst.getNext();
        }

        return rv;
    }

    public static void main(String[] arr) {
        Node<Integer> n1 = new Node<Integer>(3);
        Node<Integer> n2 = new Node<Integer>(2, n1);
        Node<Integer> lst = new Node<Integer>(1, n2);

        //printList(lst);
        //printListBackwards(lst);
        System.out.println(getSum(lst));

    }
}
