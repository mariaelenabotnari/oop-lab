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
            System.out.println(creatures.get(i).toString());
        }
    }
}
