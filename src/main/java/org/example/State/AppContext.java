package org.example.State;

import org.example.Entity.User;

import java.util.Scanner;

public class AppContext {
    private MenuState currentState;
    private User user;
    private Scanner sc;


    //appContext selalu dimulai dengan loginmenu
    public AppContext(Scanner sc) {
        this.currentState = new LoginMenu();
        this.sc = sc;
    }

    public void run() {
        currentState.execute(this);
    }

    User getUser() {
        return this.user;
    }

    boolean setUser(User user) {
        if (user == null) return false;
        this.user = user;
        return true;
    }

    //the method setMenuState actually also runs the menuState (intentional design decision), albeit going against the supposed function of the method.
    void setMenuState(MenuState state) {
        this.currentState = state;
        run();
    }

    public MenuState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(MenuState currentState) {
        this.currentState = currentState;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

}