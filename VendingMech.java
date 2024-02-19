import java.util.HashMap;
import java.util.Map;
public class VendingMech implements Vendable
{
    Slot A1 = new Slot(2.99, 7, "000000000001");
    Slot A2 = new Slot(4.99, 5, "000000000002");
    Slot A3 = new Slot(2.79, 0, "000000000003");
    Map<String, Slot> map = new HashMap<String, Slot>();
    String info;
    public VendingMech()
    {
        loadProductMap();
    }
    public boolean selectSlot(String slotID)
    {
        // set info for getLastEvent to return when called
        info = "selectSlot " + "user inputted slotID: " + slotID;
        // check if user input matches any key in HashMap and return true or false
        return map.containsKey(slotID);
    }
    public void loadProductMap()
    {
        map.put("A1", A1);
        map.put("A2", A2);
        map.put("A3", A3);
    }
    public double getSelectedSlotPrice(String slotID)
    {
        // allow for edits of user inputted selected slot
        Slot selectedSlot = map.get(slotID);
        // set info for getLastEvent to return when called
        info = "getSelectedSlotPrice " + "selected slot: " + slotID + " returned price: " + selectedSlot.getPrice();
        // return price of selected slot
        return selectedSlot.getPrice();
    }

    /*
       Certain checks in main should be incorporated into VendingMech functions, however for them to be done in the
       selectSlot method doesn't make much sense. I believe The checks should be done in separate methods and
       returned as booleans for log and display purposes
    */

    /*
       This function is **CURRENTLY** important for logging and displaying to
       user "out of stock" separately from "invalid id"
    */
    public int getSelectedSlotQuantity(String slotID)
    {
        // allow for edits of user inputted selected slot
        Slot selectedSlot = map.get(slotID);
        // set info for getLastEvent to return when called
        info = "getSelectedSlotQuantity " + "selected slot: " + slotID + " returned quantity: " + selectedSlot.getQuantity();
        // return quantity of selected slot
        return selectedSlot.getQuantity();
    }
    public void dispenseSelectedSlot(String slotID)
    {
        // allow for edits of user inputted selected slot
        Slot selectedSlot = map.get(slotID);
        // set info for getLastEvent to return when called
        info = "dispenseSelectedSlot " + "selected slot: " + slotID + " dispensed";
        selectedSlot.quantity--;
    }
    public String getLastEvent()
    {
        // return info set by other methods
        return info;
    }
}