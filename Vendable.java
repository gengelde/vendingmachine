/**
 * The {@code Vendable} interface defines methods for the internal vending process in the vending machine.
 * The {@code Vendable} interface also defines a method for returning a string set by other methods back to Controller.
 */
public interface Vendable
{
    /**
     * Selects a vending machine slot based on the provided slot identifier.
     * @param slotID The identifier of the vending machine slot to be selected.
     * @return {@code true} if the slot is successfully selected and available, {@code false} otherwise.
     */
    boolean selectSlot(String slotID);
    /**
     * Loads product slots into the internal map for the vending machine.
     */
    void loadProductMap();
    /**
     * Retrieves the price of the product associated with the selected vending machine slot.
     * @return The price of the product in the selected vending machine slot.
     */
    double getSelectedSlotPrice();
    /**
     * Retrieves the product ID associated with the selected vending machine slot.
     * @return The product ID of the selected vending machine slot.
     */
    String getSelectedSlotID();
    /**
     * Dispenses an item from the selected vending machine slot.
     */
    void dispenseSelectedSlot();
    /**
     * Returns string set by other methods back to Controller to then be sent to the {@code Logger} class for logging purposes.
     */
    String getLastEvent();
}
