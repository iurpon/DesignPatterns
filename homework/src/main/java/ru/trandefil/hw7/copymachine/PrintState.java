package ru.trandefil.hw7.copymachine;

public class PrintState  implements State {
    @Override
    public void payMoney(CopyMachine copyMachine) {
        throw new RuntimeException("No operations while printing");
    }

    @Override
    public void getSourceHolder(CopyMachine copyMachine) {
        throw new RuntimeException("No operations while printing");
    }

    @Override
    public void getSourceFile(CopyMachine copyMachine) {
        throw new RuntimeException("No operations while printing");

    }

    @Override
    public void printFile(CopyMachine copyMachine) {
        System.out.println("Start coping file " + copyMachine.filenameToCopy);
        System.out.println("Done.");
        copyMachine.moneyAmount -= CopyMachine.COPY_PRICE;
        copyMachine.state = new PaybackState();
    }

    @Override
    public void takePayback(CopyMachine copyMachine) {
        throw new RuntimeException("No operations while printing");
    }
}
