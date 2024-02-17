// Provided by Inon Barnea, Aug 1st 2022
public class Queue<T> {
    private Node<T> first = null;
    private Node<T> lastPos = null;

    public Queue() {
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public void insert(T x) {
        if (this.first == null) {
            this.first = new Node<T>(x);
            this.lastPos = this.first;
        } else {
            this.lastPos.setNext(new Node<T>(x));
            this.lastPos = this.lastPos.getNext();
        }

    }

    public T remove() {
        T x = this.first.getValue();
        Node<T> pos = this.first;
        this.first = this.first.getNext();
        if (this.first == null) {
            this.lastPos = null;
        }

        pos.setNext((Node<T>)null);
        return x;
    }

    public T head() {
        return this.first.getValue();
    }

    public String toString() {
        Node<T> pos = this.first;

        String str;
        for(str = "["; pos != null; pos = pos.getNext()) {
            str = str + pos.getValue().toString();
            if (pos.getNext() != null) {
                str = str + ",";
            }
        }

        str = str + "]";
        return str;
    }
}
