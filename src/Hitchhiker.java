import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Hitchhiker extends Creature {

    @JsonProperty("creatures")
    private ArrayList<Creature> creatures;

    public Hitchhiker(ArrayList<Creature> creatures) {
        this.creatures = creatures;
    }

    public ArrayList<Creature> getCreatures() {
        return creatures;
    }

}
