package ru.trandefil.hw7.copymachine;


public class PaymentState implements State {

    @Override
    public void payMoney(CopyMachine copyMachine) {
        System.out.print("Pay the copy service: ");
        copyMachine.moneyAmount = Integer.parseInt(copyMachine.scanner.nextLine());
        copyMachine.state = new IdentifySourceState();
    }

    @Override
    public void getSourceHolder(CopyMachine copyMachine) {
        throw new RuntimeException("Pay service first");
    }

    @Override
    public void getSourceFile(CopyMachine copyMachine) {
        throw new RuntimeException("Pay service first");
    }

    @Override
    public void printFile(CopyMachine copyMachine) {
        throw new RuntimeException("Pay service first");
    }

    @Override
    public void takePayback(CopyMachine copyMachine) {
        throw new RuntimeException("Pay service first");
    }
}
