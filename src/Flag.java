public class Flag {
    String color;
    int index;

    public Flag(String color, int number) {
        this.color = color;
        this.index = number;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        String rv = color + "," + index;
        return rv;
    }

    public int getIndex() {
        return index;
    }
}
