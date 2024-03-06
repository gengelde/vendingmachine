/**
 * The {@code Moneyable} interface defines methods for the money handling process of the vending machine.
 * The {@code Moneyable} interface also defines a method for returning a string set by other methods back to Controller.
 */
public interface Moneyable
{
    /**
     * Adds the specified amount of money to the total balance in the vending machine.
     * @param money The amount of money to be added to the total balance.
     */
    void collectMoney(double money);
    /**
     * Returns the total balance in the vending machine.
     */
    double getBalance();
    /**
     * Subtracts the specified amount from the total balance in the vending machine.
     * @param money The amount to be subtracted from the total balance.
     */
    void takeFromBalance(double money);
    /**
     * Returns string set by other methods back to Controller to then be sent to the {@code Logger} class for logging purposes.
     */
    String getLastEvent();
}
