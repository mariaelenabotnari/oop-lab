package LAB1;

import java.util.List;

public class CreatureWrapper {
    private String universeName;
    private List<Creature> creatures;

    public CreatureWrapper(String universeName, List<Creature> creatures) {
        this.creatures = creatures;
    }

    public List<Creature> getCreatures() {
        return creatures;
    }

    public void setCreatures(List<Creature> creatures) {
        this.creatures = creatures;
    }
}
