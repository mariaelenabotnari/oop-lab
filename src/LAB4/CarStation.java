package LAB4;

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

    void addCar(Car currentCar, Queue<Car> queueCars, Queue<Car> refuelStationQueue, Queue<Car> serviceStationQueue) {

        queueCarsObject.addElementQueue(queueCars, currentCar);
        refuelStationQueueObject.addElementQueue(refuelStationQueue, currentCar);

        if (currentCar.getIsDining()) {
            serviceStationQueue.offer(currentCar);
        }

        queueCars.poll();
    }

    void serveCars(Queue<Car> queueCars, Queue<Car> refuelStationQueue, Queue<Car> serviceStationQueue) {
        while (!refuelStationQueue.isEmpty()) {
            Car car = refuelStationQueue.poll();

            if (car.getType().equals("electric")) {
                electricStation.refuel(car);
                //count.incrementNrElectricCars();
            }
            else {
                gasStation.refuel(car);
                //count.incrementNrGasCars();
            }
            if (car.getIsDining()) {
                if (car.getPassengers().equals("people")) {
                    diningServicePeople.serveDinner(car);
                    //count.incrementNrCarsDined();
                } else {
                    diningServiceRobot.serveDinner(car);
                    //count.incrementNrCarsNotDined();
                }
            }
        }
    }
}
