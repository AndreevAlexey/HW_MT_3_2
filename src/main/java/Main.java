import java.util.Random;

public class Main {

    // сгенерировать массив
    static int[] generateSales(int count) {
        Random random = new Random();
        int[] data = new int[count];
        for (int i = 0; i < count; i++) {
            data[i] = random.nextInt(1000);
        }
        return data;
    }

    public static void main(String[] args) throws InterruptedException {
        final int SHOPS_CNT = 3;
        Random random = new Random();
        Shop[] shops = new Shop[SHOPS_CNT];
        Thread[] threads = new Thread[SHOPS_CNT];
        // Магазины
        for(int i = 0; i < SHOPS_CNT; i++) {
            shops[i] = new Shop(generateSales(random.nextInt(20)));
            // Выручка по каждому магазину
            System.out.println("shop"+i+" total = " + shops[i].getSalesSum());
            // потоки подсчета выручки
            threads[i] = new Thread(null, shops[i]::addSaleToTotal);
        }
        // запуск потоков
        for(int i = 0; i < SHOPS_CNT; i++) {
            threads[i].start();
        }
        // ожидание выполнения всех потоков
        for(int i = 0; i < SHOPS_CNT; i++) {
            threads[i].join();
        }
        // вывод результата
        System.out.println("Итого по всем магазинам = " + Shop.Total);
    }
}
