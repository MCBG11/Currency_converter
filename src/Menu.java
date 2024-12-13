import java.util.Scanner;

public class Menu {

    private Scanner userInput = new Scanner(System.in);

    public static void showMenu(CurrencyQuery query ){
        while (true){
            Scanner userInput = new Scanner(System.in);
            System.out.println("\n***********************");
            System.out.println("Select the number of currency type from which the conversion will be made:");
            System.out.println("1. Dollar >> Argentine peso");
            System.out.println("2. Argentine peso >> Dollar");
            System.out.println("3. Dollar >> Brazilian real");
            System.out.println("4. Brazilian real >> Dollar");
            System.out.println("5. Dollar >> Colombian peso");
            System.out.println("6. Colombian peso >> Dollar");
            System.out.println("7. Exit");
            System.out.println("\n***********************");

            int userChoice = userInput.nextInt();

            if (userChoice == 7) {
                System.out.println("Exit from the app...");
                break;
            }
            System.out.print("\n Enter the amount you wish to convert: ");
            double amount = userInput.nextDouble();

            switch (userChoice) {
                case 1 -> convertCurrency(query, "USD", "ARS", amount);
                case 2 -> convertCurrency(query, "ARS", "USD", amount);
                case 3 -> convertCurrency(query, "USD", "BRL", amount);
                case 4 -> convertCurrency(query, "BRL", "USD", amount);
                case 5 -> convertCurrency(query, "USD", "COP", amount);
                case 6 -> convertCurrency(query, "COP", "USD", amount);
                default -> System.out.println("Invalid option, try again.");
            }

        }
    }

    private static void convertCurrency(CurrencyQuery query, String baseCurrency,
                                        String wishedCurrency, double amount){
        Coin coin = query.currencySearch(baseCurrency);
        double conversionRate = coin.conversion_rates().get(wishedCurrency);
        double convertedAmount = amount * conversionRate;

        System.out.println("\n**** Conversion result ****");
        System.out.println(convertedAmount + " " + wishedCurrency);

    }
}
