public class Main
{
    public static void main(String[] args)
    {
        Message msg = new Message();

        Runnable control = new Controller(msg);
        Runnable intake = new MoneyIntake(msg);
        Runnable connect = new DataConnect(msg);

        Thread t1 = new Thread(control);
        Thread t2 = new Thread(intake);
        Thread t3 = new Thread(connect);

        try
        {
        t3.start();
        t1.start();
        t2.start();

        t3.join();
        t1.join();
        t2.join();

        }
        catch (InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
    }
}