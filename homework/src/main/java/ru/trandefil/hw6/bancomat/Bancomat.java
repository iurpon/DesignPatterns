package ru.trandefil.hw6.bancomat;


import ru.trandefil.hw6.bancomat.banknote.BanknoteHandler;
import ru.trandefil.hw6.bancomat.dollar.FiftyDollarHandler;
import ru.trandefil.hw6.bancomat.dollar.HundredDollarHandler;
import ru.trandefil.hw6.bancomat.dollar.TenDollarHandler;
import ru.trandefil.hw6.bancomat.ruble.HundredRubleHandler;

/**
 * Bancomat.
 *
 * @author Ilya_Sukhachev
 */
public class Bancomat {
    private BanknoteHandler handler;

    public Bancomat() {
        handler = new HundredRubleHandler(null);
        handler = new TenDollarHandler(handler);
        handler = new FiftyDollarHandler(handler);
        handler = new HundredDollarHandler(handler);
    }

    public boolean validate(String banknote) {
        return handler.validate(banknote);
    }

}
