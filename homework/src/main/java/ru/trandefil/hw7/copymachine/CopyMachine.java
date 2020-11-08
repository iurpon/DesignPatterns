package ru.trandefil.hw7.copymachine;

import java.util.Scanner;

public class CopyMachine {

    public static final int COPY_PRICE = 50;

    Scanner scanner = new Scanner(System.in);

    State state;

    String resourceHolder;

    String filenameToCopy;

    boolean makeAnotherCopy;

    int moneyAmount = 0;

    public CopyMachine() {
        this.state = new PaymentState();
    }

    void payMoney() {
        state.payMoney(this);
    }

    void getSourceHolder() {
        state.getSourceHolder(this);
    }

    void getSourceFile() {
        state.getSourceFile(this);
    }

    void printFile() {
        state.printFile(this);
    }

    void takePayback() {
        state.takePayback(this);
    }
}
