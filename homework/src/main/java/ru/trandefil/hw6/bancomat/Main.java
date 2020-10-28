package ru.trandefil.hw6.bancomat;

import ru.trandefil.hw6.bancomat.banknote.CurrencyType;

import java.util.Scanner;

/**
 * Main.
 *
 * @author Ilya_Sukhachev
 */
public class Main {

    public static void main(String[] args) {
        Bancomat bancomat = new Bancomat();

        Scanner scanner = new Scanner(System.in);
        String currency = null;
        String sum = null;
        do {
            System.out.print("Enter currency(USD, RUB, EUR) or exit: ");
            currency = scanner.nextLine();
            System.out.print("Enter sum or exit: ");
            sum = scanner.nextLine();
            if (sum.equals("exit") || currency.equals("exit")) return;
            System.out.println(bancomat.getCash(sum, CurrencyType.valueOf(currency)));
        } while (true);

    }
}
