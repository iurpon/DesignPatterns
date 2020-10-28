package ru.trandefil.hw6.bancomat.dollar;


import ru.trandefil.hw6.bancomat.banknote.BanknoteHandler;

import java.util.Random;

/**
 * TenRubleHandler.
 *
 * @author Ilya_Sukhachev
 */
public abstract class DollarHandlerBase extends BanknoteHandler {

    protected DollarHandlerBase(BanknoteHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public boolean validate(int sum) {
        if(sum < 0){
            return false;
        }
        int totalBanknotes = random.nextInt(sum/getValue());
        result.append(getValue()).append("*").append(totalBanknotes).append(" + ");
        return super.validate(sum - totalBanknotes*getValue());
    }

    protected abstract int getValue();
}
