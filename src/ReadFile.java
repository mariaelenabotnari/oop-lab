import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {

    public void readFile () {
        ObjectMapper jsonObject = new ObjectMapper();
        ArrayList<Creature> creatures = new ArrayList<>();
        ArrayList<Creature> creaturesEx = new ArrayList<>();

        ArrayList<String> Marvel = new ArrayList<>();
        Marvel.add("Asgardian");
        ArrayList<Creature> MarvelCreatures = new ArrayList<>();

        ArrayList<String> StarWars = new ArrayList<>();
        StarWars.add("Wookie");
        StarWars.add("Ewok");
        ArrayList<Creature> StarWarsCreatures = new ArrayList<>();

        ArrayList<String> Hitchhiker = new ArrayList<>();
        Hitchhiker.add("Betelgeusian");
        Hitchhiker.add("Vogons");
        ArrayList<Creature> HitchhikerCreatures = new ArrayList<>();

        ArrayList<String> LordOfTheRings = new ArrayList<>();
        LordOfTheRings.add("Elf");
        LordOfTheRings.add("Dwarf");
        ArrayList<Creature> LordOfTheRingCreatures = new ArrayList<>();

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

        System.out.println(creatures);
        HitchhikerEx Betelgeusian = new HitchhikerEx();
        Betelgeusian.setIsHuman(true);
        Betelgeusian.setPlanet("Betelgeuse");
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
        Wookie.setPlanet("Kashyyyk");
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

        for (Creature creature : creatures) {
            for (Creature creatureEx : creaturesEx) {
                int criteriaMet = 0;
                int nrFields = 0;

                if (creature.getPlanet() != null) {
                    nrFields++;
                }

                if (creature.getPlanet() != null && creatureEx.getPlanet() != null && creature.getPlanet().equals(creatureEx.getPlanet())) {
                    criteriaMet++;
                }

                if (creature.getIsHuman() != null) {
                    nrFields++;
                }

                if (creature.getIsHuman() != null && creatureEx.getIsHuman() != null) {
                    if (creature.getIsHuman().equals(creatureEx.getIsHuman())) {
                        criteriaMet++;
                    }
                }

                if (creature.getAge() != null) {
                    nrFields++;
                }

                if (creature.getAge() != null && creatureEx.getAge() != null && creature.getAge() <= creatureEx.getAge()) {
                    criteriaMet++;
                }

                int traitMatch = 0;
                if (creature.getTraits() != null && creatureEx.getTraits() != null) {
                    nrFields++;

                    int nrTraits = creature.getTraits().length;

                    if (nrTraits == 1) {
                        for (String traitEx : creatureEx.getTraits()) {
                            if (creature.getTraits()[0].equals(traitEx)) {
                                traitMatch++;
                                break;
                            }
                        }
                    } else if (nrTraits == 2) {
                        for (String trait : creature.getTraits()) {
                            boolean matchFound = false;
                            for (String traitEx : creatureEx.getTraits()) {
                                if (trait.equals(traitEx)) {
                                    matchFound = true;
                                    break;
                                }
                            }
                            if (matchFound) {
                                traitMatch++;
                            }
                        }
                    }

                    if (nrTraits == 1 && traitMatch == 1) {
                        criteriaMet++;
                    } else if (nrTraits == 2 && traitMatch == 2 && creatureEx.getTraits().length == 2) {
                        criteriaMet++;
                    }
                }

                if (criteriaMet == nrFields) {
                    if (Marvel.contains(creatureEx.getName())) {
                        MarvelCreatures.add(creature);

                    } else if (StarWars.contains(creatureEx.getName())) {
                        StarWarsCreatures.add(creature);

                    } else if (LordOfTheRings.contains(creatureEx.getName())) {
                        LordOfTheRingCreatures.add(creature);

                    } else if (Hitchhiker.contains(creatureEx.getName())) {
                        HitchhikerCreatures.add(creature);
                    }

                    creature.setName(creatureEx.getName());
                }
            }
        }

        System.out.println("\nCreatures from Star Wars Universe: ");
        System.out.println(StarWarsCreatures);
        System.out.println("\nCreatures from Lord of the Rings Universe: ");
        System.out.println(LordOfTheRingCreatures);
        System.out.println("\nCreatures from Hitchhiker Universe: ");
        System.out.println(HitchhikerCreatures);
        System.out.println("\nCreatures from Marvel Universe: ");
        System.out.println(MarvelCreatures);

        jsonObject.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            jsonObject.writeValue(new File("marvel.json"), new CreatureWrapper(MarvelCreatures));
            jsonObject.writeValue(new File("starwars.json"), new CreatureWrapper(StarWarsCreatures));
            jsonObject.writeValue(new File("lordOfTheRings.json"), new CreatureWrapper(LordOfTheRingCreatures));
            jsonObject.writeValue(new File("hitchhiker.json"), new CreatureWrapper(HitchhikerCreatures));

            System.out.println("\nJSON data written successfully to files.");

        } catch (IOException e) {
            System.out.println("\nError writing JSON data to files.");
            throw new RuntimeException(e);
        }
    }
}
