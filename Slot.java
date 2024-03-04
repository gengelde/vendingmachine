public class Slot
{
    double price;
    int quantity;
    String productID;
    final int maxQuantity = 8;

    public Slot(double price, int quantity, String productID)
    {
        // receive created slot information to allow for reading or writing of custom Slot
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }
    // no usages at the moment
    public void stockToFull()
    {
        quantity = maxQuantity;
    }
    // no usages at the moment
    public void stockToN(int n)
    {
        quantity = n;
    }
    public double getPrice()
    {
        // return price of selected slot
        return price;
    }
    public int getQuantity()
    {
        // return quantity of selected slot
        return quantity;
    }
    // no usages at the moment
    public String getProdID()
    {
        return productID;
    }
    // no usages at the moment
    public void setPrice(double amount)
    {
        price = amount;
    }
}