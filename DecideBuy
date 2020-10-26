//Example: script to help to decide whether to buy 3 products individually or as a combo from the price comparison
//
//by @sachi_h1ro (Elias Camilo Cabarcas Carreño)

//imports
import java.util.Scanner;

//here we start
public class Main {

    //Function to decide whether to buy individual (3) or combo products based on final cost
    public static String decideBuy(double priceP1, double priceP2, double priceP3, double pricePCombo){

        if (priceP1 + priceP2 + priceP3 < pricePCombo){
            return "individual";
        }else{
            return "combo";
        }

    }


    public static void main(String[] args) {

        //Scanner init
        Scanner sc = new Scanner(System.in);

        //inputs
        System.out.print("Enter the price of the first product: ");
        double p1 = Double.parseDouble(sc.nextLine());
        System.out.print("Enter the price of the second product: ");
        double p2 = Double.parseDouble(sc.nextLine());
        System.out.print("Enter the price of the third product: ");
        double p3 = Double.parseDouble(sc.nextLine());
        System.out.print("Enter the price of the combo: ");
        double pCombo = Double.parseDouble(sc.nextLine());

        //processing (deciding between combo or individual options based on cost)
        String betterOption = decideBuy(p1, p2, p3, pCombo);

        //output - final print
        System.out.println("The better choice is " + betterOption + ".");

    }


}
