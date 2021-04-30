package zoo;

public class Main {

    public static void main(String[] argv) {

        String configtype = argv[0];
        String configfile = argv[1];
        Zoo zoo = new Zoo();

        switch (configtype) {
            case ("-configtype=xml"):
                configtype = "xml";
                break;
            case ("-configtype=json"):
                configtype = "json";
                break;
            default: {
                System.out.println("Parametrs are inccorect!");
                System.exit(0);
            }
            ;

        }

        configfile.replace("-config", "");

        switch (configtype) {
            case ("xml"):
                zoo.addXmlAnimals(configfile);
                break;
            case ("json"):
                zoo.addJsonAnimals(configfile);
                break;
        }

        ActionTrigger trigger = new ActionTrigger(zoo);

        AnimalType herbivore = AnimalType.HERBIVORE;
        AnimalType carnivore = AnimalType.CARNIVORE;

        // All of the following actions are up to users choice
        zoo.printAllStates();
        trigger.setMorning();
        zoo.printAllStates();

        trigger.visit(herbivore);
        zoo.printAllStates();
//        trigger.visit(carnivore);
        trigger.feedAnimals(herbivore);
        zoo.printAllStates();

        trigger.drinkingAnimals(herbivore);
        zoo.printAllStates();

        trigger.drinkingAnimals(carnivore);
        zoo.printAllStates();

        trigger.setNight();
        zoo.printAllStates();

        trigger.setMorning();
        zoo.printAllStates();

        trigger.setThunder();
        zoo.printAllStates();
        trigger.feedAnimals(carnivore);
        zoo.printAllStates();

        trigger.feedAnimals(herbivore);
        zoo.printAllStates();
        trigger.feedAnimals(herbivore);
        zoo.printAllStates();
        trigger.setRain();
        zoo.printAllStates();
        trigger.setNight();
        zoo.printAllStates();

        trigger.setMorning();
        zoo.printAllStates();
    }
}