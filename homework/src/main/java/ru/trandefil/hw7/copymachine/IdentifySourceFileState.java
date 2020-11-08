package ru.trandefil.hw7.copymachine;

public class IdentifySourceFileState implements State {
    @Override
    public void payMoney(CopyMachine copyMachine) {
        throw new RuntimeException("Money is enough. Choose your file to copy.  ");
    }

    @Override
    public void getSourceHolder(CopyMachine copyMachine) {
        throw new RuntimeException("Holder detected. Choose your file now. ");
    }

    @Override
    public void getSourceFile(CopyMachine copyMachine) {
        System.out.print("Choose file to copy: ");
        copyMachine.filenameToCopy = copyMachine.scanner.nextLine();
        copyMachine.state = new PrintState();
    }

    @Override
    public void printFile(CopyMachine copyMachine) {
        throw new RuntimeException("Choose file to copy. ");
    }

    @Override
    public void takePayback(CopyMachine copyMachine) {
        throw new RuntimeException("Choose file to copy. ");
    }
}
