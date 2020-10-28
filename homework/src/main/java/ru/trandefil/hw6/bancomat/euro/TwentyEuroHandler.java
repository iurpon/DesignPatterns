package ru.trandefil.hw6.bancomat.euro;

import ru.trandefil.hw6.bancomat.banknote.BanknoteHandler;

public class TwentyEuroHandler extends EuroHandlerBase {

    private int value = 20;

    public TwentyEuroHandler(BanknoteHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public boolean validate(int sum) {
        if(sum % value != 0){
            return false;
        }
        result.append(value).append("*").append(sum/ value);
        return true;
    }

    @Override
    protected int getValue() {
        return value;
    }
}
