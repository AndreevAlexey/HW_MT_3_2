import java.util.concurrent.atomic.LongAdder;

public class Shop {
    static LongAdder Total = new LongAdder();
    int[] sales;
    // конструктор
    public Shop(int[] sales) {
        this.sales = sales;
    }
    // добавить выручку в общий показатель
    public void addSaleToTotal() {
        for(int i : sales) {
            Total.add(i);
        }
        Total.sum();
    }
    // выручка по магазину
    public int getSalesSum() {
        int rez = 0;
        for(int i : sales) {
            rez += i;
        }
        return rez;
    }
}
