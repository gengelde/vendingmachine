public class Controller implements Runnable
{
    // Load Classes
    private Factory Factor;
    private Moneyable Money;
    private Interactable Ui;
    private Vendable Vend;
    private Logable Log;
    private Connectable Conn;
    public Controller()
    {
        // Load Classes
        Factor = new Factory();
        Money = Factor.getMoney();
        Ui = Factor.getUI();
        Vend = Factor.getVend();
        Log = Factor.getLog();
        Conn = Factor.getConn();
    }

    public void run()
    {
        {
            // Create local variables
            String selection;
            String input;
            boolean vending = true;
            boolean selecting;
            boolean awaitingCashInput;
            final int databaseConnectionError = -1;
            // Connect to the database
            if (!Conn.connect())
            {
                // Send log information to logger
                Log.writeToFile(Conn.getLastEvent());
                System.exit(databaseConnectionError);
            }
            // Send log information to logger
            Log.writeToFile(Conn.getLastEvent());
            // Vending in progress
            while (vending)
            {
                // Enable loops
                selecting = true;
                awaitingCashInput = true;
                // Loop waiting for further cash input
                while (awaitingCashInput)
                {
                    // Display to user "Input Cash"
                    Ui.setDisplayToUser("Insert Cash");
                    // Send log information to logger
                    Log.writeToFile(Ui.getLastEvent());
                    // Try catch for potential NumberFormatException
                    try
                    {
                        // Take user input and assign info to local variable "input"
                        input = Ui.getUserInput();
                        // Send log information to logger
                        Log.writeToFile(Ui.getLastEvent());
                        // Process if user inputted anything other than "cancel"
                        if (!input.equalsIgnoreCase("cancel"))
                        {
                            // Send user input to total balance (Potential NumberFormatException here)
                            Money.collectMoney(Double.parseDouble(input));
                            // Send log information to logger
                            Log.writeToFile(Money.getLastEvent());
                            // Display to user current balance
                            Ui.setDisplayToUser(String.format("Balance: $%.2f", Money.getBalance()));
                            // Send log information to logger
                            Log.writeToFile(Ui.getLastEvent());
                            // Break awaitingCashInput loop
                            awaitingCashInput = false;
                        }            // Send log information to logger
                        // Process if user inputted "cancel"
                        if (input.equalsIgnoreCase("cancel"))
                        {
                            // Give money back to user
                            Money.takeFromBalance(Money.getBalance());
                            // Send log information to logger
                            Log.writeToFile(Money.getLastEvent());
                            // break awaitingCashInput loop
                            awaitingCashInput = false;
                            // set selecting loop to false so that it returns the program to the beginning of vending
                            selecting = false;
                        }
                    }
                    // If user inputted something other than a number or "cancel" throw exception
                    catch (NumberFormatException e)
                    {
                        // Send log information to logger
                        Log.writeToFile("Number Format Exception Caught");
                    }
                }
                // Selecting in progress
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
                            // Give money back
                            Money.takeFromBalance(Money.getBalance());
                            // Send log information to logger
                            Log.writeToFile(Money.getLastEvent());
                            // Break loop -> End program
                            selecting = false;
                        }
                        else
                        {
                            // Display to user "Insufficient Funds"
                            Ui.setDisplayToUser("Insufficient Funds");
                            // Send log information to logger
                            Log.writeToFile(Ui.getLastEvent());
                            // Break selecting loop, return to beginning of vending while loop
                            selecting = false;
                        }
                    }
                    // Process if user inputted "cancel"
                    else if (selection.equalsIgnoreCase("cancel"))
                    {
                        // Give money back
                        Money.takeFromBalance(Money.getBalance());
                        // Send log information to logger
                        Log.writeToFile(Money.getLastEvent());
                        // Break selecting loop, return to beginning of vending while loop
                        selecting = false;
                    }
                    // Process if user inputted invalid slot ID
                    else if (!Vend.selectSlot(selection))
                    {
                        // Display to user "Invalid ID"
                        Ui.setDisplayToUser("Invalid ID OR Product Out of Stock");
                        // Send log information to logger
                        Log.writeToFile(Ui.getLastEvent());
                    }
                }
            }
        }
    }
}