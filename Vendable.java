import java.util.HashMap;
import java.util.Map;

public interface Vendable
{
    boolean selectSlot(String slotID);
    void loadProductMap();
    double getSelectedSlotPrice(String slotID);
    int getSelectedSlotQuantity(String slotID);
    void dispenseSelectedSlot(String slotID);
    String getLastEvent();
}
