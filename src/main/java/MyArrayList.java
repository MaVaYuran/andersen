public class MyArrayList<T> {
    private T[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        this.array = (T[]) new Object[10];
        this.size = 0;
    }

    public void add(T element) {
        if (size == array.length) {
            resizeArray();
        }
        array[size++] = element;
    }

    public T getByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    @SuppressWarnings("unchecked")
    private void resizeArray() {
        if (size == array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }
}
