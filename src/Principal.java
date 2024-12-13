import java.sql.SQLOutput;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner reading = new Scanner(System.in);
        CurrencyQuery query = new CurrencyQuery();
        Menu menu = new Menu();

        try{
            menu.showMenu(query);
        }catch(Exception e){
            System.out.println("There was an error trying to convert" + e.getMessage());
        }

    }
}










