package customer;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CustomerDatabase {
    private final List<Customer> customerList;
    private final Scanner scannerText = new Scanner(System.in);
    private final Scanner scannerNumber = new Scanner(System.in);
    private static final String customerFile = "src/main/java/resources/customers.txt";

    public CustomerDatabase() {
        customerList = new ArrayList<>();
        File file = new File(customerFile);

        try {
            try(FileReader reader = new FileReader(file); BufferedReader buffer = new BufferedReader(reader)){
                String rand;
                while ((rand = buffer.readLine()) != null){
                    List<String> listOfCustomer = Arrays.asList(rand.split(","));
                    customerList.add(new Customer(listOfCustomer.get(0),listOfCustomer.get(1),listOfCustomer.get(2),listOfCustomer.get(3),listOfCustomer.get(4)));
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void deleteCustomer(){
        showCustomer();
        if (customerList.size() == 0 ) {
            System.out.println("You don`t have any customer to delete");
        }
        else {
            System.out.println("Choose Equipment to delete from 1 to " + customerList.size() + " :");
            int positionToDelete = scannerNumber.nextInt();
            positionToDelete--;
            if (positionToDelete >= 0 && positionToDelete < customerList.size()){
                customerList.remove(positionToDelete);
                try {
                    saveCustomer();
                }catch (IOException e){
                    e.printStackTrace();
                }
                System.out.println("The customer was deleted");
            }else {
                System.out.println("Incorect number, nothing was deleted");
            }
        }
    }

    public void showCustomer(){
        Customer customer;
        for (int i = 0; i < customerList.size(); i++) {
            customer = customerList.get(i);
            System.out.println((i+1)+". " + customer);
        }
    }

    public void insertCustomer() {
        String opt;
        do {
            System.out.print("Enter firstname : ");
            String firstname = scannerText.nextLine();
            System.out.print("Enter lastname : ");
            String lastname = scannerText.nextLine();
            System.out.print("Enter cnp : ");
            String cnp = scannerText.nextLine();
            System.out.print("Enter phoneNumber : ");
            String phoneNumber = scannerText.nextLine();
            String access = chooseAcces();
            customerList.add(new Customer(firstname,lastname,cnp,phoneNumber,access));
            try {
                saveCustomer();
            }catch (IOException e){
                e.printStackTrace();
            }
            System.out.println("Do you what to insert another customer ? (y/n)");
            opt = scannerText.nextLine();
        }while (opt.equalsIgnoreCase("y") || opt.equalsIgnoreCase("yes"));

    }
    private String chooseAcces(){
        showMenu();
        System.out.print("Select type of access from 1-4 : ");
        int accessOption = scannerNumber.nextInt();
        String access = "";
        switch (accessOption) {
            case 1 -> access = "1 Month";
            case 2 -> access = "1 Weekend";
            case 3 -> access = "1 Week";
            case 4 -> access = "1 Day";
            default -> {
                System.out.println("Invalid option! Please try again!");
                chooseAcces();
            }
        }
        return access;
    }

    private void showMenu() {
        System.out.println("===Subscription===");
        System.out.println("1. 1 Month");
        System.out.println("2. 1 Weekend");
        System.out.println("3. 1 Week");
        System.out.println("4. 1 Day");
    }

    private void saveCustomer() throws IOException {
        final StringBuilder textToWrite = new StringBuilder();
        customerList
                .forEach(customer -> textToWrite.append(customer.getFirstname()).append(",")
                        .append(customer.getLasttname()).append(",")
                        .append(customer.getCnp()).append(",")
                        .append(customer.getPhoneNumber()).append(",")
                        .append(customer.getAccess()).append("\n"));
        try (FileWriter writer = new FileWriter(customerFile)){
            writer.write(textToWrite.toString());
        }
    }
}
