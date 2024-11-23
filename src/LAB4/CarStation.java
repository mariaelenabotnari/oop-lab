package LAB4;

import java.util.Queue;

public class CarStation {
    private final Dineable diningServicePeople;
    private final Dineable diningServiceRobot;
    private final Refuelable electricStation;
    private final Refuelable gasStation;


    public CarStation(Dineable diningServicePeople, Dineable diningServiceRobot, Refuelable electricStation, Refuelable gasStation) {
        this.diningServicePeople = diningServicePeople;
        this.diningServiceRobot = diningServiceRobot;
        this.electricStation = electricStation;
        this.gasStation = gasStation;
    }

    void addCar(Queue<Car> queueCars, Queue<Car> refuelStationQueue, Queue<Car> serviceStationQueue) {
        for (Car car : queueCars) {
            refuelStationQueue.offer(car);

            if (car.getIsDining()) {
                serviceStationQueue.offer(car);
            }
        }
    }

    void serveCars(Queue<Car> queueCars, Queue<Car> refuelStationQueue, Queue<Car> serviceStationQueue, CarsCount count) {


        for (Car car : refuelStationQueue) {
            if (car.getType().equals("electric")) {
                electricStation.refuel(car, count);
            }
            else {
                gasStation.refuel(car, count);
            }
            if (car.getIsDining()) {
                if (car.getPassengers().equals("people")) {
                    diningServicePeople.serveDinner(car, count);
                } else {
                    diningServiceRobot.serveDinner(car, count);
                }
            }
            refuelStationQueue.poll();
            serviceStationQueue.poll();
        }
    }
}
