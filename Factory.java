public class Factory
{
    // Load Classes
    private Interactable Ui;
    private Vendable Vend;
    private Logable Log;
    public Factory()
    {
        // Load Classes
        Ui = new UI();
        Vend = new VendingMech();
        Log = new Logger();
    }
    public Interactable getUI()
    {
        // return class 'Ui'
        return Ui;
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
}
