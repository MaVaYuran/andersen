package by.mariayuran.homework.user;

import by.mariayuran.homework.BaseID;
import by.mariayuran.homework.Printable;


public abstract class User extends BaseID implements Printable {

    public User(int id){
        super(id);

    }
    public abstract void printRole();

}
