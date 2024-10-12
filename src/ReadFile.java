import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {

    public void readFile () {
        ObjectMapper jsonObject = new ObjectMapper();
        ArrayList<Creature> creatures = new ArrayList<>();
        ArrayList<Creature> creaturesEx = new ArrayList<>();

        try {
            File inputDataFile = new File("C:\\Users\\maria\\IdeaProjects\\firstproject\\src\\input.json");
            Scanner readInputFile = new Scanner(inputDataFile);
            String dataVisitors = readInputFile.useDelimiter("\\Z").next();
            JsonNode rootNode;

            try {
                rootNode = jsonObject.readTree(dataVisitors);
            } catch (JsonProcessingException e) {
                System.out.println("Error processing JSON: " + e.getMessage());
                return;
            }

            JsonNode jsonArray = rootNode.get("input");
            if (jsonArray == null) {
                System.out.println("Error: 'input' array not found in the JSON.");
                return;
            }

            for (int i = 0; i < jsonArray.size(); i++) {
                JsonNode jsonCreatureObject = jsonArray.get(i);

                int idValue = jsonCreatureObject.get("id").asInt();
                Boolean isHumanValue = jsonCreatureObject.has("isHumanoid") ? jsonCreatureObject.get("isHumanoid").asBoolean() : null;
                String planetValue = jsonCreatureObject.has("planet") ? jsonCreatureObject.get("planet").asText() : null;
                Integer ageValue = jsonCreatureObject.has("age") ? jsonCreatureObject.get("age").asInt() : null;
                String nameValue = jsonCreatureObject.has("name") ? jsonCreatureObject.get("name").asText() : "Unknown";

                JsonNode traits = jsonCreatureObject.get("traits");
                String[] traitsArray = traits != null ? new String[traits.size()] : null;
                if (traits != null) {
                    for (int k = 0; k < traits.size(); k++) {
                        traitsArray[k] = traits.get(k).asText();
                    }
                }

                Creature newCreature = new Creature();
                newCreature.setId(idValue);
                newCreature.setIsHuman(isHumanValue);
                newCreature.setPlanet(planetValue);
                newCreature.setAge(ageValue);
                newCreature.setTraits(traitsArray);
                newCreature.setName(nameValue);

                creatures.add(newCreature);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        for (int i = 0; i < creatures.size(); i++) {
            if (creatures.get(i).getId() % 2 == 0) {
                System.out.println(creatures.get(i).toString());
            }
        }
        HitchhikerEx Betelgeusian = new HitchhikerEx();
        Betelgeusian.setIsHuman(true);
        Betelgeusian.setPlanet("BETELGEUSE");
        Betelgeusian.setAge(100);
        Betelgeusian.setTraits(new String[]{"EXTRA_ARMS", "EXTRA_HEAD"});
        Betelgeusian.setName("Betelgeusian");

        HitchhikerEx Vogons = new HitchhikerEx();
        Vogons.setIsHuman(false);
        Vogons.setPlanet("Vogsphere");
        Vogons.setAge(200);
        Vogons.setTraits(new String[]{"GREEN", "BULKY"});
        Vogons.setName("Vogons");

        LordOfTheRingsEx Elf = new LordOfTheRingsEx();
        Elf.setIsHuman(true);
        Elf.setPlanet("Earth");
        Elf.setAge(1000000);
        Elf.setTraits(new String[]{"BLONDE", "POINTY_EARS"});
        Elf.setName("Elf");

        LordOfTheRingsEx Dwarf = new LordOfTheRingsEx();
        Dwarf.setIsHuman(true);
        Dwarf.setPlanet("Earth");
        Dwarf.setAge(200);
        Dwarf.setTraits(new String[]{"SHORT", "BULKY"});
        Dwarf.setName("Dwarf");

        StarWarsEx Wookie = new StarWarsEx();
        Wookie.setIsHuman(false);
        Wookie.setPlanet("Kashyyk");
        Wookie.setAge(400);
        Wookie.setTraits(new String[]{"HAIRY", "TALL"});
        Wookie.setName("Wookie");

        StarWarsEx Ewok = new StarWarsEx();
        Ewok.setIsHuman(false);
        Ewok.setPlanet("Endor");
        Ewok.setAge(60);
        Ewok.setTraits(new String[]{"SHORT", "HAIRY"});
        Ewok.setName("Ewok");

        MarvelEx Asgardian = new MarvelEx();
        Asgardian.setIsHuman(true);
        Asgardian.setPlanet("Asgard");
        Asgardian.setAge(5000);
        Asgardian.setTraits(new String[]{"BLONDE", "TALL"});
        Asgardian.setName("Asgardian");

        creaturesEx.add(Betelgeusian);
        creaturesEx.add(Vogons);
        creaturesEx.add(Elf);
        creaturesEx.add(Dwarf);
        creaturesEx.add(Wookie);
        creaturesEx.add(Ewok);
        creaturesEx.add(Asgardian);

    }
}
