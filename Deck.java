// Name: Hi-Lo Card Game
// Developers: Stan Razumov, placeholder, placeholder
// Date: placeholder
// Purpose: placeholder

//^^^^^^^^^^^^^^^^^^^^^^^^Replace the placeholders!

/* Feel free to add or delete anything, just make sure it will work by next Tue */

import java.util.Arrays;
import java.util.Scanner;

public class CardGame { //Check me before running

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] deck = getDeck();
        shuffleDeck(deck);
        int count = 1;
        System.out.println("Enter Player 1 Name: ");
        String Player1 = sc.nextLine();
        String[] hand = dealCards(deck, count);
        
        System.out.println("Enter Player 2 Name: ");
        String Player2 = sc.nextLine();             // You may add datatype handlers
        shuffleDeck(deck);                          // if you want to.
        String[] hand2 = dealCards(deck, count);    
        displayCards(hand);
        displayCards(hand2);
        checkWinner(Player1,Player2,hand,hand2);
    }

  private static String[] getDeck() {
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", 
            "8", "9", "10", "Jack", "Queen", "King"};        

        String[] deck = new String[52]; 
        int i = 0;
        boolean idx = false;            // Added a while loop that
        while (idx == false){           // We tried to make today.
            for (String rank : ranks) { // Now it fills all 52 positions
                deck[i] = rank;         // With cards.
                i++;
            }
            if (i == deck.length){
                idx = true;
            }
        
        
        }
        return deck;
    }

    private static void displayCards(String[] cards) {
        System.out.print("|");        
        for (String card : cards) {
            System.out.print(card + "|");
        }
        System.out.println();        
    }

    private static void shuffleDeck(String[] deck) {
        for (int i = 0; i < deck.length; i++) {
            String savedCard = deck[i];
            int randomIndex = (int) (Math.random() * deck.length-1);
            deck[i] = deck[randomIndex];
            deck[randomIndex] = savedCard;
        }
    }

    private static String[] dealCards(String[] deck, int count) {
        String[] hand = Arrays.copyOfRange(deck, 0, count);
        return hand;
    }
    private static void checkWinner(String Player1, String Player2,String[] hand, String[] hand2){
        String[] ranks = {"2", "3", "4", "5", "6", "7",         //Didn't bother much with passing arrays
            "8", "9", "10", "Jack", "Queen", "King", "Ace"};    //Just copied ranks array so I could compare the indexes
        String playerOneHand = hand[0];
        String playerTwoHand = hand2[0];
        int p1 = java.util.Arrays.asList(ranks).indexOf(playerOneHand);
        int p2 = java.util.Arrays.asList(ranks).indexOf(playerTwoHand);
        if (p1 > p2){
            System.out.println(Player1 + " Wins, He Has a Higher Card!");
        }
        if (p1 < p2){
            System.out.println(Player2 + " Wins, He Has a Higher Card!");
        }
        if (p1 == p2) {
            System.out.println("Draw! Try Again!");
        }
        
    }
}
    
