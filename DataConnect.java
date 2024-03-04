import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class DataConnect implements Connectable, Runnable
{
    private Message msg;
    String info;
    String input;
    boolean running = true;
    // String input for database connection url
    final String url = "jdbc:mysql://localhost:3306/vendingdata";
    // String input for database connection username
    final String user = "root";
    // String input for database connection password
    final String pass = "pass123";
    /**
     * Constructs a new instance of {@code DataConnect} with the provided {@code Message}.
     *
     * @param msg The {@code Message} object associated with the data connection.
     */
    public DataConnect(Message msg)
    {
        this.msg = msg;
    }
    // Initialize DataConnect Thread Block
    public void run()
    {
        while(running)
        {
            try
            {
                // Put DataConnect thread to sleep for .8 seconds
                Thread.sleep(800);
            }
            catch (InterruptedException e)
            {
                // Print exception message e to console
                System.out.println(e.getMessage());
            }
            // Display Input Dialog box to user "Enter Face Hash ID:"
            input = JOptionPane.showInputDialog(null, "Enter Face Hash ID:");
            // Synchronize thread block with other threads synchronized with message class
            synchronized (msg)
            {
                // SQL select balance statement
                String selectBalSQL = "SELECT acctBalance FROM customerprofiles WHERE dataFaceHash = " + input + ";";
                // SQL select name statement
                String selectCNameSQL = "SELECT cname FROM customerprofiles WHERE dataFaceHash = " + input + ";";
                try
                {
                    // Connection statement to database
                    Connection connection = DriverManager.getConnection(url, user, pass);
                    // SQL statement sent to database
                    Statement statement = connection.createStatement();
                    // Execute select statement in MYSQl database and fill acctBalance data table with information from database
                    ResultSet acctBalance = statement.executeQuery(selectBalSQL);
                    // Process if acctBalance data table has information
                    if (acctBalance.next())
                    {
                        // Convert user balance from MYSQL database to string and send to msg
                        msg.setMsg(acctBalance.getString("acctBalance"));
                        // Execute select statement in MYSQl database and fill cname data table with information from database
                        ResultSet cname = statement.executeQuery(selectCNameSQL);
                        // Process if cname data table has information
                        if(cname.next())
                        {
                            // Set name variable in Message class to selected name in database
                            msg.setName(cname.getString("cname"));
                            // Notify Controller thread waiter to continue
                            msg.notify();
                            try
                            {
                                // Put DataConnect thread into wait mode until Controller notifies
                                msg.wait();
                            }
                            catch (InterruptedException e)
                            {
                                // Print exception message e to console
                                System.out.println(e.getMessage());
                            }
                            // SQL update balance statement
                            String updateBalSQL = "UPDATE `vendingdata`.`customerprofiles` SET `acctBalance` = '" + msg.getMsg() + "' WHERE (`cname` = '" + msg.getName() + "');";
                            // Execute update statement in MYSQl database and set balance in database
                            statement.executeUpdate(updateBalSQL);
                        }
                    }
                    // Process if acctBalance data table doesn't have information
                    else
                    {
                        try
                        {
                            // Put DataConnect thread to sleep for 5 seconds
                            Thread.sleep(5000);
                        }
                        catch (InterruptedException e)
                        {
                            // Print exception message e to console
                            System.out.println(e.getMessage());
                        }
                    }
                }
                catch (SQLException e)
                {
                    // Print exception message e to console
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    /**
     * Attempts to establish a connection to the database using the provided URL, username, and password.
     *
     * @return {@code true} if the connection is successful, {@code false} if the connection is unsuccessful
     */
    public Boolean connect()
    {
        try
        {
            // Connection statement to database
            DriverManager.getConnection(url, user, pass);
            // set info for getLastEvent to return when called
            info = "Connection to database was Successful";
            return true;
        }
        catch (SQLException e)
        {
            // set info for getLastEvent to return when called
            info = "Connection to database was Unsuccessful";
            return false;
        }
    }

    /**
     *
     * @return {@code info} string set by other methods back to {@code Controller} class
     */
    public String getLastEvent()
    {
        // return info set by other methods
        return info;
    }
}
