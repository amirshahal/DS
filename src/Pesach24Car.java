public class Pesach24Car {
    Integer _id;
    Node<String> _drivers_ids;
    Node<Pesach24Tidluk> _tidluks;

    public Pesach24Car(Integer _id) {
        this._id = _id;
        this._drivers_ids = null;
        this._tidluks = null;
    }

    public Integer get_id() {
        return _id;
    }

    public Integer getSumOfGasAmount() {
        Integer rv = 0;
        Node<Pesach24Tidluk> _tidluks =  this._tidluks;
        while (_tidluks != null) {
            rv += _tidluks.getValue().get_amountOfTidluk();
            _tidluks =  _tidluks.getNext();
        }
        return rv;
    }

    public void addTidluk(String dateOfTidluk, Integer amountOfTidluk) {
        Pesach24Tidluk tidluk = new Pesach24Tidluk(dateOfTidluk, amountOfTidluk);
        if (this._tidluks == null)
            this._tidluks = new Node(tidluk);
        else
            this._tidluks = new Node(tidluk, this._tidluks);
    }

    /*
    א. פעולה שמקבלת רשימת מכוניות ומחזירה את מספר הרישוי של המכונית שסה"כ
 כמות הדלק שתדלקה בשנה האחרונה הייתה המקסימאלית. )הנח שיש אחת כזו (
 ב. מה סיבוכיות זמן הריצה של הפעולה שכתבת? נמק.
     */
    public static Integer getIdOfMaxGas(Node<Pesach24Car> lst) {
        Integer idOfMaxGas = 0;
        Integer maxGas = 0;
        while (lst != null) {
            Pesach24Car car = lst.getValue();
            Integer carsGas = car.getSumOfGasAmount();
            if (carsGas > maxGas) {
                maxGas = carsGas;
                idOfMaxGas = car.get_id();
            }

            lst = lst.getNext();

        }
        return idOfMaxGas;
    }

    public static void main(String[] arr) {
        Pesach24Car car123 = new Pesach24Car(123);
        car123.addTidluk("1.1.24", 10);
        car123.addTidluk("1.2.24", 20);
        car123.addTidluk("1.3.24", 30);
        Node<Pesach24Car> lst = new Node(car123);

        Pesach24Car car456 = new Pesach24Car(456);
        car456.addTidluk("15.1.24", 40);
        car456.addTidluk("15.2.24", 30);
        lst =new Node(car456, lst);

        Pesach24Car car789 = new Pesach24Car(789);
        lst =new Node(car789, lst);

        Integer max = getIdOfMaxGas(lst);
        System.out.println("max= " + max);

    }
}
