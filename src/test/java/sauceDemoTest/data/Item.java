package sauceDemoTest.data;

public class Item {
    private String itemName;
    private String itemPrice;


    public Item(String itemName, String itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }
}
