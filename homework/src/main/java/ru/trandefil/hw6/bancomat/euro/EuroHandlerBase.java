package ru.trandefil.hw6.bancomat.euro;

import ru.trandefil.hw6.bancomat.banknote.BanknoteHandler;

public abstract class EuroHandlerBase extends BanknoteHandler {

    protected EuroHandlerBase(BanknoteHandler nextHandler) {
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
