package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CardUtil {

    public static boolean isExistsInList(UnitCard card, ArrayList<UnitCard> list) {
        return list.contains(card);
    }

    public static boolean isExistsInList(UnitDeck deck, ArrayList<UnitDeck> list) {
        return list.contains(deck);
    }

    public static boolean cardExistsInDeckList(ArrayList<UnitDeck> deckList, UnitCard cardToTest) {
        for (UnitDeck deck : deckList) {
            for (CardCounter card : deck.getCardsInDeck()) {
                if (card.getCard().getName().equals(cardToTest.getName())) {
                    return true;
                }
            }
        }

        return false;
    }

    public static ArrayList<UnitCard> getCardsFromFile(String filename) {

        File fileToRead = new File(filename);
        ArrayList<UnitCard> cardsFromFile = new ArrayList<UnitCard>();
        Scanner scanner = null;

        try {
            scanner = new Scanner(fileToRead);

            while (scanner.hasNext()) {
                String[] parts = scanner.nextLine().split(",");

                if (parts.length != 5) {
                    System.out.println("Error: Invalid file format");
                    return null;
                }

                String name = parts[0];
                int bloodCost = Integer.parseInt(parts[1]);
                int power = Integer.parseInt(parts[2]);
                int health = Integer.parseInt(parts[3]);
                String flavorText = parts[4];
                UnitCard card = new UnitCard(name, bloodCost, power, health, flavorText);
                cardsFromFile.add(card);
            }

            return cardsFromFile;

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (NumberFormatException e) {
            return null;
        }

        return null;
    }

    public static void printCardList(ArrayList<UnitCard> cardList, boolean verbose) {

        for (int i = 0; i < cardList.size(); i++) {
            System.out.println(i + ") " + cardList.get(i));
            if (verbose) {
                System.out.println("Blood Cost: " + cardList.get(i).getBloodCost());
                System.out.println(cardList.get(i).getFlavorText());
                if (i < cardList.size() - 1)
                    System.out.println("-----");
            }
        }
    }

    public static void printDeck(UnitDeck ud) {

        if (ud.getCardsInDeck().size() == 0) {
            System.out.println("EMPTY DECK");
        } else {
            for (CardCounter cc : ud.getCardsInDeck()) {
                System.out.println(cc);
            }
        }

        System.out.println("Total Cards: " + ud.cardCount());
    }

    public static void printDeckList(ArrayList<UnitDeck> deckList) {

        for (int i = 0; i < deckList.size(); i++) {
            System.out.println(i + ") " + deckList.get(i).getDeckName());
            printDeck(deckList.get(i));
            if (i < deckList.size() - 1)
                System.out.println("-----");
        }
    }
}
