package ru.trandefil.hw6.bancomat.ruble;

import ru.trandefil.hw6.bancomat.banknote.BanknoteHandler;

public class ThousandRubleHandler extends RubleHandlerBase {

    private int value = 1000;

    public ThousandRubleHandler(BanknoteHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected int getValue() {
        return value;
    }
}
