package homework2.user;

import homework2.BaseID;
import homework2.Printable;
import homework2.Ticket;

public abstract class User extends BaseID implements Printable {

    public User(int id){
        super(id);

    }
    public abstract void printRole();

}
