package ru.trandefil.hw6.bancomat.euro;

import ru.trandefil.hw6.bancomat.banknote.BanknoteHandler;

public abstract class EuroHandlerBase extends BanknoteHandler {

    protected EuroHandlerBase(BanknoteHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public boolean validate(String banknote) {
        if (banknote.equals(String.valueOf(getValue()))) {
            return true;
        }
        return super.validate(banknote);
    }

    protected abstract int getValue();
}
