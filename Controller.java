import javax.swing.*;

public class Controller implements Runnable
{
    // Load Classes and Initialize Local Variables
    private Factory Factor;
    private Moneyable Money;
    private Interactable Ui;
    private Vendable Vend;
    private Logable Log;
    private Connectable Conn;
    private Message msg;
    String selection;
    boolean vending = true;
    boolean selecting;
    double bal;
    int result;
    final int databaseConnectionError = -1;
    // Initialize Controller constructor
    public Controller(Message msg)
    {
        // Load Classes
        Factor = new Factory();
        Money = new MoneyIntake(msg);
        Ui = Factor.getUI();
        Vend = Factor.getVend();
        Log = Factor.getLog();
        Conn = new DataConnect(msg);

        this.msg = msg;
    }
    // Initialize Controller Thread Block
    public void run()
    {
        // Connect to the database & verify connection
        // If failure to connect, turn off vending machine
        if (!Conn.connect())
        {
            // Print "Connection Error" to console
            System.out.println("Connection Error");
            // Send log information to logger
            Log.writeToFile(Conn.getLastEvent());
            // Turn off vending machine due to database connection error
            System.exit(databaseConnectionError);
        }
        // Send log information to logger
        Log.writeToFile(Conn.getLastEvent());
        // Vending in progress
        while (vending)
        {
            // Display to user "Log in OR Insert Funds"
            Ui.setDisplayToUser("Log in OR Insert Funds");
            // Enable selecting loop
            selecting = true;
            // Synchronize thread block with other threads synchronized with message class
            synchronized (msg)
            {
                try
                {
                    // Put Controller thread into wait mode until either DataConnect or MoneyIntake JOptionPane notifies
                    msg.wait();
                }
                catch (InterruptedException e)
                {
                    // Print exception message e to console
                    System.out.println(e.getMessage());
                    // Send log information to logger
                    Log.writeToFile("Interrupted Exception Caught");
                }
                try
                {
                    // Send user input to total balance (Potential NumberFormatException here)
                    bal = Double.parseDouble(msg.getMsg());
                    // Send log information to logger
                    Log.writeToFile(String.format("Balance Received: $%.2f", bal));
                    // Add bal to total balance
                    Money.collectMoney(bal);
                    // Send log information to logger
                    Log.writeToFile(Money.getLastEvent());
                    // Send log information to logger
                    Log.writeToFile(Money.getLastEvent());
                    // Display to user "Balance: $#.##"
                    Ui.setDisplayToUser(String.format("Balance: $%.2f", Money.getBalance()));
                    // Send log information to logger
                    Log.writeToFile(Ui.getLastEvent());
                }
                catch (NumberFormatException e)
                {
                    // Print exception message e to console
                    System.out.println(e.getMessage());
                    // Send log information to logger
                    Log.writeToFile("Number Format Exception Caught");
                }
                while (selecting)
                {
                    // Display to user "Make a selection"
                    Ui.setDisplayToUser("Make a selection");
                    // Send log information to logger
                    Log.writeToFile(Ui.getLastEvent());
                    // Get user input and assign it to local variable "selection"
                    selection = Ui.getUserInput();
                    // Send log information to logger
                    Log.writeToFile(Ui.getLastEvent());
                    // Process if user selection is a valid slot & selected slot is in stock
                    if (Vend.selectSlot(selection))
                    {
                        // Check if user has enough money to buy selected product
                        if (Vend.getSelectedSlotPrice() < Money.getBalance())
                        {
                            // Decrease balance by selected product price
                            Money.takeFromBalance(Vend.getSelectedSlotPrice());
                            // Send log information to logger
                            Log.writeToFile(Money.getLastEvent());
                            // Dispense product
                            Vend.dispenseSelectedSlot();
                            // Send log information to logger
                            Log.writeToFile(Vend.getLastEvent());
                            // Display to user "Dispensing"
                            Ui.setDisplayToUser("Dispensing");
                            // Send log information to logger
                            Log.writeToFile(Ui.getLastEvent());
                            // Process if user did not log in
                            if (msg.getName() == null)
                            {
                                // Display to user "Change: $#.##"
                                Ui.setDisplayToUser(String.format("Change: $%.2f", Money.getBalance()));
                                // Send log information to logger
                                Log.writeToFile(Money.getLastEvent());
                                // Dispense change back to user
                                Money.takeFromBalance(Money.getBalance());
                                // Send log information to logger
                                Log.writeToFile(Money.getLastEvent());
                                // Dispense change back to user
                                Money.takeFromBalance(Money.getBalance());
                            }
                            // Process if user did log in
                            else if (msg.getName() != null)
                            {
                                // Convert current total balance to string and send to msg
                                msg.setMsg(String.valueOf(Money.getBalance()));
                                // Notify DataConnect thread waiter to continue
                                msg.notify();
                                // Send log information to logger
                                Log.writeToFile(Money.getLastEvent());
                            }
                            // Disable selecting loop
                            selecting = false;
                        }
                        // Process if user bal is insufficient for product purchase
                        else
                        {
                            // Display to user "Insufficient Funds"
                            Ui.setDisplayToUser("Insufficient Funds");
                            // Send log information to logger
                            Log.writeToFile(Ui.getLastEvent());
                            // Display to user "Balance: $#.##"
                            Ui.setDisplayToUser(String.format("Balance: $%.2f", Money.getBalance()));
                            // Send log information to logger
                            Log.writeToFile(Ui.getLastEvent());
                            // Display to user "Price: $#.##"
                            Ui.setDisplayToUser(String.format("Price: $" + Vend.getSelectedSlotPrice()));
                            // Send log information to logger
                            Log.writeToFile(Ui.getLastEvent());
                            // Process if user did not log in
                            if (msg.getName() == null)
                            {
                                // Display Confirmation box to user "Do you want to insert more funds?"
                                result = JOptionPane.showConfirmDialog(null, "Do you want to insert more funds?", "Insufficient Funds", JOptionPane.YES_NO_CANCEL_OPTION);
                                // Process if result is YES
                                if (result == JOptionPane.YES_OPTION)
                                {
                                    // Disable selecting loop
                                    selecting = false;
                                }
                                // Process if result is CANCEL
                                else if (result == JOptionPane.CANCEL_OPTION)
                                {
                                    // Display to user "Returning Balance: $#.##"
                                    Ui.setDisplayToUser(String.format("Returning Balance: $%.2f", Money.getBalance()));
                                    // Dispense change back to user
                                    Money.takeFromBalance(Money.getBalance());
                                    // Disable selecting loop
                                    selecting = false;
                                }
                                // If result is NO continue
                            }
                        }
                    }
                    // Process if user inputted Invalid ID OR Product Out of Stock
                    else
                    {
                        // Display to user "Invalid ID OR Product Out of Stock"
                        Ui.setDisplayToUser("Invalid ID OR Product Out of Stock");
                        // Send log information to logger
                        Log.writeToFile(Ui.getLastEvent());
                    }
                }
            }
        }
    }
}

