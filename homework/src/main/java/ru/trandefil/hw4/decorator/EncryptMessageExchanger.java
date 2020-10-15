package ru.trandefil.hw4.decorator;

public class EncryptMessageExchanger  implements MessageExchanger{

    private MessageExchanger messageExchanger;

    private final String ENCRYPT_KEY = "<encrypted>";

    public EncryptMessageExchanger(MessageExchanger messageExchanger) {
        this.messageExchanger = messageExchanger;
    }

    @Override
    public void sendMessage(Message message) {
        message.setText(encrypt(message.getText()));
        messageExchanger.sendMessage(message);
    }

    @Override
    public Message getMessage(String byName) {
        Message message = messageExchanger.getMessage(byName);
        message.setText(decrypt(message.getText()));
        return message;
    }

    public String encrypt(String text){
        return new StringBuilder(ENCRYPT_KEY).append(text).append(ENCRYPT_KEY).toString();
    }

    public String decrypt(String text){
        return text.replace(ENCRYPT_KEY,"");
    }
}
