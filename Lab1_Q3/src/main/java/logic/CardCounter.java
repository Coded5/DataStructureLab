package logic;

public class CardCounter {

    private UnitCard card;
    private int count;

    public CardCounter(UnitCard card, int count) {
        this.setCard(card);
        this.setCount(count);
    }

    public String toString() {
        return this.getCard() + " x " + this.getCount();
    }

    public UnitCard getCard() {
        return card;
    }

    public void setCard(UnitCard card) {
        this.card = card;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = (count >= 0) ? count : 0;
    }

}
