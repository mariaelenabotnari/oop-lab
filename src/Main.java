import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> traits = new ArrayList<String>();

        Creature Betelgeusian = new Creature();

        Betelgeusian.setIsHuman(true);
        Betelgeusian.setPlanet("BETELGEUSE");
        Betelgeusian.setAge(100);
        Betelgeusian.setTraits(new String[]{"EXTRA_ARMS", "EXTRA_HEAD"});
        Betelgeusian.setName("Betelgeusian");

        System.out.println(Betelgeusian.getIsHuman());
        System.out.println(Betelgeusian.getPlanet());
        System.out.println(Betelgeusian.getAge());

        for (int i = 0; i < Betelgeusian.getTraits().length; i++) {
            traits.add(Betelgeusian.getTraits()[i]);
        }

        System.out.println(traits);
        System.out.println(Betelgeusian.getName());
    }

}
