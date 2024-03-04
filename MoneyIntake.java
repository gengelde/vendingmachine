import javax.swing.*;

public class MoneyIntake implements Moneyable, Runnable
{
    double total;
    String info;
    String input;
    boolean running = true;
    private Message msg;
    public MoneyIntake(Message msg)
    {
        this.msg = msg;
    }
    public void run()
    {
        while(running)
        {
            // Display Input Dialog box to user "Insert Cash:"
            input = JOptionPane.showInputDialog(null, "Insert Cash:");
            // Synchronize thread block with other threads synchronized with message class
            synchronized (msg)
            {
                if (input == null)
                {
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
                else
                {
                    msg.setMsg(input);
                    System.out.println(input);
                    msg.setName(null);
                    msg.notify();
                }
            }
        }
    }

    public String getLastEvent()
    {
        // return info set by other methods
        return info;
    }
    public void collectMoney(double money)
    {
        // add user inputted money to total balance in machine
        total = total + money;
        // set info for getLastEvent to return when called
        info = "collectMoney" + " collected: $" + money + " total bal: $" + total;
    }
    public double getBalance()
    {
        // return total balance
        return total;
    }
    public void takeFromBalance(double money)
    {
        // subtract amount from total balance in machine
        total = total - money;
        // set info for getLastEvent to return when called
        info = "takeFromBalance" + "money taken from bal: " + money + " new bal: " + total;
    }
}