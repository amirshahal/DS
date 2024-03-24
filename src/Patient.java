public class Patient {
    private String name;
    private int age;
    private boolean reserved;

    public Patient(String name, int age, boolean reserved) {
        this.name = name;
        this.age = age;
        this.reserved = reserved;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", reserved=" + reserved +
                '}';
    }

    public boolean isReserved() {
        return reserved;
    }
}
