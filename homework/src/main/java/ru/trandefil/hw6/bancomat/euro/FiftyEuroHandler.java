package ru.trandefil.hw6.bancomat.euro;

import ru.trandefil.hw6.bancomat.banknote.BanknoteHandler;

public class FiftyEuroHandler extends EuroHandlerBase {

    protected int value = 50;

    public FiftyEuroHandler(BanknoteHandler nextHandler) {
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
