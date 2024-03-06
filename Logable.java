/**
 * The {@code Logable} interface defines a method for the logging process of sent information.
 */
public interface Logable
{
    /**
     * Appends the provided information to a log file.
     * @param info The information to be written to the log.
     */
    Boolean writeToFile(String info);
}
