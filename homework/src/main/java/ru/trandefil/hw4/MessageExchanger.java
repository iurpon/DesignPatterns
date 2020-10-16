package ru.trandefil.hw4;

import ru.trandefil.hw4.proxy.Get;
import ru.trandefil.hw4.proxy.Send;

public interface MessageExchanger {

    @Send
    void sendMessage(Message message);

    @Get
    Message getMessage(String byName);
}
