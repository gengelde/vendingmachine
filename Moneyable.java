public interface Moneyable
{
    String getLastEvent();
    void collectMoney(double money);
    double getBalance();
    void takeFromBalance(double money);

}
