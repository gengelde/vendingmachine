import java.util.Scanner;
/**
 * The {@code UI} class handles user interaction, reading input, and displaying information.
 * The {@code UI} class implements the {@code Interactable} interface.
 */
public class UI implements Interactable
{
    // Initialize Local Variables
    String info;
    String input;
    Scanner scan;
    /**
     * Default constructor for the {@code UI} class.
     */
    public UI()
    {

    }
    /**
     * Reads user input from the console using a Scanner.
     * @return {@code input} as a String.
     */
    public String getUserInput()
    {
        // create scanner to read user input
        scan = new Scanner(System.in);
        // send inputted information to local variable String input
        input = scan.nextLine();
        // set info for getLastEvent to return when called
        info = "getUserInput" + "user inputted: " + input;
        // return user input
        return input;
    }
    /**
     * Sets the display information for the user and prints it to the console.
     * @param display The message to be displayed to the user.
     */
    public void setDisplayToUser(String display)
    {
        // display local variable 'display' information to user
        System.out.println(display);
        // set info for getLastEvent to return when called
        info = "setDisplayToUser" + "displayed: '" + display +"' to user";
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