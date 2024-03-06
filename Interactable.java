/**
 * The {@code Interactable} interface defines methods for the interaction between the user and the program.
 * The {@code Interactable} interface also defines a method for returning a string set by other methods back to Controller.
 */
public interface Interactable
{
    /**
     * Reads user input from the console using a Scanner.
     */
    String getUserInput();
    /**
     * Sets the display information for the user and prints it to the console.
     * @param display The message to be displayed to the user.
     */
    void setDisplayToUser(String display);
    /**
     * Returns string set by other methods back to Controller to then be sent to the {@code Logger} class for logging purposes.
     */
    String getLastEvent();
}
