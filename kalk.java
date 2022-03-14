import java.util.Scanner;

public class kalk {

    public static void main(String[] args) {

        var scanner = new Scanner(System.in);

        System.out.println("Podaj w oddzielnych linijkach liczb�, metode +,-,*,/, kolejn� liczb�:");

        String runAgain;
        do {

            var numerator = scanner.nextInt();
            scanner.next();
            var denominator = scanner.nextInt();
            scanner.nextLine();
            var x = new Fraction(numerator, denominator);

            var operation = scanner.nextLine();

            numerator = scanner.nextInt();
            scanner.next();
            denominator = scanner.nextInt();
            scanner.nextLine();
            var y = new Fraction(numerator, denominator);

            Fraction result;
            if (operation.equals("+")) {
                result = x.dodawnanie(y);
            } else if (operation.equals("-")) {
                result = x.odejmowanie(y);
            } else if (operation.equals("*")) {
                result = x.mno�enie(y);
            } else if (operation.equals("/")) {
                result = x.dzielenie(y);
            } else {
                System.out.println("Nieznana operacja!");
                result = new Fraction(0);
            }
            System.out.println("Tw�j wynik to: " + result.getFractionAsString());

            System.out.println("Chcesz wykona� kolejne dzia�anie? Wpisz liter� t lub n.");
            runAgain = scanner.nextLine();

        } while (runAgain.equals("t"));

        scanner.close();
    }

}