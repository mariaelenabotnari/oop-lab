package LAB4.TASK3;

import LAB4.TASK1.Car;
import LAB4.TASK1.QueueInterface;
import LAB4.TASK2.Dineable;
import LAB4.TASK2.Refuelable;

import java.util.Queue;

public class CarStation {
    private final Dineable diningServicePeople;
    private final Dineable diningServiceRobot;
    private final Refuelable electricStation;
    private final Refuelable gasStation;
    private QueueInterface queueCarsObject;
    private QueueInterface refuelStationQueueObject;
    private QueueInterface serviceStationQueueObject;

    public CarStation(Dineable diningServicePeople, Dineable diningServiceRobot, Refuelable electricStation, Refuelable gasStation, QueueInterface queueCarsObject, QueueInterface refuelStationQueueObject, QueueInterface serviceStationQueueObject) {
        this.diningServicePeople = diningServicePeople;
        this.diningServiceRobot = diningServiceRobot;
        this.electricStation = electricStation;
        this.gasStation = gasStation;
        this.queueCarsObject = queueCarsObject;
        this.refuelStationQueueObject = refuelStationQueueObject;
        this.serviceStationQueueObject = serviceStationQueueObject;
    }

    public void addCar(Car currentCar, Queue<Car> queueCars, Queue<Car> refuelStationQueue, Queue<Car> serviceStationQueue) {

        queueCarsObject.addElementQueue(queueCars, currentCar);
        refuelStationQueueObject.addElementQueue(refuelStationQueue, currentCar);

        if (currentCar.getIsDining()) {
            serviceStationQueue.offer(currentCar);
        }

        queueCars.poll();
    }

    public void serveCars(Queue<Car> queueCars, Queue<Car> refuelStationQueue, Queue<Car> serviceStationQueue) {
        while (!refuelStationQueue.isEmpty()) {
            Car car = refuelStationQueue.poll();

            if (car.getType().equalsIgnoreCase("electric")) {
                electricStation.refuel(car);
            } else {
                gasStation.refuel(car);
            }
            if (car.getIsDining()) {
                if (car.getPassengers().equalsIgnoreCase("people")) {
                    diningServicePeople.serveDinner(car);
                } else {
                    diningServiceRobot.serveDinner(car);
                }
            }
        }
    }
}
