import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DataConnect implements Connectable
{
    String info;
    String url = "jdbc:mysql://localhost:3306/vendingdata";
    String user = "root";
    String pass = "pass123";
    public Boolean connect()
    {
        try
        {
            // Connection statement to database
            Connection connection = DriverManager.getConnection(url, user, pass);
            // set info for getLastEvent to return when called
            info = "Connection to database was Successful";
            // SQL statement sent to database
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from customerprofiles");

            while (resultSet.next())
            {
                System.out.println(resultSet.getString("customer_id"));
            }
            return true;
        }
        catch (SQLException e)
        {
            // set info for getLastEvent to return when called
            info = "Connection to database was Unsuccessful";
            return false;
        }
    }
    public String getLastEvent()
    {
        // return info set by other methods
        return info;
    }
}
