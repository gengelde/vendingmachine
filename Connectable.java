/**
 * The {@code Connectable} interface defines a method for the connection to the MYSQL database.
 * The {@code Connectable} interface also defines a method for returning a string set by other methods back to Controller.
 */
public interface Connectable
{
    /**
     * Attempts to establish a connection to the database.
     */
    Boolean connect();
    /**
     * Returns string set by other methods back to Controller to then be sent to the {@code Logger} class for logging purposes.
     */
    String getLastEvent();
}
