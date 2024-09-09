package homework2.user;

import homework2.BaseID;
import homework2.Printable;


public abstract class User extends BaseID implements Printable {

    public User(int id){
        super(id);

    }
    public abstract void printRole();

}
