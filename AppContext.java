import java.util.Scanner;
class AppContext {
    private MenuState currentState;
    private User user;
    private Scanner sc;


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