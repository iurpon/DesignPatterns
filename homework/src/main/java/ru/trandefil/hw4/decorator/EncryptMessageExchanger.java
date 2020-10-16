package ru.trandefil.hw4.decorator;

import ru.trandefil.hw4.Message;
import ru.trandefil.hw4.MessageExchanger;
import ru.trandefil.hw4.utils.MessageExchangerUtils;

public class EncryptMessageExchanger implements MessageExchanger {

    private MessageExchanger messageExchanger;

    public EncryptMessageExchanger(MessageExchanger messageExchanger) {
        this.messageExchanger = messageExchanger;
    }

    @Override
    public void sendMessage(Message message) {
        messageExchanger.sendMessage(MessageExchangerUtils.encryptMessageText(message));
    }

    @Override
    public Message getMessage(String authorName) {
        Message message = messageExchanger.getMessage(authorName);
        return MessageExchangerUtils.decryptMessageText(message);
    }

}
