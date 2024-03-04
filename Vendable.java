import java.util.HashMap;
import java.util.Map;

public interface Vendable
{
    boolean selectSlot(String slotID);
    void loadProductMap();
    double getSelectedSlotPrice();
    String getSelectedSlotID();
    void dispenseSelectedSlot();
    String getLastEvent();
}
