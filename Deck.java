import java.util.Arrays;
import java.util.Scanner;

public class CardGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] deck = getDeck();
        shuffleDeck(deck);
        int count = 1;
        System.out.println("Enter player 1 name: ");
        String Player1 = sc.nextLine();
        String[] hand = dealCards(deck, count);
        shuffleDeck(deck);
        String[] hand2 = dealCards(deck, count);
        displayCards(hand);
        displayCards(hand2);
    }

  private static String[] getDeck() {
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", 
            "8", "9", "10", "Jack", "Queen", "King"};        

        String[] deck = new String[52];
        int i = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[i] = rank + " of " + suit;
                i++;
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
}
