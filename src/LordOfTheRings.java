import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class LordOfTheRings extends Creature {

    @JsonProperty("creatures")
    private ArrayList<Creature> creatures;

    public LordOfTheRings(ArrayList<Creature> creatures) {
        this.creatures = creatures;
    }

    public ArrayList<Creature> getCreatures() {
        return creatures;
    }

}
