package ru.trandefil.hw4.decorator;

import ru.trandefil.hw4.MailServerMock;
import ru.trandefil.hw4.Message;
import ru.trandefil.hw4.MessageExchanger;
import ru.trandefil.hw4.utils.MessageExchangerUtils;

public class IncognitoMessageExchanger implements MessageExchanger {

    private MessageExchanger messageExchanger;

    public IncognitoMessageExchanger(MessageExchanger messageExchanger) {
        this.messageExchanger = messageExchanger;
    }

    @Override
    public void sendMessage(Message message) {
        messageExchanger.sendMessage(MessageExchangerUtils.hideAuthorName(message));
    }

    @Override
    public Message getMessage(String authorName) {
        Message message = messageExchanger.getMessage(MessageExchangerUtils.hideAuthorName(authorName));
        message.setAuthor(authorName);
        return message;
    }

}
