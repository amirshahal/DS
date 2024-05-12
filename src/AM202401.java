public class AM202401 {
    public static String raz(String s)
    {
        if (s.length() == 0)
            return s;
        char c = s.charAt(s.length()-1);
        String st = raz(s.substring(0,  s.length()-1));
        if (c >='A' && c <= 'Z')
            return  c + st;
        return st;
    }

    public static String paz(Queue<String> q)
    {
        if (q.isEmpty())
            return "";
        String s1 = raz(q.remove());
        String s2 = paz(q);
        return s2 + s1;
    }

    public static void TestPaz() {
        Queue<String> q = new Queue<>();
        q.insert("qqANqq");
        q.insert("ad");
        q.insert("wI");
        q.insert("abB");
        System.out.println(paz(q));
    }

    public static boolean isUp(Queue<Character> q) {
        return true;
    }

    public static boolean isIn(Queue<Integer> q, Integer i) {
        q.insert(null);
        boolean rv = false;
        while (q.head() != null) {
            Integer num = q.remove();
            if (num == i)
                rv = true;
            q.insert(num);
        }
        q.remove();
        return rv;
    }

    public static void TestIsIn() {
        Queue<Integer> q = new Queue<>();
        q.insert(11);
        q.insert(22);
        q.insert(33);
        q.insert(4);
        System.out.println(q);
        System.out.println(isIn(q, 2));
        System.out.println(q);
    }



    public static void main(String[] arr) {
        //System.out.println(raz("aBCdE"));
        //TestPaz();
        //TestIsIn();
        String s = "";
        System.out.println(s.length());
    }

}
