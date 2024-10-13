import java.util.Arrays;

public class Creature {
    private int id;
    private Boolean isHuman;
    private String planet;
    private Integer age;
    private String[] traits;
    private String name;

    public Creature() {}

    public int getId () {
        return id;
    }

    public Boolean getIsHuman () {
        return isHuman;
    }

    public String getPlanet () {
        return planet;
    }

    public Integer getAge () {
        return age;
    }

    public String[] getTraits () {
        return traits;
    }

    public String getName() {
        return name;
    }

    public void setId (int id) {
        this.id = id;
    }

    public void setIsHuman (Boolean isHuman) {
        this.isHuman = isHuman;
    }

    public void setPlanet (String planet) {
        this.planet = planet;
    }

    public void setAge (Integer age) {
        this.age = age;
    }

    public void setTraits (String[] traits) {
        this.traits = traits;
    }

    public void setName (String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Creature{name='" + name + "', planet='" + planet + "', age=" + age +
                ", isHuman=" + isHuman + ", traits=" + Arrays.toString(traits) + "}";
    }
}
