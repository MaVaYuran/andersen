package homework;

public abstract class BaseID {
    protected int id;

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
