package LAB4.TASK1;

public class Car {
    private int id;
    private String type;
    private String passengers;
    private Boolean isDining;
    private int consumption;

    public Car (int id, String type, String passengers, Boolean isDining, int consumption) {
        this.id = id;
        this.type = String.valueOf(type);
        this.passengers = passengers;
        this.isDining = isDining;
        this.consumption = consumption;
    }

    public Car() {}

    @Override
    public String toString() {
        return "Car {id=" + id + ", type='" + type + "', passengers='" + passengers + "'}";
    }

    public int getId () {
        return id;
    }

    public String getType () {
        return type;
    }

    public String getPassengers () {
        return passengers;
    }

    public Boolean getIsDining () {
        return isDining;
    }

    public int getConsumption () {
        return consumption;
    }

    public void setId (int id) {
        this.id = id;
    }

    public void setType (String type) {
        this.type = type;
    }

    public void setPassengers (String passengers) {
        this.passengers = passengers;
    }

    public void setIsDining (Boolean isDining) {
        this.isDining = isDining;
    }

    public void setConsumption (int consumption) {
        this.consumption = consumption;
    }
}
