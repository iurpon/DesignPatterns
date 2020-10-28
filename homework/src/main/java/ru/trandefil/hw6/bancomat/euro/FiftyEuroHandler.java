package ru.trandefil.hw6.bancomat.euro;

import ru.trandefil.hw6.bancomat.banknote.BanknoteHandler;

public class FiftyEuroHandler extends EuroHandlerBase {

    protected int value = 50;

    public FiftyEuroHandler(BanknoteHandler nextHandler) {
        super(nextHandler);
    }


    @Override
    protected int getValue() {
        return value;
    }
}
