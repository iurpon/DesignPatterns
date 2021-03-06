package ru.trandefil.hw4;

public class SimpleMessageExchangerImpl implements MessageExchanger {

    public void sendMessage(Message message) {
        MailServerMock.sendMessage(message);
    }

    public Message getMessage(String byName) {
        return MailServerMock.getMessage(byName);
    }
}
