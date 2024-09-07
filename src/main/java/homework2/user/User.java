package homework2.user;

import homework2.BaseID;
import homework2.Ticket;

public abstract class User extends BaseID {




    public User(int id){
        super(id);

    }
//    public Ticket getTicket() {
//        return ticket;
//    }

    public abstract void printRole();

}
