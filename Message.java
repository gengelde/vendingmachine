/**
 * The {@code Message} class represents a simple container for storing message and name information.
 * This class does not implement an interface.
 */
public class Message
{
    // Initialize Local Variables
    private String msg = "";
    private String name = "";
    /**
     * Default constructor for the {@code Message} class.
     */
    public Message()
    {

    }
    /**
     * Gets the {@code msg} stored in this object.
     * @return {@code msg} as a string.
     */
    public String getMsg()
    {
        // Return 'msg' string back to whichever class it was called by
        return msg;
    }
    /**
     * Gets the {@code name} stored in this object.
     * @return {@code name} as a string.
     */
    public String getName()
    {
        // Return 'name' string back to whichever class it was called by
        return name;
    }
    /**
     * Sets the {@code msg} string for this object.
     * @param str The message to be set.
     */
    public void setMsg(String str)
    {
        // Set string 'msg' equal to string 'str'
        msg = str;
    }
    /**
     * Sets the {@code name} string for this object.
     * @param str The name to be set.
     */
    public void setName(String str)
    {
        // Set string 'name' equal to string 'str'
        name = str;
    }
}
