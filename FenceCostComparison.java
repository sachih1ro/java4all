//Example: script to help to decide build a a wooden or wire fence based on prices
//
//by @sachi_h1ro (Elias Camilo Cabarcas Carreño)

//imports
import java.util.Scanner;

//here we start
public class FenceCostComparison {

    //Function to calculate the price of the wood fence
    public static double woodFencePrice(double width, double length, double linearMCost, double stakes){
        return (2*(width+length)*linearMCost*stakes);
    }

    //Function to calculate the price of the wire fence
    public static double wireFencePrice(double width, double length, double linearMCost, double threads){
        return (2*(width+length)*linearMCost*threads);
    }


    public static void main(String[] args) {

        //Scanner init
        Scanner sc = new Scanner(System.in);

        //inputs
        System.out.print("Insert the width of the space (m): ");
        double width = Double.parseDouble(sc.nextLine());
        System.out.print("Insert the length of space (m): ");
        double length = Double.parseDouble(sc.nextLine());
        System.out.print("Enter the cost of a linear meter of wire: ");
        double wireCost = Double.parseDouble(sc.nextLine());
        System.out.print("Enter the cost of a linear meter of wood: ");
        double woodCost = Double.parseDouble(sc.nextLine());
        System.out.print("Enter the number of wire strands: ");
        double wireNum = Double.parseDouble(sc.nextLine());
        System.out.print("Enter the number of horizontal wood stakes: ");
        double woodNum = Double.parseDouble(sc.nextLine());

        //processing (getting the prices)
        double woodPrice = woodFencePrice(width, length, woodCost, woodNum);
        double wirePrice = wireFencePrice(width, length, wireCost, wireNum);

        //processing (deciding and printing)
        if(woodPrice < wirePrice){
            System.out.println("The better choice is a wood fence.");
            System.out.println("The price is " + woodPrice);
        }else if (woodPrice > wirePrice){
            System.out.println("The better choice is a wire fence.");
            System.out.println("The price is " + wirePrice);
        }else{
            System.out.println("The best option is...  well, both are the same.");
            System.out.println("The price is " + wirePrice);
        }


    }


}
