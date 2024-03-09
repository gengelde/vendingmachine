import java.util.HashMap;
import java.util.Map;

public interface Vendable
{
    boolean selectSlot(String slotID);
    void loadProductMap();
    double getSelectedSlotPrice();
    void dispenseSelectedSlot();
    String getLastEvent();
}
