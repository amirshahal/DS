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

    public static void main(String[] arr) {
        Queue<String> q = new Queue<String>();
        q.insert("hello");
        q.insert("world");
        q.insert("hi");
        q.insert("bye");

        // System.out.println(secret(q));
        System.out.println(topSecret(q));
        System.out.println(q);
    }
}
