import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Marvel extends Creature {

    @JsonProperty("creatures")
    private ArrayList<Creature> creatures;

    public Marvel(ArrayList<Creature> creatures) {
        this.creatures = creatures;
    }

    public ArrayList<Creature> getCreatures() {
        return creatures;
    }

}
