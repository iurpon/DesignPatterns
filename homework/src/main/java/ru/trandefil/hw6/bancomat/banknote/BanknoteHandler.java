package ru.trandefil.hw6.bancomat.banknote;

import java.util.Random;

/**
 * BanknoteHandler.
 *
 * @author Ilya_Sukhachev
 */
public abstract class BanknoteHandler {

    private BanknoteHandler nextHandler;

    public static StringBuilder result = new StringBuilder("Ваша сумма : ");

    protected static Random random = new Random();

    protected BanknoteHandler(BanknoteHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public boolean validate(int sum) {
        return nextHandler != null && nextHandler.validate(sum);
    }
}
