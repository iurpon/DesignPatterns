package ru.trandefil.hw6.bancomat.dollar;


import ru.trandefil.hw6.bancomat.banknote.BanknoteHandler;

/**
 * HundredDollarHandler.
 *
 * @author Ilya_Sukhachev
 */
public class TenDollarHandler extends DollarHandlerBase {

    private int value = 10;

    public TenDollarHandler(BanknoteHandler nextHandler) {
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
