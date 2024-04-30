public class ExamRothberg202401 {

    // Q4
    public static String raz(String s)
    {
        System.out.println("s= " + s);
        if (s.length() == 0)
            return s;
        char c = s.charAt(s.length()-1);
        System.out.println("c= " + c);
        String st = raz(s.substring(0,  s.length()-1));
        System.out.println("st= " + st);
        if (c >='A' && c <= 'Z')
            return  c + st;
        return st;
    }

    // Q5
    public static boolean isIn(Queue<Integer> q, int num)
    {
        q.insert(null);
        boolean isIn = false;
        while(q.head() != null)
        {
            int n = q.remove();
            if (n == num)
                isIn = true;
            q.insert(n);
        }
        q.remove();
        return isIn;
    }

    // Yoav Smid's solution
    public static Queue<Integer>  orderYS(Queue<Integer> q1,
                                        Queue<Integer> q2) {
        Queue<Integer> q3 = new Queue<Integer>();
        int count = 0;
        boolean isIn1 = false, isIn2 = false;
        q1.insert(null);
        while(q1.head() != null) {
            int value1 = q1.remove();
            q2.insert(null);
            while (q2.head() != null) {
                int value2 = q2.remove();
                if (value1 == value2 && count == 0) {
                    isIn1 = true;
                    q3.insert(value1);
                    count++;
                } else if (value1 == value2 && count > 0) {
                    isIn2 = true;
                } else {
                    q2.insert(value2);
                }
            }

            q2.remove();

            if (!isIn1) {
                q1.insert(value1);
                isIn1 = false;
                isIn2 = false;
            }
        }

        q1.remove();
        while(!q1.isEmpty()) {
            q3.insert(q1.remove());
        }

        while(!q2.isEmpty()) {
            q3.insert(q2.remove());
        }

        return q3;
    }

    public static Queue<Integer>  order(Queue<Integer> q1,
                                        Queue<Integer> q2) {
        // We assume that both q1, q2 do not contain null.
        Queue<Integer> res = new Queue<Integer>();
        Queue<Integer> inQ1NotInQ2 = new Queue<Integer>();

        // Go through q1, insert to res every item which is in q2
        // every item that is not in q2, enter it to q1NotQ2.
        q1.insert(null);
        while (q1.head() != null) {
            Integer i = q1.remove();
            if (isIn(q2, i)) {
                // insert i to res only if i is not in res already
                if (!isIn(res, i))
                    res.insert(i);
            } else {
                inQ1NotInQ2.insert(i);
            }
        }

        // take out the null
        q1.remove();

        // insert all inQ1NotInQ2 items to res. No need to retain inQ1NotInQ2
        while (!inQ1NotInQ2.isEmpty())
            res.insert(inQ1NotInQ2.remove());

        // go through q2. Enter to res every item that is not in q1.
        // Notice we need to check that the item is not in res already b/c
        // it might be repeated in q2 and not be in q1
        // No need to retain q2.
        while (!q2.isEmpty()) {
            Integer i = q2.remove();
            if (!isIn(res, i))
                res.insert(i);
        }

        return res;
    }


    public static int streak(Queue<Character> q) {
        int c = 1;
        boolean ok = true;
        while(q.head()!=null && ok) {
            char n = q.remove();
            if (n == q.head())
                c++;
            else
                ok = false;
            q.insert(n);
        }

        return c;
    }

    public static boolean isUpED(Queue<Character> q) {
        q.insert(null);
        boolean Ok = true;
        while (q.head() != null) {
            int n1 = streak(q);
            int n2 = streak(q);
            if (n1 > n2)
                Ok = false;
        }
        q.remove();
        return Ok;
    }

    // Q6
    // Go through the q and find sequences i.e. chars which repeat.
    // Whenever a new sequence starts:
    //      compare the just ended sequence length (currentSequenceLength)
    //      to the previous sequence length (prevSequenceLength).
    //      if we prevSequenceLength <= currentSequenceLength,
    //          roll the just ended to be the prev one.
    //      otherwise return false

     public static boolean isUp(Queue<Character> q) {
        boolean rv = true;
        int prevSequenceLength = 0;
        int currentSequenceLength = 0;
        Character prevC = null;
        while (!q.isEmpty()) {
            Character c = q.remove();
            if ((prevC == null) || c.equals(prevC))
                // Either starting a new sequence or continuing a previous one
                currentSequenceLength++;
            else {
                // Sequence ended, c is a new guy. Compare length of the
                // sequence that just ended with the length of the previous one.
                if (currentSequenceLength <= prevSequenceLength) {
                    rv = false;

                    // no need to continue in such case
                    break;
                }

                // Roll current length to previous one.
                prevSequenceLength = currentSequenceLength;

                // Mark length of the current sequence as 1
                currentSequenceLength = 1;
            }

            // keep the previous char.
            prevC = c;
        }

        // test lengths of the last two sequences.
        if (currentSequenceLength <= prevSequenceLength)
            rv = false;

        return rv;
    }

    public static void fixUp(Queue<Character> q) {
        Queue<Character> tmpQ = new Queue<Character>();
        int prevSequenceLength = 0;
        int currentSequenceLength = 0;
        Character prevC = null;
        while (!q.isEmpty()) {
            Character c = q.remove();
            if ((prevC == null) || (c == prevC))
                // Either starting a new sequence or continuing a previous one
                currentSequenceLength++;
            else {
                // Sequence ended, c is a new guy. Compare length of the
                // sequence that just ended with the length of the previous one.
                while (currentSequenceLength <= prevSequenceLength) {
                    tmpQ.insert(prevC);
                    currentSequenceLength++;
                }

                // Roll current length to previous one.
                prevSequenceLength = currentSequenceLength;

                // Mark length of the current sequence as 1
                currentSequenceLength = 1;
            }

            tmpQ.insert(c); // # 1

            // keep the previous char.
            prevC = c;
        }

        while (currentSequenceLength <= prevSequenceLength) {
            tmpQ.insert(prevC);
            currentSequenceLength++;
        }

        // make q great again (restore q)!
        tmpQ.insert(null);
        while(tmpQ.head() != null) {
            q.insert(tmpQ.remove());
        }
    }

    public static void testQ4() {
        System.out.println(raz("aBCdE"));
    }
    public static void testQ5() {
        Queue<Integer> q1 = new Queue<Integer>();
        Queue<Integer> q2 = new Queue<Integer>();

        q1.insert(4);
        q1.insert(5);
        q1.insert(6);
        q2.insert(5);
        q2.insert(7);

        System.out.println(orderYS(q1, q2));
    }
    public static void testQ6() {
        Queue<Character> q = new Queue<Character>();
        q.insert('z');
        //q.insert('z');
        //q.insert('z');
        q.insert('b');
        q.insert('b');
        q.insert('k');
        q.insert('k');
        q.insert('k');
        q.insert('k');
        System.out.println(isUpED(q));
        //fixUp(q);
        //System.out.println(q);
    }


    public static void main(String[] arr) {

        // testQ4();
        //testQ5();
        testQ6();
    }
}
