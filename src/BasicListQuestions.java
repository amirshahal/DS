public class BasicListQuestions {

     // 1. כתבו פונקציה המקבלת רשימה של שלמים ומדפיסה את הרשימה
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

    public static Node<Integer> putInOrderedList(Node<Integer> lst, int num) {
        // נתון שהרשימה lst היא ממוינת מקטן לגדול. יש להכניס את num למקום הנכון ברשימה
        // במידה ו-num כבר נמצא, אין להכניס אותו שוב - כלומר לא צריך לעשות כלום

        Node<Integer> rv = lst;

        // ראשית נבדוק אם צריך להכניס את num בראש הרשימה
        if (num < lst.getValue()) {

            // נייצר חוליה חדשה המצביעה לרשימה הקיימת
            Node<Integer> nodeForNum = new Node<Integer>(num, lst);

            // נעביר את המצביע על ראש הרשימה, להצביע על האיבר החדש שהוספנו בראש הרשימה
            rv = nodeForNum;
        }
        else {
            boolean stillNeedToAdd = true;
            while(lst.hasNext() && lst.getNext() != null) {
                Integer valueOfNext = lst.getNext().getValue();
                if (valueOfNext < num) {

                    // גם האיבר הבא קטן מ-num ולכן נקדם את lst לאיבר הבא ברשימה
                    lst = lst.getNext();
                } else if (valueOfNext == num) {
                    // במקרה זה נסמן שלא צריך להוסיף ונצא מהפונקציה ללא שום שינוי
                    stillNeedToAdd = false;
                    break;
                } else if (valueOfNext > num) {
                    // במקרה הזה צריך להכניס את num בין החוליה עליה מצביע num לחוליה הבאה

                    // ניצור חוליה חדשה שהמשכה הוא החוליה שאחרי החוליה הנוכחית
                    Node<Integer> nodeForNum = new Node<Integer>(num, lst.getNext());

                    // נחבר את lst ע ידי זה שנקבע את החוליה החדשה כמהשכה של lst
                    lst.setNext(nodeForNum);
                    stillNeedToAdd = false;
                }
            }

            if (stillNeedToAdd) {
                // זהו המקרה בו הגענו לקצה הרשימה ועדיין לא הוספנו את המספר החדש. נוסיף אותו כאיבר אחרון
                Node<Integer> nodeForNum = new Node<Integer>(num);
                lst.setNext(nodeForNum);
            }
        }

        return rv;
    }

    public static void main(String[] arr) {
        Node<Integer> n1 = new Node<Integer>(30);
        Node<Integer> n2 = new Node<Integer>(20, n1);
        Node<Integer> lst = new Node<Integer>(10, n2);

        //printList(lst);
        //printListBackwards(lst);
        //System.out.println(getSum(lst));

        printList(lst);
        lst = putInOrderedList(lst, 0);
        printList(lst);

        lst = putInOrderedList(lst, 40);
        printList(lst);

        lst = putInOrderedList(lst, 25);
        printList(lst);

    }
}
