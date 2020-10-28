package ru.trandefil.hw6.bancomat.euro;

import ru.trandefil.hw6.bancomat.banknote.BanknoteHandler;

public class HundredEuroHandler extends EuroHandlerBase {

    protected int value = 100;

    public HundredEuroHandler(BanknoteHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected int getValue() {
        return value;
    }
}
