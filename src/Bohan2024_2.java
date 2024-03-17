public class Bohan2024_2 {
    public static String raz(String s) {
        // כאן צריכה לבוא תשובה לשאלה 4
        return paz(s, s.length() - 1);
    }

    public static String gaz(String s, int i, char c) {
        // כאן צריכה לבוא תשובה לשאלה 4
        String rv = s.substring(0, i) + c + s.substring(i+1);
        return rv;
    }

    public static String zaz(Queue<String> q) {
        // כאן צריכה לבוא תשובה לשאלה 4
        if (q.isEmpty())
            return "";
        String s1 = raz(q.remove());
        String s2 = zaz(q);
        return s2 + s1;
    }

    public static String paz(String s, int i) {
        // כאן צריכה לבוא תשובה לשאלה 4
        if (i > -1) {
            if (s.charAt(i) == 'k')
                s = gaz(s, i, 's');
            else if (s.charAt(i) == 'f')
                s = gaz(s, i, 'm');
            else if (s.charAt(i) == 'K')
                s = gaz(s, i, 'S');
            else if (s.charAt(i) < 'a')
                s = s.substring(0, i) + s.substring(i + 1);
            s = paz(s, i - 1);
        }
        return s;
    }

    public static String paz2(String s, int i) {
        // כאן צריכה לבוא תשובה לשאלה 4
        if (i > -1) {
            switch(s.charAt(i)) {
                case 'k':
                    s = gaz(s, i, 's');
                    break;

                case 'f':
                    s = gaz(s, i, 'm');
                    break;

                case 'K':
                    s = gaz(s, i, 'S');
                    break;

            }

            s = paz(s, i - 1);
        }
        return s;
    }

    public static void main(String[] arr) {
        System.out.println(raz("Kafka"));
        Queue<String> q = new Queue<String>();
        q.insert("kon");
        q.insert("STAM");
        q.insert("Kaf");
        System.out.println(zaz(q));

    }
}
