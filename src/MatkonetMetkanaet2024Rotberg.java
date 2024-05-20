public class MatkonetMetkanaet2024Rotberg {
    public static int What(int num, int i) {
        if ((num + i) % 10 == 0)
            return num + i;

        if ((num - i) % 10 == 0)
            return num - i;

        return What(num, i + 1);

    }

    public static void What2(Queue<Integer> q) {
        int x, y, z;
        if (!q.isEmpty()) {
            z = 0;
            y = q.head();
            x = q.remove();

            while (y> 0) {
                z = z * 10 + y % 10;
                y = y / 10;
            }
            x = What(x, 0) + What(z, 0);
            What2(q);
            q.insert(x);
        }
    }

    public static void Q4() {
        System.out.println("Q4q: What(571, 0) = " + What(571, 0));
        System.out.println("Q4b: What(36, 0) = " + What(36, 0));

        Queue<Integer> q = new Queue<Integer>();
        q.insert(21);
        q.insert(45);
        q.insert(100);
        What2(q);
        System.out.println(q);

    }

    public static Queue<Double> Secret(Queue<Queue<Integer>> que) {
        Queue<Double> qNew = new Queue<Double>();
        Queue<Integer> q;
        while(!que.isEmpty()){
            q = que.remove();
            int sum = 0, count = 0;
            while(!q.isEmpty()){
                sum = sum + q.remove();
                count++;
            }

            if (count != 0)
                qNew.insert((double)sum /count);
        }

        return qNew;
    }

    public static void Q6() {
        Queue<Queue<Integer>> qOfQs = new Queue<Queue<Integer>>();
        Queue<Integer> q1 = new Queue<Integer>();
        q1.insert(5);
        q1.insert(2);
        q1.insert(13);
        q1.insert(56);
        qOfQs.insert(q1);

        Queue<Integer> q2 = new Queue<Integer>();
        qOfQs.insert(q2);

        Queue<Integer> q3 = new Queue<Integer>();
        q3.insert(841);
        q3.insert(27);
        q3.insert(500);
        qOfQs.insert(q3);

        Queue<Integer> q4 = new Queue<Integer>();
        q4.insert(12);
        qOfQs.insert(q4);

        Queue<Integer> q5 = new Queue<Integer>();
        q5.insert(7);
        q5.insert(2);
        q5.insert(4);
        q5.insert(3);
        q5.insert(11);
        qOfQs.insert(q5);

        Queue<Integer> q6 = new Queue<Integer>();
        q6.insert(88);
        q6.insert(5);
        qOfQs.insert(q6);


        Queue<Double> qd = Secret(qOfQs);
        System.out.println(qd);
    }

    public static void main(String[] arr) {
        // Q4();
        Q6();

    }
}
