package equipment;


import equipment.cardiotypes.*;
import equipment.flooringtypes.FlooringMatsEquipment;
import equipment.flooringtypes.InterlockingEquipment;
import equipment.grouptrainingtypes.GroupCyclingEquipment;
import equipment.grouptrainingtypes.GroupFunctionalEquipment;
import equipment.grouptrainingtypes.HiitEquipment;
import equipment.grouptrainingtypes.RowersEquipment;
import equipment.strenghttypes.*;
import equipment.vibrationtrainingtypes.HypersphereEquipment;
import equipment.vibrationtrainingtypes.PersonalPowerPlatesEquipment;
import equipment.vibrationtrainingtypes.Vyper2Equipment;


import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EquipmentDatabase {
    private final List<Equipment> equipmentDatabase = new ArrayList<>();
    private final Scanner scannerText = new Scanner(System.in);
    private final Scanner scannerNumber = new Scanner(System.in);
    private static final String equipmentPath = "C:\\Users\\Administrator\\IdeaProjects\\Jim\\src\\main\\java\\resources\\equipments.txt";

    public EquipmentDatabase() {
        try {
            File file = new File(equipmentPath);
            FileReader reader = new FileReader(file);
            BufferedReader bf = new BufferedReader(reader);
            String rand;
            while ((rand = bf.readLine()) != null){
                List<String> name = List.of(rand.split("`"));
                System.out.println(name.get(1));

                equipmentDatabase.add(returnEquipmentType(name));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Equipment returnEquipmentType(List<String> type) {
        Equipment equipment;
        switch (type.get(2)){
            case "Cardio" : equipment = returnEquipmentCardioType(type);break;
            case "Flooring" : equipment = returnEquipmentFlooringType(type);break;
            case "Group Training" : equipment = returnEquipmentGroupTrainingType(type);break;
            case "Strenght" : equipment = returnEquipmentStrenghtType(type);break;
            case "Vibration Training" : equipment = returnEquipmentVibrationTrainingType(type);break;
            default:
                System.out.println("Group not found");
                equipment = new EllipticastAndCrossTrainerEquipment();
        }
        equipment.setName(type.get(0));
        equipment.defineGroupField();
        equipment.defineTypeField();
        equipment.setCleaningInterval(Integer.valueOf(type.get(3)));
        LocalDate date = LocalDate.parse(type.get(4));
        equipment.setDateLastClean(date);
        equipment.setMaxUsage(Integer.valueOf(type.get(5)));
        date = LocalDate.parse(type.get(6));
        equipment.setDateLastCheck(date);
        return equipment;
    }
    private Equipment returnEquipmentVibrationTrainingType(List<String> type){
        Equipment equipment;
        switch (type.get(1)){
            case "Hypersphere" : equipment = new HypersphereEquipment();break;
            case "PersonalPower" : equipment = new PersonalPowerPlatesEquipment();break;
            case "Vyper 2" : equipment = new Vyper2Equipment();break;
            default:
                System.out.println("Type not found");
                equipment = new HypersphereEquipment();
        }
        return equipment;
    }

    private Equipment returnEquipmentStrenghtType(List<String> type){
        Equipment equipment;
        switch (type.get(1)){
            case "Bars" : equipment = new BarsEqupment();break;
            case "Benches" : equipment = new BenchesEquipment();break;
            case "Cybex" : equipment = new CybexEquipment();break;
            case "Dumbells" : equipment = new DumbellsEquipment();break;
            case "Free Weights" : equipment = new FreeWeightsEquipment();break;
            case "Functional Trainers" : equipment = new FunctionalTrainersEquipment();break;
            case "Pilates" : equipment = new PilatesEquipment();break;
            case "Plates" : equipment = new PlatesEquipment();break;
            case "Selectorized" : equipment = new SelectorizedEquipment();break;
            case "Storeage Racks" : equipment = new StoreageRacksEquipment();break;
            default:
                System.out.println("Type not found");
                equipment = new BarsEqupment();
        }
        return equipment;
    }

    private Equipment returnEquipmentGroupTrainingType(List<String> type){
        Equipment equipment;
        switch (type.get(1)){
            case "Group Cycling" : equipment = new GroupCyclingEquipment();break;
            case "Group Functional" : equipment = new GroupFunctionalEquipment();break;
            case "Hiit" : equipment = new HiitEquipment();break;
            case "Rowers" : equipment = new RowersEquipment();break;
            default:
                System.out.println("Type not found");
                equipment = new GroupCyclingEquipment();
        }
        return equipment;
    }

    private Equipment returnEquipmentFlooringType(List<String> type){
        Equipment equipment;
        switch (type.get(1)){
            case "Flooring Mats" : equipment = new FlooringMatsEquipment();break;
            case "Interlocking" : equipment = new InterlockingEquipment();break;
            default:
                System.out.println("Type not found");
                equipment = new FlooringMatsEquipment();
        }
        return equipment;
    }

    private Equipment returnEquipmentCardioType(List<String> type){
        Equipment equipment;
        switch (type.get(1)){
            case "Elipticas & Cross Trainers" : equipment = new EllipticastAndCrossTrainerEquipment();break;
            case "Exercise Bikes" : equipment = new ExerciseBikesEquipment();break;
            case "Indoor Cycles" : equipment = new IndoorCyclesEquipment();break;
            case "Recumbent Bikes" : equipment = new RecumbentBikesEquipment();break;
            case "Rowing Machine" : equipment = new RowingMachineEquipment();break;
            case "Stair Climbers And Steppers" : equipment = new StairClimbersAndSteppersEquipment();break;
            case "Treadmill" : equipment = new TreadmillEquipment();break;
            case "Upright Bike" : equipment = new UprightBikeEquipment();break;
            default:
                System.out.println("Type not found");
                equipment = new EllipticastAndCrossTrainerEquipment();
        }
        return equipment;
    }

    public void menuInsertEquipment() {
        int option;
        do {
            groupMenu();
            option = scannerNumber.nextInt();
            switchMenu(option);
        } while (option != 6);
    }

    private void groupMenu() {
        System.out.println("===Menu===");
        System.out.println("1.Cardio");
        System.out.println("2.Flooring");
        System.out.println("3.GroupTraining");
        System.out.println("4.Strenght");
        System.out.println("5.VibrationTraining");
        System.out.println("6.Exit");
        System.out.println("Choose group:");
    }

    private void switchMenu(int opt) {
        switch (opt) {
            case 1 -> cardioTypeMenu();
            case 2 -> flooringTypeMenu();
            case 3 -> groupTrainingTypeMenu();
            case 4 -> strenghtTypeMenu();
            case 5 -> vibrationTrainingTypeMenu();
            case 6 -> saveEquipments();
            default -> System.out.println("Invalid option!");
        }
    }

    private void saveEquipments() {
        List<StringBuilder> listOfEquiopments = equipmentDatabase.stream()
                .map(equip -> {
                    StringBuilder temp = new StringBuilder();
                    temp.append(equip.getName()).append("`").append(equip.getType()).append("`").append(equip.getGroup())
                            .append("`").append(equip.getCleaningInterval()).append("`").append(equip.getDateLastClean())
                            .append("`").append(equip.getMaxUsage()).append("`").append(equip.getDateLastCheck());
                    return temp;
                }).collect(Collectors.toList());

        StringBuilder textTowrite = new StringBuilder();

        for (StringBuilder equiopment : listOfEquiopments) {
            textTowrite.append(equiopment).append("\n");
        }

        try {
            FileWriter saveEquiopments = new FileWriter(equipmentPath);
            saveEquiopments.write(String.valueOf(textTowrite));
            saveEquiopments.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void cardioTypeMenu() {
        int option;
        do {
            System.out.println("===Cardio Menu===");
            System.out.println("1.Elipticas & Cross Trainers");
            System.out.println("2.Exercise Bikes");
            System.out.println("3.Indoor Cycles");
            System.out.println("4.Recumbent Bikes");
            System.out.println("5.Rowing Machine");
            System.out.println("6.Stair Climbers And Steppers");
            System.out.println("7.Treadmill");
            System.out.println("8.Upright Bike");
            System.out.println("9.Return to main menu");
            System.out.println("Choose Type:");
            option = scannerNumber.nextInt();
            cardioAddEquipment(option);
        } while (option != 9);
    }

    private void cardioAddEquipment(int option) {
        Equipment newEquipment = null;
        switch (option) {
            case 1 -> newEquipment = new EllipticastAndCrossTrainerEquipment();
            case 2 -> newEquipment = new ExerciseBikesEquipment();
            case 3 -> newEquipment = new IndoorCyclesEquipment();
            case 4 -> newEquipment = new RecumbentBikesEquipment();
            case 5 -> newEquipment = new RowingMachineEquipment();
            case 6 -> newEquipment = new StairClimbersAndSteppersEquipment();
            case 7 -> newEquipment = new TreadmillEquipment();
            case 8 -> newEquipment = new UprightBikeEquipment();
            case 9 -> System.out.println("Returned To Main Menu");
            default -> System.out.println("Invalid option!");
        }
        if (newEquipment != null) {
            addEquipmentToList(newEquipment);
        }
    }

    private void addEquipmentToList(Equipment equipment) {
        System.out.println("Enter Equipment name ");
        String name = scannerText.nextLine();
        equipment.setName(name);
        equipment.defineGroupField();
        equipment.defineTypeField();
        equipment.setDateLastClean(LocalDate.now());
        System.out.println("Introdu numarul de zile pana la curatare:");
        int days = scannerNumber.nextInt();
        equipment.setCleaningInterval(days);
        equipment.setDateLastCheck(LocalDate.now());
        System.out.println("Introdu numarul de zile pana la reparatii:");
        int repair = scannerNumber.nextInt();
        equipment.setMaxUsage(repair);
        equipmentDatabase.add(equipment);
    }

    private void flooringTypeMenu() {
        int option;
        do {
            System.out.println("===Cardio Menu===");
            System.out.println("1.Flooring Mats");
            System.out.println("2.Interlocking");
            System.out.println("3.Return to main menu");
            System.out.println("Choose Type:");
            option = scannerNumber.nextInt();
            flooringAddEquipment(option);
        } while (option != 3);
    }
    private void flooringAddEquipment(int option) {
        Equipment newEquipment = null;
        switch (option) {
            case 1 -> newEquipment = new FlooringMatsEquipment();
            case 2 -> newEquipment = new InterlockingEquipment();
            case 3 -> System.out.println("Returned To Main Menu");
            default -> System.out.println("Invalid option!");
        }
        if (newEquipment != null) {
            addEquipmentToList(newEquipment);
        }
    }

    private void groupTrainingTypeMenu() {
        int option;
        do {
            System.out.println("===Cardio Menu===");
            System.out.println("1.Group Cycling");
            System.out.println("2.Group Functional");
            System.out.println("3.HIIT");
            System.out.println("4.Rowers");
            System.out.println("5.Return to main menu");
            System.out.println("Choose Type:");
            option = scannerNumber.nextInt();
            groupTrainingAddEquipment(option);
        } while (option != 5);
    }
    private void groupTrainingAddEquipment(int option) {
        Equipment newEquipment = null;
        switch (option) {
            case 1 -> newEquipment = new GroupCyclingEquipment();
            case 2 -> newEquipment = new GroupFunctionalEquipment();
            case 3 -> newEquipment = new HiitEquipment();
            case 4 -> newEquipment = new RowersEquipment();
            case 5 -> System.out.println("Returned To Main Menu");
            default -> System.out.println("Invalid option!");
        }
        if (newEquipment != null) {
            addEquipmentToList(newEquipment);
        }
    }

    private void strenghtTypeMenu() {
        int option;
        do {
            System.out.println("===Cardio Menu===");
            System.out.println("1.Bars");
            System.out.println("2.Benches");
            System.out.println("3.Cybex");
            System.out.println("4.Dumbells");
            System.out.println("5.FreeWeight");
            System.out.println("6.FunctionalTrainsers");
            System.out.println("7.Pilates");
            System.out.println("8.Plates");
            System.out.println("9.Selectorized");
            System.out.println("10.StoreageRaks");
            System.out.println("11.Return to main menu");
            System.out.println("Choose Type:");
            option = scannerNumber.nextInt();
            strenghtAddEquipment(option);
        } while (option != 11);
    }
    private void strenghtAddEquipment(int option) {
        Equipment newEquipment = null;
        switch (option) {
            case 1 -> newEquipment = new BarsEqupment();
            case 2 -> newEquipment = new BenchesEquipment();
            case 3 -> newEquipment = new CybexEquipment();
            case 4 -> newEquipment = new DumbellsEquipment();
            case 5 -> newEquipment = new FreeWeightsEquipment();
            case 6 -> newEquipment = new FunctionalTrainersEquipment();
            case 7 -> newEquipment = new PilatesEquipment();
            case 8 -> newEquipment = new PlatesEquipment();
            case 9 -> newEquipment = new SelectorizedEquipment();
            case 10 -> newEquipment = new StoreageRacksEquipment();
            case 11 -> System.out.println("Returned To Main Menu");
            default -> System.out.println("Invalid option!");
        }
        if (newEquipment != null) {
            addEquipmentToList(newEquipment);
        }
    }

    private void vibrationTrainingTypeMenu() {
        int option;
        do {
            System.out.println("===Cardio Menu===");
            System.out.println("1.Hypersphere");
            System.out.println("2.Personal Power Plates");
            System.out.println("3.Vyper 2");
            System.out.println("4.Return to main menu");
            System.out.println("Choose Type:");
            option = scannerNumber.nextInt();
            vibrationTrainingAddEquipment(option);
        } while (option != 4);
    }
    private void vibrationTrainingAddEquipment(int option) {
        Equipment newEquipment = null;
        switch (option) {
            case 1 -> newEquipment = new HypersphereEquipment();
            case 2 -> newEquipment = new PersonalPowerPlatesEquipment();
            case 3 -> newEquipment = new Vyper2Equipment();
            case 4 -> System.out.println("Returned To Main Menu");
            default -> System.out.println("Invalid option!");
        }
        if (newEquipment != null) {
            addEquipmentToList(newEquipment);
        }
    }
    public void showEquipments(){
        Iterator<Equipment> showEquipments = equipmentDatabase.iterator();
        while (showEquipments.hasNext()){
            Equipment temp = showEquipments.next();
            System.out.println();
            System.out.print("Name : " + temp.getName());
            System.out.print(" Group : " + temp.getGroup());
            System.out.print(" Type : " + temp.getType());
            System.out.print(" Date last clean : " + temp.getDateLastClean());
            System.out.print(" Cleaning interval : " + temp.getCleaningInterval());
            System.out.print(" Last repair : " + temp.getDateLastCheck());
            System.out.print(" Repair intreval : " + temp.getMaxUsage());
            System.out.println();

        }
    }
}
