// Name: Hi-Lo Card Game
// Developers: Stan Razumov, Justin Shull, placeholder
// Date: 10/22/18
// Purpose: Play a game of Hi-Lo

//^^^^^^^^^^^^^^^^^^^^^^^^Replace the placeholders!

/* Feel free to add or delete anything, just make sure it will work by next Tue */
/* Please check for errors and let me know if you will find any */

import java.util.Arrays;
import java.util.Scanner;

public class CardGame { //Check me before running

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String endGame = "y";
        while ("y".equalsIgnoreCase(endGame)){      //loop to prompt to play again
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
        displayCards(hand, Player1);                //added player names to draw printline
        displayCards(hand2, Player2);
        checkWinner(Player1,Player2,hand,hand2);
        System.out.println("Play again? y/n");
        endGame = sc.nextLine();
        
        if (!(endGame == "y") || !(endGame == "n")) {   //input validation 
            System.out.println("Enter y or n ");
            endGame = sc.nextLine();
            }
        }  
    }

   private static String[] getDeck() {
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", 
            "8", "9", "10", "Jack", "Queen", "King"};        

        String[] deck = new String[52]; 
        int i = 0;
        int idx = 0;
        boolean test = false;            // Added a while loop that
        while (test == false){           // We tried to make today.
            for (String rank : ranks) { // Now it fills all 52 positions
                deck[i] = rank;         // With cards.
                i++;
                idx++;
            }
            if (i == ranks.length - 1){
                i = 0;
            }
            if (idx == deck.length){
                test = true;
            }
        }
        return deck;
    }

    private static void displayCards(String[] cards, String player) {
        System.out.print(player + " drew |");        
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
