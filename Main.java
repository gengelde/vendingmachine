/**
 * The {@code Main} class serves as the entry point for the vending machine simulation.
 * It creates and starts threads for the controller, money intake, and data connection functionality.
 */
public class Main
{
    public static void main(String[] args)
    {
        // Create a shared message object
        Message msg = new Message();
        // Create instances of threads for controller, money intake, and data connection
        Runnable control = new Controller(msg);
        Runnable intake = new MoneyIntake(msg);
        Runnable connect = new DataConnect(msg);
        // Create threads
        Thread t1 = new Thread(control);
        Thread t2 = new Thread(intake);
        Thread t3 = new Thread(connect);
        try
        {
            // Start the threads
            t3.start();
            t1.start();
            t2.start();
            // Wait for threads to finish
            t3.join();
            t1.join();
            t2.join();
        }
        catch (InterruptedException e)
        {
            // Print exception message e to console
            System.out.println(e.getMessage());
        }
    }
}