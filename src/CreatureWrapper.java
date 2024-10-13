import java.util.List;

public class CreatureWrapper {
    private List<Creature> creatures;

    public CreatureWrapper(List<Creature> creatures) {
        this.creatures = creatures;
    }

    public List<Creature> getCreatures() {
        return creatures;
    }

    public void setCreatures(List<Creature> creatures) {
        this.creatures = creatures;
    }
}
