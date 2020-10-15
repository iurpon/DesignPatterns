package ru.trandefil.hw4.decorator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Check simple implementation: ");
        MessageExchanger simpleMessageExchanger = new SimpleMessageExchangerImpl();
        simpleMessageExchanger.sendMessage(new Message("John","New York", "Hello, Bat"));
        System.out.println(MailServerMock.showAll());
        System.out.println(MailServerMock.getMessage("John"));

        System.out.println("\nCheck incognito implementation: ");
        MessageExchanger incognitoMessageExchanger = new IncognitoMessageExchanger(simpleMessageExchanger);
        incognitoMessageExchanger.sendMessage(new Message("Jo","Los Angeles", "Hello. Angelina"));
        System.out.println(MailServerMock.showAll());
        System.out.println(incognitoMessageExchanger.getMessage("Jo"));

        System.out.println("\nCheck encrypt implementation: ");
        MessageExchanger encryptMessageExchanger = new EncryptMessageExchanger(simpleMessageExchanger);
        encryptMessageExchanger.sendMessage(new Message("Joe","Alabama", "Hello. Batsy"));
        System.out.println(MailServerMock.showAll());
        System.out.println(encryptMessageExchanger.getMessage("Joe"));

        System.out.println("\nCheck combo implementation: ");
        MessageExchanger superCombo = new EncryptMessageExchanger(new IncognitoMessageExchanger(simpleMessageExchanger));
        superCombo.sendMessage(new Message("Mary","Jersy","Hello, Jasy"));
        System.out.println(MailServerMock.showAll());
        System.out.println(superCombo.getMessage("Mary"));
    }
}
