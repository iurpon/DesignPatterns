package ru.trandefil.hw6.bancomat.euro;

import ru.trandefil.hw6.bancomat.banknote.BanknoteHandler;

public class TwentyEuroHandler extends EuroHandlerBase {

    protected int value = 20;

    public TwentyEuroHandler(BanknoteHandler nextHandler) {
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
