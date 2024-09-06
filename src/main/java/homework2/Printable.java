package homework2;

public interface Printable {
    public default void print() {
        System.out.println("print content in console");
    }
}
