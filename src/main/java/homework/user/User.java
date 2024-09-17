package homework.user;

import homework.BaseID;
import homework.Printable;


public abstract class User extends BaseID implements Printable {

    public User(int id){
        super(id);

    }
    public abstract void printRole();

}
