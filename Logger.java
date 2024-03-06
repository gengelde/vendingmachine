import java.io.FileWriter;
import java.time.LocalDateTime;
import java.io.IOException;
/**
 * The {@code Logger} class provides a simple implementation of the {@code Logable} interface allowing for appending information to a log file.
 * The {@code Logger} class implements the {@code Logable} interface.
 */
public class Logger implements Logable
{
    /**
     * Default constructor for the {@code Logger} class.
     */
    public Logger()
    {

    }
    /**
     * Appends the provided information to a log file.
     * @param info The information to be written to the log.
     * @return {@code true} if the log is successfully created, {@code false} otherwise.
     */
    public Boolean writeToFile(String info)
    {
        try
        {
            FileWriter writer = new FileWriter("log.txt", true);
            // write to log time of log and log 'info'
            writer.write("Log created at " + LocalDateTime.now() + "\tLog Info: " + info);
            // fancy new line -> ("\n")
            writer.write(System.lineSeparator());
            // close writer stream
            writer.close();
            // successful log creation returns true
            return true;
        }
        catch (IOException e)
        {
            // unsuccessful log creation returns false
            return false;
        }
    }
}