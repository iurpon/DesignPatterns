package ru.trandefil.hw7.copymachine;

public class PaybackState implements State {
    @Override
    public void payMoney(CopyMachine copyMachine) {
        throw new RuntimeException("Wait for payback ");
    }

    @Override
    public void getSourceHolder(CopyMachine copyMachine) {
        throw new RuntimeException("Wait for payback ");
    }

    @Override
    public void getSourceFile(CopyMachine copyMachine) {
        throw new RuntimeException("Wait for payback ");
    }

    @Override
    public void printFile(CopyMachine copyMachine) {
        throw new RuntimeException("Wait for payback ");
    }

    @Override
    public void takePayback(CopyMachine copyMachine) {
        System.out.println("Do you want to make another copy(yes/no): ");
        copyMachine.makeAnotherCopy = copyMachine.scanner.nextLine().equals("yes");
        if (copyMachine.makeAnotherCopy) {
            copyMachine.state = new IdentifySourceFileState();
        }else{
            System.out.println("Take payback : " + copyMachine.moneyAmount);
        }
    }
}