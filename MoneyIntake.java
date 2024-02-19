public class MoneyIntake implements Moneyable
{
    double total;
    String info;
    public MoneyIntake()
    {

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