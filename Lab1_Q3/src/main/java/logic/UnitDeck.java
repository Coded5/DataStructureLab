package logic;

import java.util.ArrayList;

public class UnitDeck {

    private ArrayList<CardCounter> cardsInDeck;
    private String deckName;

    public UnitDeck(String deckName) {
        this.setDeckName(deckName);
        this.cardsInDeck = new ArrayList<>();
    }

    public void addCard(UnitCard newCard, int count) {
        if (count <= 0)
            return;

        for (CardCounter card : cardsInDeck) {
            if (card.getCard().equals(newCard)) {
                card.setCount(card.getCount() + count);
                return;
            }
        }

        cardsInDeck.add(new CardCounter(newCard, count));
    }

    public void removeCard(UnitCard toRemove, int count) {
        if (count <= 0)
            return;

        for (CardCounter card : cardsInDeck) {
            if (card.getCard().equals(toRemove)) {
                int newAmount = card.getCount() - count;

                if (newAmount <= 0) {
                    cardsInDeck.remove(card);
                    return;
                }

                card.setCount(newAmount);
            }
        }
    }

    public int cardCount() {
        int count = 0;

        for (CardCounter card : cardsInDeck) {
            count += card.getCount();
        }

        return count;
    }

    public boolean existsInDeck(UnitCard card) {
        for (CardCounter c : cardsInDeck) {
            if (c.getCard().equals(card))
                return true;
        }

        return false;
    }

    public boolean equals(UnitDeck deck) {
        return deckName.equals(deck.getDeckName());
    }

    public ArrayList<CardCounter> getCardsInDeck() {
        return cardsInDeck;
    }

    public void setCardsInDeck(ArrayList<CardCounter> cardsInDeck) {
        this.cardsInDeck = cardsInDeck;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName.isBlank() ? "Untitled Deck" : deckName;
    }

}
