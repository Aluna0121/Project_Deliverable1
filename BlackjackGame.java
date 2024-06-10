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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackjackGame {
    private Deck deck;
    private List<Player> players;
    private Player dealer;

    public BlackjackGame(List<String> playerNames) {
        deck = new Deck();
        players = new ArrayList<>();
        for (String name : playerNames) {
            players.add(new Player(name));
        }
        dealer = new Player("Dealer");
    }

    public void playRound() {
        initialDeal();
        playerTurns();
        dealerTurn();
        determineWinners();
        resetHands();
    }

    private void initialDeal() {
        for (Player player : players) {
            player.getHand().addCard(deck.drawCard());
            player.getHand().addCard(deck.drawCard());
        }
        dealer.getHand().addCard(deck.drawCard());
        dealer.getHand().addCard(deck.drawCard());
    }

    private void playerTurns() {
        Scanner scanner = new Scanner(System.in);
        for (Player player : players) {
            while (true) {
                System.out.println(player);
                System.out.print("Hit or Stand? (h/s): ");
                String choice = scanner.nextLine().toLowerCase();

                if (choice.equals("h")) {
                    player.getHand().addCard(deck.drawCard());
                    if (player.getScore() > 21) {
                        System.out.println(player + " - Busted!");
                        break;
                    }
                } else if (choice.equals("s")) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter 'h' to Hit or 's' to Stand.");
                }
            }
        }
    }

    private void dealerTurn() {
        while (dealer.getScore() < 17) {
            dealer.getHand().addCard(deck.drawCard());
        }
    }

    private void determineWinners() {
        System.out.println("Dealer: " + dealer);
        int dealerScore = dealer.getScore();
        for (Player player : players) {
            int playerScore = player.getScore();
            if (playerScore > 21) {
                System.out.println(player.getName() + " - Busted! Dealer wins.");
            } else if (dealerScore > 21 || playerScore > dealerScore) {
                System.out.println(player.getName() + " wins!");
            } else if (playerScore < dealerScore) {
                System.out.println(player.getName() + " loses. Dealer wins.");
            } else {
                System.out.println(player.getName() + " ties with the Dealer.");
            }
        }
    }

    private void resetHands() {
        for (Player player : players) {
            player.getHand().getCards().clear();
        }
        dealer.getHand().getCards().clear();
    }
}
