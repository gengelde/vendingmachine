import java.util.HashMap;
import java.util.Map;
public class VendingMech implements Vendable
{
    Slot A1 = new Slot(2.99, 7, "000000000001");
    Slot A2 = new Slot(4.99, 5, "000000000002");
    Slot A3 = new Slot(2.79, 0, "000000000003");
    Map<String, Slot> map = new HashMap<String, Slot>();
    String info;
    String selectedID;
    public VendingMech()
    {
        loadProductMap();
    }
    public boolean selectSlot(String slotID)
    {
        selectedID = slotID;
        if (map.containsKey(slotID))
        {
            // allow for edits of user inputted selected slot
            Slot selectedSlot = map.get(slotID);

            if (selectedSlot.getQuantity() < 1)
            {
                // set info for getLastEvent to return when called
                info = "selectSlot " + "user inputted slotID: " + slotID;
                return false;
            }
            return true;
        }
        // set info for getLastEvent to return when called
        info = "selectSlot " + "user inputted slotID: " + slotID;
        // check if user input matches any key in HashMap and return true or false
        return false;
    }
    public void loadProductMap()
    {
        map.put("A1", A1);
        map.put("A2", A2);
        map.put("A3", A3);
    }
    public double getSelectedSlotPrice()
    {
        // allow for edits of user inputted selected slot
        Slot selectedSlot = map.get(selectedID);
        // set info for getLastEvent to return when called
        info = "getSelectedSlotPrice " + "selected slot: " + selectedID + " returned price: " + selectedSlot.getPrice();
        // return price of selected slot
        return selectedSlot.getPrice();
    }
    public void dispenseSelectedSlot()
    {
        // allow for edits of user inputted selected slot
        Slot selectedSlot = map.get(selectedID);
        // set info for getLastEvent to return when called
        info = "dispenseSelectedSlot " + "selected slot: " + selectedID + " dispensed";
        selectedSlot.quantity--;
    }
    public String getLastEvent()
    {
        // return info set by other methods
        return info;
    }
}