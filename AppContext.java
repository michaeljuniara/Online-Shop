import java.util.Scanner;
class AppContext {
    MenuState currentState;
    User user;
    Scanner sc;


    void run(){
        currentState.execute(this);
    }

    User getUser(){
        return this.user;
    }

    boolean setUser(User user){
        if (user == null) return false;
        this.user = user;
        return true;
    }

    //the method setMenuState actually also runs the menuState (intentional design decision), albeit going against the supposed function of the method.
    void setMenuState(MenuState state){
        this.currentState = state;
        run();
    }


    //appContext selalu dimulai dengan loginmenu
    public AppContext(Scanner sc){
        this.currentState = new LoginMenu();
        this.sc = sc;
    }

}