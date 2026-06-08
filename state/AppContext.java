package state;

import entity.User;
import java.util.Scanner;

public class AppContext {
    private MenuState currentState;
    private User user;
    private Scanner sc;

    public void run(){
        currentState.execute(this);
    }

    public User getUser(){
        return this.user;
    }

    public boolean setUser(User user){
        if (user == null) return false;
        this.user = user;
        return true;
    }

    //the method setMenuState actually also runs the menuState (intentional design decision), albeit going against the supposed function of the method.
    public void setMenuState(MenuState state){
        this.currentState = state;
        run();
    }


    //appContext selalu dimulai dengan loginmenu
    public AppContext(Scanner sc){
        this.currentState = new LoginMenu();
        this.sc = sc;
    }

    public MenuState getCurrentState() {
        return currentState;
    }

    public Scanner getScanner() {
        return sc;
    }   
}