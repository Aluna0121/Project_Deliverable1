/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jayant Aluna
 * @author Aayush Thakur
 * @author Anmoldeep Singh Mahi
 * @author Mohammedkaif Sirajahmed Shaikh
 */

public class Player {
    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public int getScore() {
        return hand.getValue();
    }

    @Override
    public String toString() {
        return name + ": " + hand.toString() + " (Score: " + getScore() + ")";
    }
}
