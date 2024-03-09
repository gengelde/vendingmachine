import java.io.FileWriter;
import java.time.LocalDateTime;
import java.io.IOException;
public class Logger implements Logable
{
    public Logger()
    {

    }
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