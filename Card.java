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

public class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getValue() {
        switch (rank) {
            case "2": case "3": case "4": case "5": case "6":
            case "7": case "8": case "9": case "10":
                return Integer.parseInt(rank);
            case "J": case "Q": case "K":
                return 10;
            case "A":
                return 11;
            default:
                throw new IllegalArgumentException("Unknown card rank: " + rank);
        }
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
