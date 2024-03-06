import javax.swing.*;
/**
 * The {@code MoneyIntake} class represents the logic for handling money intake in a vending machine.
 * The {@code MoneyIntake} class implements the {@code Moneyable} and {@code Runnable} interfaces.
 */
public class MoneyIntake implements Moneyable, Runnable
{
    // Create instances of classes and Initialize Local Variables
    double total;
    String info;
    String input;
    boolean running = true;
    private Message msg;
    /**
     * Constructs a {@code MoneyIntake} instance with the specified Message object.
     * @param msg The {@code Message} object used for communication with other threads.
     */
    public MoneyIntake(Message msg)
    {
        // Assign the provided Message object to the local 'msg' variable
        this.msg = msg;
    }
    /**
     * The main execution logic for the MoneyIntake thread.
     */
    public void run()
    {
        while(running)
        {
            // Display Input Dialog box to user "Insert Cash:"
            input = JOptionPane.showInputDialog(null, "Insert Cash:");
            // Synchronize thread block with other threads synchronized with message class
            synchronized (msg)
            {
                // Process if user selected 'cancel'
                if (input == null)
                {
                    try {
                        // Put MoneyIntake thread to sleep for 1 second
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        // Print exception message to console
                        System.out.println(e.getMessage());
                    }
                }
                // Process if user inputted a valid input
                else
                {
                    // Set msg to user input from JOptionPane
                    msg.setMsg(input);
                    // Set name to null
                    msg.setName(null);
                    // Notify Controller thread waiter to continue
                    msg.notify();
                }
            }
        }
    }
    /**
     * Adds the specified amount of money to the total balance in the vending machine.
     * @param money The amount of money to be added to the total balance.
     */
    public void collectMoney(double money)
    {
        // add user inputted money to total balance in machine
        total = total + money;
        // set info for getLastEvent to return when called
        info = "collectMoney" + " collected: $" + money + " total bal: $" + total;
    }
    /**
     * Gets the total balance in the vending machine.
     * @return {@code total} balance in the vending machine.
     */
    public double getBalance()
    {
        // set info for getLastEvent to return when called
        info = "getBalance balance returned: " + total;
        // return total balance
        return total;
    }
    /**
     * Subtracts the specified amount from the total balance in the vending machine.
     * @param money The amount to be subtracted from the total balance.
     */
    public void takeFromBalance(double money)
    {
        // subtract amount from total balance in machine
        total = total - money;
        // set info for getLastEvent to return when called
        info = "takeFromBalance money taken from bal: " + money + " new bal: " + total;
    }
    /**
     * Returns info string set by other methods back to Controller to then be sent to the {@code Logger} class for logging purposes.
     *
     * @return {@code info} string set by other methods back to {@code Controller} class
     */
    public String getLastEvent()
    {
        // return info set by other methods
        return info;
    }
}