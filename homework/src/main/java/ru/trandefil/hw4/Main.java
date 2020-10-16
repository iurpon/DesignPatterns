package ru.trandefil.hw4;

import ru.trandefil.hw4.decorator.EncryptMessageExchanger;
import ru.trandefil.hw4.decorator.IncognitoMessageExchanger;
import ru.trandefil.hw4.proxy.ProxyMessageExchanger;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        System.out.println("Check simple implementation: ");
        MessageExchanger simpleMessageExchanger = new SimpleMessageExchangerImpl();
        simpleMessageExchanger.sendMessage(new Message("John", "New York", "Hello, Bat"));
        System.out.println("Message on server : " + MailServerMock.showAll());
        System.out.println("Message on home computer : " + MailServerMock.getMessage("John"));
        MailServerMock.clear();

        System.out.println("\nCheck incognito implementation: ");
        MessageExchanger incognitoMessageExchanger = new IncognitoMessageExchanger(simpleMessageExchanger);
        incognitoMessageExchanger.sendMessage(new Message("Jo", "Los Angeles", "Hello. Angelina"));
        System.out.println("Message on server : " + MailServerMock.showAll());
        System.out.println("Message on home computer : " + incognitoMessageExchanger.getMessage("Jo"));
        MailServerMock.clear();

        System.out.println("\nCheck encrypt implementation: ");
        MessageExchanger encryptMessageExchanger = new EncryptMessageExchanger(simpleMessageExchanger);
        encryptMessageExchanger.sendMessage(new Message("Joe", "Alabama", "Hello. Batsy"));
        System.out.println("Message on server : " + MailServerMock.showAll());
        System.out.println("Message on home computer : " + encryptMessageExchanger.getMessage("Joe"));
        MailServerMock.clear();

        System.out.println("\nCheck combo implementation: ");
        MessageExchanger superCombo = new EncryptMessageExchanger(new IncognitoMessageExchanger(simpleMessageExchanger));
        superCombo.sendMessage(new Message("Mary", "Jersy", "Hello, Jasy"));
        System.out.println("Message on server : " + MailServerMock.showAll());
        System.out.println("Message on home computer : " + superCombo.getMessage("Mary"));
        MailServerMock.clear();


        MessageExchanger proxyMessageExchanger = (MessageExchanger) Proxy.newProxyInstance(
                simpleMessageExchanger.getClass().getClassLoader(),
                simpleMessageExchanger.getClass().getInterfaces(),
                new ProxyMessageExchanger(simpleMessageExchanger));
        System.out.println("\nCheck proxy implementation: ");
        proxyMessageExchanger.sendMessage(new Message("Proxy", "Shmoxy", "LOL"));
        System.out.println("Mail on server : " + MailServerMock.showAll());

    }
}
