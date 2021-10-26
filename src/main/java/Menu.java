import equipment.EquipmentDatabase;

import java.util.Scanner;

public class Menu {
    private EquipmentDatabase equipmentDatabase;
    private final Scanner scannerNumber = new Scanner(System.in);

    public Menu() {
        equipmentDatabase = new EquipmentDatabase();
    }

    public void startMenu(){
        int opt;
        do {
            menu();
            opt = scannerNumber.nextInt();
            selectMenu(opt);
        }while (opt != 3);
    }
    private void menu(){
        System.out.println("***Menu***");
        System.out.println("1.Insert products in app");
        System.out.println("2.Show Products");
        System.out.println("2.Exit");
        System.out.println("Choose option");
    }
    private void selectMenu(int opt){
        switch (opt){
            case 1 -> equipmentDatabase.menuInsertEquipment();
            case 2 -> equipmentDatabase.showEquipments();
            case 3 -> System.out.println("Goodbye");
            default -> System.out.println("Invalid option!");
        }
    }
}
