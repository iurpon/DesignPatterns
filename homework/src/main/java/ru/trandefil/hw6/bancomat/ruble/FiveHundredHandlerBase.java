package ru.trandefil.hw6.bancomat.ruble;

import ru.trandefil.hw6.bancomat.banknote.BanknoteHandler;

public class FiveHundredHandlerBase extends RubleHandlerBase {

    protected int value = 500;

    public FiveHundredHandlerBase(BanknoteHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public boolean validate(String banknote) {
        if (banknote.equals("10 Рублей")) {
            return true;
        }
        return super.validate(banknote);
    }

    @Override
    protected int getValue() {
        return value;
    }
}
