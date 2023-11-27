package org.example;

import java.util.Map;
public class Game {
    private final User user = new User();
    private final Price price = new Price();
    private final Presenter presenter = new Presenter();
    private int winPosition,userChoose,presenterChoose;
    private Map<Integer,String> doors;
    private boolean changeDoor, result;
    public void start() {
        doors = price.doors();
        winPosition = price.winKey();
        playerNumber();
        changeDoor = choose();
        if (changeDoor) {
            playerNumber();
            firstRound();
        }
        else firstRound();
    }
    public boolean choose() {
        return user.reply();
    }
    private void firstRound() {
        if (presenterChoose == winPosition) result = false;
        else if(winPosition==userChoose) result =true;
        else {
            doors.remove(presenterChoose);
            nextRound();
        }
    }
    private void nextRound(){
        changeDoor = choose();
        if(changeDoor){
            userChoose = user.choose(price.keys());
            result = doors.get(userChoose).equals(price.getAUTO());
            }
        result = doors.get(userChoose).equals(price.getAUTO());
        }
    private void playerNumber() {
        userChoose = user.choose(price.keys());
        presenterChoose = presenter.door(userChoose, price.keys());
    }
    public boolean isResult() {
        return result;
    }
}
