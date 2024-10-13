import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class StarWars extends Creature {

    @JsonProperty("creatures")
    private ArrayList<Creature> creatures;

    public StarWars(ArrayList<Creature> creatures) {
        this.creatures = creatures;
    }

    public ArrayList<Creature> getCreatures() {
        return creatures;
    }

}
