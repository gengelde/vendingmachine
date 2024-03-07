import java.util.HashMap;
import java.util.Map;
/**
 * The {@code VendingMech} class represents a vending machine and manages the product slots.
 * The {@code VendingMech} class implements the {@code Vendable} interface.
 */
public class VendingMech implements Vendable
{
    // Create instances of classes and Initialize Local Variables
    Slot A1 = new Slot(2.99, 7, "11111111");
    Slot A2 = new Slot(4.99, 5, "22222222");
    Slot A3 = new Slot(2.79, 0, "33333333");
    Map<String, Slot> map = new HashMap<String, Slot>();
    String info;
    String selectedID;
    Slot selectedSlot;
    /**
     * Default constructor for the {@code VendingMech} class.
     * Creates an instance of the {@code VendingMech} class and initializes it by loading product slots into the internal map.
     */
    public VendingMech()
    {
        // Call method to populate the internal map
        loadProductMap();
    }
    /**
     * Selects a vending machine slot based on the provided slot identifier.
     * @param slotID The identifier of the vending machine slot to be selected.
     * @return {@code true} if the slot is successfully selected and available, {@code false} otherwise.
     */
    public boolean selectSlot(String slotID)
    {
        // Set string 'selectedID' equal to string 'slotID'
        selectedID = slotID;
        // Process if user input matches any key in HashMap
        if (map.containsKey(slotID))
        {
            // allow for edits of user inputted selected slot
            selectedSlot = map.get(slotID);
            // Process if slot quantity is less than 1
            if (selectedSlot.getQuantity() < 1)
            {
                // set info for getLastEvent to return when called
                info = "selectSlot " + "user inputted slotID: " + slotID;
                // Return selectSlot boolean method back to controller as false
                return false;
            }
            // Return selectSlot boolean method back to controller as true
            return true;
        }
        // set info for getLastEvent to return when called
        info = "selectSlot " + "user inputted slotID: " + slotID;
        // Return selectSlot boolean method back to controller as false
        return false;
    }

    /**
     * Loads product slots into the internal map for the vending machine.
     */
    public void loadProductMap()
    {
        // Populate the internal map with vending machine slots
        map.put("A1", A1);
        map.put("A2", A2);
        map.put("A3", A3);
    }

    /**
     * Retrieves the price of the product associated with the selected vending machine slot.
     * @return The price of the product in the selected vending machine slot.
     */
    public double getSelectedSlotPrice()
    {
        // allow for edits of user inputted selected slot
        Slot selectedSlot = map.get(selectedID);
        // set info for getLastEvent to return when called
        info = "getSelectedSlotPrice " + "selected slot: " + selectedID + " returned price: " + selectedSlot.getPrice();
        // return price of selected slot
        return selectedSlot.getPrice();
    }

    /**
     * Retrieves the product ID associated with the selected vending machine slot.
     * @return The product ID of the selected vending machine slot.
     */
    public String getSelectedSlotID()
    {
        // allow for edits of user inputted selected slot
        Slot selectedSlot = map.get(selectedID);
        // set info for getLastEvent to return when called
        info = "getSelectedSlotID " + "selected slot: " + selectedID + " returned id: " + selectedSlot.getProdID();
        // return product ID of selected slot
        return selectedSlot.getProdID();
    }
    /**
     * Dispenses an item from the selected vending machine slot.
     */
    public void dispenseSelectedSlot()
    {
        // allow for edits of user inputted selected slot
        Slot selectedSlot = map.get(selectedID);
        // set info for getLastEvent to return when called
        info = "dispenseSelectedSlot " + "selected slot: " + selectedID + " dispensed";
        selectedSlot.quantity--;
    }
    /**
     * Returns info string set by other methods back to Controller to then be sent to the {@code Logger} class for logging purposes.
     *
     * @return {@code info} string set by other methods back to {@code Controller} class
     */
    public String getLastEvent()
    {
        // return info set by other methods
        return info;
    }
}