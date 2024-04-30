public class Matkonet2024Rotberg {

    public static int maMa(int[] a, int n) {
        if (n == 1)
            return a[0];

        int temp = maMa(a, n - 1);
        if (a[n - 1] < temp)
            return a[n - 1];
        else
            return temp;
    }

    public static void mia(Node<int[]> t) {
        if (t != null) {
            mia(t.getNext());
            int x  = (maMa(t.getValue(), t.getValue().length));
            System.out.println(x);
            t.getValue()[0] = x;
        }
    }

    public static void printLinkedList(Node <int[]> n) {
        while (n != null) {
            int[] arr = n.getValue();
            System.out.print("[");
            for (int i = 0; i < arr.length;i++)
                System.out.print("" + arr[i] + ",");
            System.out.println("]");
            n = n.getNext();
        }
    }

    public static void run4a() {
        int[] a = {20, 9, 1, 6, 3};
        System.out.println(maMa(a, a.length));
    }

    public static void run4b() {
        int[] t1 = {6, 6};
        int[] t2 = {2, 8, 5 ,1};
        int[] t3 = {22, 5, 15};

        Node<int[]> t33 = new Node<int[]>(t3);
        Node<int[]> t22 = new Node<int[]>(t2, t33);
        Node<int[]> t = new Node<int[]>(t1, t22);

        printLinkedList(t);
        mia(t);
        printLinkedList(t);
    }

    public static boolean trio(Queue<String> q, int num)
    {
        int countShorterThanNum = 0;// num - מספר האיברים שקטנים מ
        int countStringsInQ = 0;//מספר האיברים הכולל בתור
        q.insert(null);
        while(q.head() != null)
        {
            countStringsInQ++;
            String s = q.remove();
            q.insert(s);
            if(s.length() < num)
                countShorterThanNum++;
        }
        q.remove();
        boolean rv = false;
        if (countStringsInQ <= 3 && countStringsInQ == countShorterThanNum)
            rv = true;

        if (countStringsInQ > 3 && countShorterThanNum >= 3)
            rv = true;

        return rv;
    }

    public static boolean completeTrio(Queue<String> q)
    {
        while(!q.isEmpty())
        {
            String s = q.remove();
            if(!trio(q,s.length()))
                return false;
        }
        return true;
    }

    // Question 5a:
    public static String last(Node<String> lst) {
        Node<String> pos = lst;
        while (pos.hasNext()) {
            pos = pos.getNext();
        }

        return pos.getValue();
    }

    // Question 5b
    public static Queue<Node<String>>order(Queue<Node<String>> q)
    {
        Queue<Node<String>> result = new Queue<Node<String>>();
        Node<String> tmp = q.remove();
        result.insert(tmp);
        String s = last(tmp);
        while(!q.isEmpty())
        {
            if(q.head().getValue().equals(s))
            {
                // q.head() now has the next Linked List we want to add.
                tmp = q.remove();
                result.insert(tmp);
                s = last(tmp);
            }
            q.insert(q.remove());
        }
        return result;
    }


    // Question 6a
    public static boolean valid(Node<Flag> list)
    {
        if(list == null)
            return true;
        String lastColor = list.getValue().getColor();
        int lastIndex = list.getValue().getIndex();
        list = list.getNext();
        while(list != null)
        {
            if(list.getValue().getColor().equals(lastColor))
                return false;
            if(list.getValue().getIndex() != lastIndex + 1)
                return false;
            lastColor = list.getValue().getColor();
            lastIndex = list.getValue().getIndex();
            list = list.getNext();
        }
        return true;
    }

    // Question 6b
    public static void combine(Node<Flag> flags1, Node<Flag> flags2)
    {
        // Notice it is given that both lists are not empty
        while(flags1 != null)
        {
            if(flags2 == null)
                // all flags2 items were merged into flag1, we're done.
                return;
            if(flags2.getValue().getIndex() == flags1.getValue().getIndex() + 1)
            {
                Node<Flag> tmp = flags2; // this is the node we want to combine to flags1
                flags2 = flags2.getNext(); // keep pointer to the rest of flags2
                tmp.setNext(flags1.getNext()); // make tmp->next pointing to flags1->next
                flags1.setNext(tmp); // make flags1->next point to tmp, i.e. now temp was combined to glags1
                flags1 = tmp; // make flags1 point to the new item
            }
            flags1 = flags1.getNext();
        }
    }

    public static void main(String[] arr) {
        int a;
        a = 3;
        run4a();

        //run4b();
    }

}
