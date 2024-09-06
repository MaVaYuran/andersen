package homework2;

public abstract class BaseID {
    private int id;

    public BaseID(int id) {
        this.id = id;
    }

    public  int getId() {
        return id;
    };
    public void setId(int id) {
        this.id = id;
    };
}
