package ru.trandefil.hw6.bancomat.ruble;

import ru.trandefil.hw6.bancomat.banknote.BanknoteHandler;

public class FiveHundredRubleHandlerBase extends RubleHandlerBase {

    private int value = 500;

    public FiveHundredRubleHandlerBase(BanknoteHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected int getValue() {
        return value;
    }
}
