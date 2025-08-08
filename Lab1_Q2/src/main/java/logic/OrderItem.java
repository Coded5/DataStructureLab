package logic;

public class OrderItem {

    private Item item;
    private int itemAmount;

    public OrderItem(Item item, int itemAmount) {
        this.item = item;
        // this.itemAmount = itemAmount;
        this.setItemAmount(itemAmount);
    }

    public void increaseItemAmount(int amount) {
        if (amount < 0)
            return;

        this.itemAmount += amount;
    }

    public int calculateTotalPrice() {
        return item.getPricePerPiece() * itemAmount;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = (itemAmount >= 0) ? itemAmount : 0;
    }

}
