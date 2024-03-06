/**
 * The {@code Slot} class represents a slot in a vending machine that holds a product.
 * It stores information such as price, quantity, and product ID.
 * This class does not implement an interface.
 */
public class Slot
{
    // Initialize Local Variables
    double price;
    int quantity;
    String productID;
    final int maxQuantity = 8;
    /**
     * Constructs a Slot with the specified price, quantity, and product ID.
     * @param price The price of the product in the slot.
     * @param quantity The initial quantity of the product in the slot.
     * @param productID The identifier of the product in the slot.
     */
    public Slot(double price, int quantity, String productID)
    {
        // Assign the provided objects to corresponding the local variables
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }
    /**
     * Sets the quantity of the product in the vending machine slot to its maximum capacity.
     * No usages at the moment.
     */
    public void stockToFull()
    {
        // Set quantity of slot to max
        quantity = maxQuantity;
    }
    /**
     * Sets the quantity of the product in the vending machine slot to a specific value.
     * No usages at the moment.
     * @param n The quantity to stock the slot with.
     */
    public void stockToN(int n)
    {
        // Set int 'quantity' equal to int 'n'
        quantity = n;
    }
    /**
     * Gets the price of the product in the vending machine slot.
     * @return {@code price} of the product.
     */
    public double getPrice()
    {
        // return price of selected slot
        return price;
    }
    /**
     * Gets the quantity of the product in the vending machine slot.
     * @return {@code quantity} of the selected slot.
     */
    public int getQuantity()
    {
        // return quantity of selected slot
        return quantity;
    }
    /**
     * Gets the product ID.
     * No usages at the moment.
     * @return {@code productID} as a String.
     */
    public String getProdID()
    {
        // return product ID of selected slot
        return productID;
    }
    /**
     * Sets the price for a product.
     * No usages at the moment.
     * @param amount The price to be set for the product.
     */
    public void setPrice(double amount)
    {
        // Set double 'price' equal to double 'amount'
        price = amount;
    }
}