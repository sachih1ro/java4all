//Example: Online Shopping Cart - Version: working with ArrayList
//
//by @sachi_h1ro (Elias Camilo Cabarcas Carreño)
//

//imports
import java.util.ArrayList;
import java.util.Scanner;


public class ShoppingCartVArrayList {

    //Function for calc discount
    public static double calcDiscount(double subtotal){
        if(subtotal > 700000){
            return subtotal*0.2;
        }else if(subtotal > 300000){
            return subtotal*0.15;
        }else if(subtotal > 150000){
            return subtotal*0.1;
        }else{
            return 0.0;
        }
    }

    //Function for print commands
    public static void printCommands() {
        System.out.println("---------------------------------------------------");
        System.out.println("Select an option and type the corresponding command");
        System.out.println("1. Add student and his/her grade.");
        System.out.println("Format: 1&name&quantity&prize");
        System.out.println("2. Print the invoice.");
        System.out.println("Format: 2&clientID");
        System.out.println("3. Finish the program.");
        System.out.println(" ");
        System.out.print("Type the command: ");
    }

    //Function to check if the written input is valid
    public static boolean isValidEntry(String entry){
        String[] command = entry.split("&");

        //Checking
        if(command[0].equals("1")){
            return command.length == 4;
        }else if(command[0].equals("2")){
            return command.length == 2;
        }else if(command[0].equals("3")){
            return command.length == 1;
        }else{
            return false;
        }

    }


    //Function for print the invoice
    public static void printInvoice(int total, int discount, String clientID, ArrayList<String> articlesNames,
                                    ArrayList<Integer> articlesQuantity, ArrayList<Double> articlesUnitPrice){

        //Part 1: intro
        System.out.println("Tangananá Shopping Center");
        System.out.println("We're not the best, but still cool");
        System.out.println("Client: " + clientID);
        System.out.println("Name - Quantity - Prize");

        //Part 2: products
        for (int i = 0; i < articlesNames.size(); i++) {
            String name = articlesNames.get(i);
            int quantity = articlesQuantity.get(i);
            int prize = (int) (articlesUnitPrice.get(i) * quantity);
            System.out.println(name + " " + quantity + " $" + prize);
        }

        //Part 3: totals and goodbye
        System.out.println("Total: $" + total);
        System.out.println("Discount $" + discount);
        System.out.println("Thanks, come back soon");
        System.out.println("---");

    }


    public static void main(String[] args) {

        //Scanner init
        Scanner sc = new Scanner(System.in);

        //ArrayLists for articles names, quantity and unit price init
        ArrayList<String>  articlesName         = new ArrayList<>();
        ArrayList<Integer> articlesQuantity     = new ArrayList<>();
        ArrayList<Double>  articlesUnitPrice    = new ArrayList<>();

        //Subtotal init
        double subtotal = 0;

        //Boolean flag init
        boolean isWorking = true;

        //Cicle
        while(isWorking) {

            printCommands();
            String entry = sc.nextLine();
            String[] command = entry.split("&");

            //Check if entry is valid
            if(!isValidEntry(entry)){
                command[0] = "4";
            }

            //Here we go
            switch (command[0]) {

                case ("1"): //Add articles
                    String name = command[1];
                    double unitPrize = Double.parseDouble(command[3]);
                    int quantity = Integer.parseInt(command[2]);
                    subtotal += unitPrize*quantity;

                    //Add new product
                    articlesName.add(name);
                    articlesQuantity.add(quantity);
                    articlesUnitPrice.add(unitPrize);

                    //Print new product
                    System.out.println("Added");
                    System.out.println("name: " + name + " - quantity: " + quantity +
                            " - unitary prize: " + unitPrize);

                    break;

                case ("2"): //Print the invoice

                    int discount = (int) calcDiscount(subtotal);
                    int total = (int) Math.round(subtotal - discount);
                    printInvoice(total, discount, command[1], articlesName,
                            articlesQuantity, articlesUnitPrice);
                    subtotal = 0; //Reset subtotal
                    articlesName.clear(); //Reset articles names
                    articlesQuantity.clear(); //Reset articles quantities
                    articlesUnitPrice.clear(); //Reset articles unit prices
                    break;

                case ("3"): //Finish
                    isWorking = false;
                    break;

                default:    //Not valid command case
                    System.out.println("Insert a valid command.");
                    break;
            }

        }

    }

}
