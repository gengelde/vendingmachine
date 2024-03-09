public class Factory
{
    // Load Classes
    private Moneyable Money;
    private Interactable Ui;
    private Vendable Vend;
    private Logable Log;
    private Connectable Conn;
    public Factory()
    {
        // Load Classes
        Money = new MoneyIntake();
        Ui = new UI();
        Vend = new VendingMech();
        Log = new Logger();
        Conn = new DataConnect();
    }
    public Interactable getUI()
    {
        // return class 'Ui'
        return Ui;
    }
    public Moneyable getMoney()
    {
        // return class 'Money'
        return Money;
    }
    public Logable getLog()
    {
        // return class 'Log'
        return Log;
    }
    public Vendable getVend()
    {
        // return class 'Vend'
        return Vend;
    }
    public Connectable getConn()
    {
        // return class 'Conn'
        return Conn;
    }
}
