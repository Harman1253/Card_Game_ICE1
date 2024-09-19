/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 */
import java.util.Random;
import java.util.Scanner;

public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random random = new Random();

        // Fill magicHand with random card objects
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1); // random value between 1 and 13 (Ace to King)
            c.setSuit(Card.SUITS[random.nextInt(4)]); // random suit (Hearts, Diamonds, Spades, Clubs)
            magicHand[i] = c;
        }

        // Ask the user for card value and suit
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick a card value (1 for Ace, 11 for Jack, 12 for Queen, 13 for King): ");
        int userValue = scanner.nextInt();

        System.out.println("Pick a suit (0 for Hearts, 1 for Diamonds, 2 for Spades, 3 for Clubs): ");
        int userSuitIndex = scanner.nextInt();

        String userSuit = Card.SUITS[userSuitIndex];

        // Search the magicHand for the user's card
        boolean cardFound = false;
        for (Card card : magicHand) {
            if (card.getValue() == userValue && card.getSuit().equals(userSuit)) {
                cardFound = true;
                break;
            }
        }

        // Report the result
        if (cardFound) {
            System.out.println("Your card was found in the magic hand!");
        } else {
            System.out.println("Your card was not found in the magic hand.");
        }
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");
        System.out.println("Lucky card is: " + luckyCard.getValue() + " of " + luckyCard.getSuit());
    }
}
