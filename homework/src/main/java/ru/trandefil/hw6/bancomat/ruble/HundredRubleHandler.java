package ru.trandefil.hw6.bancomat.ruble;


import ru.trandefil.hw6.bancomat.banknote.BanknoteHandler;

/**
 * TenRubleHandler.
 *
 * @author Ilya_Sukhachev
 */
public class HundredRubleHandler extends RubleHandlerBase {

    private int value = 100;

    public HundredRubleHandler(BanknoteHandler nextHandler) {
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
