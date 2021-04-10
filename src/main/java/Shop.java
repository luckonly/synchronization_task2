import java.util.ArrayList;
import java.util.List;

public class Shop {

    List<String> carList = new ArrayList<>(10);
    final long SELL_TIME = 1000L;

    public synchronized void addNewCars() {
        carList.add("Audi A5");
        notify();
    }

    public synchronized void sellCar() {

        try {

            if (carList.size() == 0 ) {
                System.out.println(Thread.currentThread().getName() + " вcтал в очередь и ожидает нового автомобиля");
            }

            while (carList.size() == 0) { //Встал в очередь и ожидает нового автомобиля
                wait();
            }

            Thread.sleep(SELL_TIME);
            System.out.println(Thread.currentThread().getName() + " приобрел новенький автомобиль и уехал на нем");
            carList.remove(0);

        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }

    }

}