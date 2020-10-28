package ru.trandefil.hw6.bancomat;


import ru.trandefil.hw6.bancomat.banknote.BanknoteHandler;
import ru.trandefil.hw6.bancomat.banknote.CurrencyType;
import ru.trandefil.hw6.bancomat.dollar.FiftyDollarHandler;
import ru.trandefil.hw6.bancomat.dollar.HundredDollarHandler;
import ru.trandefil.hw6.bancomat.dollar.TenDollarHandler;
import ru.trandefil.hw6.bancomat.euro.FiftyEuroHandler;
import ru.trandefil.hw6.bancomat.euro.HundredEuroHandler;
import ru.trandefil.hw6.bancomat.euro.TwentyEuroHandler;
import ru.trandefil.hw6.bancomat.ruble.FiveHundredRubleHandlerBase;
import ru.trandefil.hw6.bancomat.ruble.HundredRubleHandler;
import ru.trandefil.hw6.bancomat.ruble.ThousandRubleHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Bancomat.
 *
 * @author Ilya_Sukhachev
 */
public class Bancomat {

    private static Map<CurrencyType, BanknoteHandler> bancomat = new HashMap<>();

    static {
        bancomat.put(CurrencyType.USD, new HundredDollarHandler(new FiftyDollarHandler(new TenDollarHandler(null))));
        bancomat.put(CurrencyType.RUB, new ThousandRubleHandler(new FiveHundredRubleHandlerBase(new HundredRubleHandler(null))));
        bancomat.put(CurrencyType.EUR, new HundredEuroHandler(new FiftyEuroHandler(new TwentyEuroHandler(null))));
    }

    public String getCash(String banknote, CurrencyType currencyType) {
        String finalMessage = null;
        BanknoteHandler banknoteHandler = bancomat.get(currencyType);
        boolean executionResult = banknoteHandler.validate(Integer.parseInt(banknote));
         StringBuilder builder = banknoteHandler.result;
        if(!executionResult){
            finalMessage = "Некорректная сумма.  Попытайтесь снова.";
        }else{
            finalMessage = builder.toString();
        }
        builder.delete(0, builder.length());
        return finalMessage;
    }

}
