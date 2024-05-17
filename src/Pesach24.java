public class Pesach24 {
    public static String secret(Queue<String> q) {
        String st1 = q.remove();
        if (q.isEmpty())
            return st1;

        String st2 = secret(q);
        if (st1.length() < st2.length()) {
            q.insert(st2);
            return st1;
        }
        else {
            q.insert(st1);
            return st2;
        }
    }

    public static Node<String> topSecret(Queue<String> q) {
        if (q.isEmpty())
            return null;

        String st = secret(q);
        return new Node<String>(st, topSecret(q));
    }

    public static void printLinkedList(Node <String> n) {
        while (n != null) {
            System.out.print(n.getValue() + " -> ");
            n = n.getNext();
        }

        System.out.println("");
    }

    // Question 4
    public static Queue<Integer> Question4(Queue<Integer> q) {
        Queue<Integer> rv = new Queue<Integer>();

        Integer last = q.remove();
        Integer currentSum = last;
        while (!q.isEmpty()) {
            Integer current = q.remove();
            if (current > last)
                // in this case the q is still "ole". Add the current number to the
                // running sum
                currentSum += current;
            else {
                // Found a non "ole" number. Add the running sum so far to the new list
                // and reset the current sum
                rv.insert(currentSum);
                currentSum = current;
            }

            // update the last seen to be the curent one
            last = current;
        }

        // still need to add the "left over"
        rv.insert(currentSum);
        return rv;
    }


    public static Queue<Integer> ascendingAmountQueue(Queue<Integer> q)
    {
        int sum = 0, value, nextValue;
        Queue<Integer> finalQ = new Queue<Integer>();//התור שיוחזר בסוף
        while(!q.isEmpty())//לולאה עד שהתור יהיה ריק
        {
            value = q.remove();//הערך הראשון בתור
            if(!q.isEmpty())//אם התור לא ריק ניתן להוציא גם את הערך השני בתור /הראשון לאחר ההוצאה
            {
                nextValue = q.head();//הערך הראשון בתור לאחר ההוצאה
                if(nextValue <= value)//אם הערך הראשון שהוצאנו גדול או שווה אז אין רצף עולה
                {
                    sum += value;//מכניסים את הערך הראשון לסכום הכולל כך שגם אם במקרה שהיה רצף לפני סכום כל המספרים יהיו
                    finalQ.insert(sum); //הכנסת הסכום שהצטבר
                    sum = 0;//איפוס הסכום לערך הבא
                }
                else
                {
                    sum += value;//כל עוד יש רצף  נכניס את הסכומים של הערך הראשון(הערך האחרון ברצף יתווסך לסכום למעלה)
                }
            }
            else//אם התור ריק
            {
                sum += value;//יתווסף הערך האחרון בתור שהתקבל לסכום של הרצף/ל0 במקרה שלפני לא היה רצף עולה
                finalQ.insert(sum);  //הכנסת הסכום לתור שהצטבר
            }
        }
        return finalQ;//החזרת התור הסופי
    }
    public static void main(String[] arr) {
        /*
        Queue<String> q = new Queue<String>();
        q.insert("hello");
        q.insert("world");
        q.insert("hi");
        q.insert("bye");

        System.out.println(q);
        //System.out.println(secret(q));



        //System.out.println(topSecret(q));
        printLinkedList(topSecret(q));

        System.out.println(q);

         */

        Queue<Integer> q = new Queue<Integer>();
        // 7,2,4,8,20,18,19,20,20,5,-3,0,9
        q.insert(7);
        q.insert(2);
        q.insert(4);
        q.insert(8);
        q.insert(20);
        q.insert(18);
        q.insert(19);
        q.insert(20);
        q.insert(20);
        q.insert(5);
        q.insert(-3);
        q.insert(0);
        q.insert(9);

        System.out.println(q);
        //System.out.println(Question4(q));
        System.out.println(ascendingAmountQueue(q));
    }
}
