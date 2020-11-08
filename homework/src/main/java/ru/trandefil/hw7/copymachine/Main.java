package ru.trandefil.hw7.copymachine;

public class Main {
    public static void main(String[] args) {
        CopyMachine copyMachine = new CopyMachine();
        copyMachine.payMoney();
        copyMachine.getSourceHolder();
        do{
            copyMachine.getSourceFile();
            copyMachine.printFile();
            copyMachine.takePayback();
        }while (copyMachine.makeAnotherCopy);
    }
}
