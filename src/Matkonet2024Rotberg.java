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

    public static void printLinkedListIntArray(Node <int[]> n) {
        while (n != null) {
            int[] arr = n.getValue();
            System.out.print("[");
            for (int i = 0; i < arr.length;i++)
                System.out.print("" + arr[i] + ",");
            System.out.println("]");
            n = n.getNext();
        }
    }

    public static void printLinkedList(Node n) {
        while (n != null) {
            System.out.print(n.getValue() + " -> ");
            n = n.getNext();
        }

        System.out.println("");
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

    // Question 7a
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

    // Question 7b
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

            // update the values we keep for the next round
            lastColor = list.getValue().getColor();
            lastIndex = list.getValue().getIndex();
            list = list.getNext();
        }
        return true;
    }

    public static void combine_wrong(Node<Flag> list1, Node<Flag> list2) {
        int i = 1;
        while (list2 != null) {
            if (list1.getValue().getIndex() == i) {
                list1 = list1.getNext();
            }

            if (list2.getValue().getIndex() == i) {
                // Problem #1: setNext get a Node and not a Flag.
                // list1.setNext(list2.getValue());

                // Problem #3. In this case list1 is already "beyond" list2
                //      what we want is to link list2's head to the previous node in list1.
                list1.setNext(list2);

                // See problem #2 note
                list2 = list2.getNext();
            }

            i++;

            // Problem #2: you want to move list2 forward only if you used it
            //list2 = list2.getNext();
        }

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
            else
                flags1 = flags1.getNext();
        }
    }

    public static Node<Flag> buildFlagsList(int[] arr) {
        if (arr.length == 0)
            return null;

        Flag f1 = new Flag("Blue", arr[0]);
        Node<Flag> lst = new Node(f1);
        Node<Flag> last = lst;

        for (int i = 1; i < arr.length; i++) {
            Flag f = new Flag("Blue", arr[i]);
            Node<Flag> n = new Node(f);
            last.setNext(n);
            last = n;
        }

        return lst;
    }

    public static void run6() {
        Node<Flag> lst1 = buildFlagsList(new int[]{1, 2, 6, 7});
        printLinkedList(lst1);

        Node<Flag> lst2 = buildFlagsList(new int[]{3, 4, 5, 8});
        printLinkedList(lst2);

        combine(lst1, lst2);
        //combine_wrong(lst1, lst2);
        printLinkedList(lst1);
    }


    public static void main(String[] arr) {
        //run4a();
        //run4b();
        run6();
    }

}
