public class ExamRotberg202402 {


    // Q4
    public static void sod(Node<Integer> n) {
        if (n==null || !n.hasNext())
            return;

        Node<Integer> p = n.getNext();
        n.setNext(p.getNext());
        p.setNext(null);
        sod(n.getNext());
    }

    public static void testQ4() {
        Node<Integer> n4 = new Node<Integer>(4);
        Node<Integer> n3 = new Node<Integer>(3, n4);
        Node<Integer> n2 = new Node<Integer>(2, n3);
        Node<Integer> n = new Node<Integer>(1, n2);
        //System.out.println(n1);
        sod(n);
    }

    public static int size(Node<Integer> n) {
        int rv = 0;
        if (n != null)
            rv = 1;
        while(n.hasNext()) {
            n = n.getNext();
            rv++;
        }

        return rv;
    }

    public static Node<Integer> spaces(Node<Integer> lst, int n) {
        // Basically we need to go through the list and get the 1/n, 2/n, ... n/n
        // nodes and connect them to a new list which is returned.
        // If the list size is 12 and n=3, we want to take:
        // item #4 (12/3), item #8 (2*12/3), item # 12(3*12/3).
        // Therefore, all we need is to calculate "the step" (4 in the example above)
        // and take every step's item (4th item in this example).
        Node<Integer> rv = null;
        Node<Integer> last = null;
        int listSize = size(lst);
        int step = listSize / n;

        int currentStep = 1;
        while (lst.hasNext()) {
            while (currentStep < step) {
                lst = lst.getNext();
                currentStep++;
            }

            currentStep = 0;

            // We reached a desired item. Take it!
            if (rv == null) {
                rv = lst;
                last = rv;
            } else {
                last.setNext(lst);
                last = lst;
            }
        }

        return rv;
    }

    public static int retrieve(Node<Integer> lst, int n) {
        // assume s = size(lst) for example 10.
        // assume i = 2
        // in this case we need to return the 10/2's item.

        int listSize = size(lst);
        int indexWanted = listSize / n;
        int rv = 0;

        // Go through the list until hitting the indexWanted item
        while (indexWanted > 0) {
            rv = lst.getValue();
            lst = lst.getNext();
            indexWanted--;
        }

        return rv;
    }

    public static void printList(Node<Integer> lst) {
        while (lst != null) {
            System.out.print(lst.getValue() + " -> ");
            lst = lst.getNext();
        }

        System.out.println("");
    }

    public static void testQ5() {
        Node<Integer> n8 = new Node<Integer>(8);
        Node<Integer> n7 = new Node<Integer>(7, n8);
        Node<Integer> n6 = new Node<Integer>(6, n7);
        Node<Integer> n5 = new Node<Integer>(5, n6);
        Node<Integer> n4 = new Node<Integer>(4, n5);
        Node<Integer> n3 = new Node<Integer>(3, n4);
        Node<Integer> n2 = new Node<Integer>(2, n3);
        Node<Integer> n = new Node<Integer>(1, n2);

        //System.out.println(retrieve(n, 2));
        printList(n);
        printList(spaces(n, 8));
    }


    public static int zeros(int n) {
        // מקרה של ספרת אחדות בלבד
        if (n < 10) {
            if (n == 0)
                return 1;
            else
                return 0;
        }

        // מקרה שיש יותר מאשר ספרת אחדות
        // נברר אם האם ספרת האחדות היא אפס
        int lastIsZero = -1;
        if (n % 10 == 0)
            lastIsZero = 1;
        else
            lastIsZero = 0;
        // נוסיף את התוצאה של שאר הספרות
        return lastIsZero + zeros(n/10);
    }

    public static Integer maxZeros(Node<Integer> lst1, Node<Integer> lst2) {
        // Return the number of zeros in lst1 or in lst2 that has most zeros
        // lst1 and lst2 have the same length

        // מקרה של האיבר האחרון בשתי הרשימות
        if (!lst1.hasNext() && !lst2.hasNext()) {
            int zeros1 = zeros(lst1.getValue());
            int zeros2 = zeros(lst2.getValue());
            return (zeros1 > zeros2)? lst1.getValue() : lst2.getValue();
        }
        else {
            // מקרה של יותר מאיבר אחד בשתי הרשימות
            Integer num1 = lst1.getValue();
            Integer num2 = lst1.getValue();
            Integer maxZerosRest = maxZeros(lst1.getNext(), lst2.getNext());
            int zerosNum1 = zeros(num1);
            int zerosNum2 = zeros(num2);
            int zerosRest = zeros(maxZerosRest);

            // נבדוק את 3 המקרים הבאים:
            // 1. הכי הרבה אפסים במספר הנוכחי ברשימה הראשונה.
            // 2. הכי הרבה אפסים במספר הנוכחי ברשימה השנייה.
            // 3. הכי הרבה אפסים במספר כלשהו בהמשך הרשימות (קריאה רקורסיבית)

            // הכי הרבה אפסים במספר num1
            if (zerosNum1 >= zerosNum2 && zerosNum1 >= zerosRest)
                return num1;

            // הכי הרבה אפסים במספר num2
            if (zerosNum2 >= zerosNum1 && zerosNum2 >= zerosRest)
                return num2;

            // הכי הרבה אפסים בהמשך הרשימה
            if (zerosRest >= zerosNum1 && zerosRest >= zerosNum2)
                return maxZerosRest;

            // if we reached here we are lost!
            return -1;
        }
    }

    public static void testQ6() {

        /*
        System.out.println(zeros(123404));
        System.out.println(zeros(123400));
        System.out.println(zeros(120404));
        System.out.println(zeros(0404));
         */

        Node<Integer> n4 = new Node<Integer>(400);
        Node<Integer> n3 = new Node<Integer>(321, n4);
        Node<Integer> n2 = new Node<Integer>(2020200, n3);
        Node<Integer> n = new Node<Integer>(1, n2);

        Node<Integer> m4 = new Node<Integer>(4010000);
        Node<Integer> m3 = new Node<Integer>(301, m4);
        Node<Integer> m2 = new Node<Integer>(20200, m3);
        Node<Integer> m = new Node<Integer>(1, m2);

        System.out.println(maxZeros(n, m));
    }

    public static void main(String[] arr) {
        // testQ4()
        // testQ5();
        testQ6();
    }
}
