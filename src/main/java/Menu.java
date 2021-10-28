import customer.CustomerDatabase;
import equipment.EquipmentDatabase;

import java.util.Scanner;

public class Menu {
    private final EquipmentDatabase equipmentDatabase;
    private final CustomerDatabase customerDatabase;
    private final Scanner scannerNumber = new Scanner(System.in);

    public Menu() {
        equipmentDatabase = new EquipmentDatabase();
        customerDatabase = new CustomerDatabase();
    }

    public void startMenu(){
        int opt;
        do {
            menu();
            opt = scannerNumber.nextInt();
            selectMenu(opt);
        }while (opt != 0);
    }
    private void menu(){
        System.out.println("***Menu***");
        System.out.println("1.Insert products in app");
        System.out.println("2.Show Products");
        System.out.println("3.Delete Products");
        System.out.println("4.Insert Customer");
        System.out.println("5.Show Customers");
        System.out.println("6.Delete Customer");
        System.out.println("0.Exit");
        System.out.println("Choose option");
    }
    private void selectMenu(int opt){
        switch (opt){
            case 1 -> equipmentDatabase.menuInsertEquipment();
            case 2 -> equipmentDatabase.showEquipments();
            case 3 -> equipmentDatabase.deleteEquipment();
            case 4 -> customerDatabase.insertCustomer();
            case 5 -> customerDatabase.showCustomer();
            case 6 -> customerDatabase.deleteCustomer();
            case 0 -> System.out.println("Goodbye");
            default -> System.out.println("Invalid option!");
        }
    }
}
