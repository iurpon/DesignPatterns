package ru.trandefil.hw7.copymachine;

public class IdentifySourceState  implements State{
    @Override
    public void payMoney(CopyMachine copyMachine) {
        throw new RuntimeException("Money is enough. Choose you source holder. ");
    }

    @Override
    public void getSourceHolder(CopyMachine copyMachine) {
        System.out.print("Choose you source holder (usb, wi-fi) : ");
        copyMachine.resourceHolder = copyMachine.scanner.nextLine();
        copyMachine.state = new IdentifySourceFileState();
    }

    @Override
    public void getSourceFile(CopyMachine copyMachine) {
        throw new RuntimeException("Choose you source holder first. ");
    }

    @Override
    public void printFile(CopyMachine copyMachine) {
        throw new RuntimeException("Choose you source holder first. ");
    }

    @Override
    public void takePayback(CopyMachine copyMachine) {
        throw new RuntimeException("Choose you source holder first. ");
    }
}
