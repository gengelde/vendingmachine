public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        // create runnable new controller object to use in thread
        Runnable control = new Controller();
        // create new thread using created runnable controller object
        Thread t1 = new Thread(control);
        // execute thread 't1'
        t1.start();
        // process thread before others
        t1.join();
    }
}