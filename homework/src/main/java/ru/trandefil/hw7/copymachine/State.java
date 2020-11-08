package ru.trandefil.hw7.copymachine;

public interface State {

    void payMoney(CopyMachine copyMachine);

    void getSourceHolder(CopyMachine copyMachine);

    void getSourceFile(CopyMachine copyMachine);

    void printFile(CopyMachine copyMachine);

    void takePayback(CopyMachine copyMachine);
}
