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

public class Blackjack {
    public static void main(String[] args) {
        List<String> playerNames = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of players (1-4): ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name of player " + (i + 1) + ": ");
            playerNames.add(scanner.nextLine());
        }

        BlackjackGame game = new BlackjackGame(playerNames);

        while (true) {
            game.playRound();
            System.out.print("Play another round? (y/n): ");
            String choice = scanner.nextLine().toLowerCase();
            if (choice.equals("n")) {
                break;
            }
        }
    }
}
