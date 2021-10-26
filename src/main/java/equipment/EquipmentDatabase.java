package equipment;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EquipmentDatabase {
    private final List<Equipment> equipmentDatabase = new ArrayList<>();
    private final Scanner scannerText = new Scanner(System.in);
    private final Scanner scannerNumber = new Scanner(System.in);

    public void menuInsertEquipment(){
        int option;
        do{
            groupMenu();
            option = scannerNumber.nextInt();
            switchMenu(option);
        }while (option != 6);
    }
    private void groupMenu(){
        System.out.println("===Menu===");
        System.out.println("1.Cardio");
        System.out.println("2.Flooring");
        System.out.println("3.GroupTraining");
        System.out.println("4.Strenght");
        System.out.println("5.VibrationTraining");
        System.out.println("6.Exit");
        System.out.println("Choose group:");
    }
    private void switchMenu(int opt){
        switch (opt){
            case 1 -> cardioTypeMenu();
            case 2 -> flooringTypeMenu();
            case 3 -> groupTrainingTypeMenu();
            case 4 -> strenghtTypeMenu();
            case 5 -> vibrationTrainingTypeMenu();
            default -> System.out.println("Invalid option!");
        }
    }
    private void cardioTypeMenu(){
        System.out.println("===Cardio Menu===");
        System.out.println("1.Elipticas & Cross Trainers");
        System.out.println("2.Exercise Bikes");
        System.out.println("3.Indoor Cycles");
        System.out.println("4.Recumbent Bikes");
        System.out.println("5.Stair Climbers And Steppers");
        System.out.println("6.Treadmill");
        System.out.println("7.Upright Bike");
        System.out.println("8.Return to main menu");
        System.out.println("Choose Type:");
    }
    private void flooringTypeMenu(){
        System.out.println("===Cardio Menu===");
        System.out.println("1.Flooring Mats");
        System.out.println("2.Interlocking");
        System.out.println("3.Return to main menu");
        System.out.println("Choose Type:");
    }
    private void groupTrainingTypeMenu(){
        System.out.println("===Cardio Menu===");
        System.out.println("1.Group Cycling");
        System.out.println("2.Group Functional");
        System.out.println("3.HIIT");
        System.out.println("4.Rowers");
        System.out.println("5.Return to main menu");
        System.out.println("Choose Type:");
    }
    private void strenghtTypeMenu(){
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
    }
    private void vibrationTrainingTypeMenu(){
        System.out.println("===Cardio Menu===");
        System.out.println("1.Hypersphere");
        System.out.println("2.Personal Power Plates");
        System.out.println("3.Vyper 2");
        System.out.println("4.Return to main menu");
        System.out.println("Choose Type:");
    }
}
