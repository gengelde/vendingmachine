/**
 * The {@code Factory} class is responsible for creating instances of classes related to different functionalities.
 * This class does not implement an interface.
 */
public class Factory
{
    // Create instances of classes
    private Interactable Ui;
    private Vendable Vend;
    private Logable Log;
    /**
     * Constructs a {@code Factory} instance and initializes instances of classes related to different functionalities.
     */
    public Factory()
    {
        // Create and initialize objects
        Ui = new UI();
        Vend = new VendingMech();
        Log = new Logger();
    }
    /**
     * Gets the instance of the class implementing the {@code Interactable} interface.
     *
     * @return An instance of the class implementing the {@code Interactable} interface.
     */
    public Interactable getUI()
    {
        // return class 'Ui'
        return Ui;
    }
    /**
     * Gets the instance of the class implementing {@code Logable} interface.
     *
     * @return An instance of the class implementing the {@code Logable} interface.
     */
    public Logable getLog()
    {
        // return class 'Log'
        return Log;
    }
    /**
     * Gets the instance of the class implementing the {@code Vendable} interface.
     *
     * @return An instance of the class implementing the {@code Vendable} interface.
     */
    public Vendable getVend()
    {
        // return class 'Vend'
        return Vend;
    }
}
