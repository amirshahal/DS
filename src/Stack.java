
// Provided by Inon Barnea, Aug 1st 2022
public class Stack<T> {
    private Node<T> first;

  /* הפעולה בונה ומחזירה מחסנית ריקה **/
    public Stack() {
        this.first = null;
    }
  
    public void push(T x) {
        Node<T> temp = new Node<T>(x);
        temp.setNext(first);
        first = temp;
    }
  
    /* הפעולה מכניסה את הערך x לראש המחסנית הנוכחית **/
    /* הפעולה מוציאה ומחזירה את הערך הנמצא  בראש המחסנית הנוכחית **/
    public T pop() {
        T x = first.getValue();
        first = first.getNext();
        return x;
    }


    /* הפעולה מחזירה את הערך הנמצא  בראש המחסנית הנוכחית **/
    public T top() {
        return first.getValue();
    }


    /* הפעולה מחזירה 'אמת' אם המחסנית הנוכחית ריקה, ומחזירה 'שקר' אחרת **/
    public boolean isEmpty() {
        return first == null;
    }


    /* הפעולה מחזירה מחרוזת המתארת את המחסנית הנוכחית */
    public String toString() {
        String s = "[";
        Node<T> p = this.first;
        while (p != null) {
            s = s + p.getValue().toString();
            if (p.hasNext())
                s = s + ",";
            p = p.getNext();
        }
        s = s + "]";
        return s;
    }
}
