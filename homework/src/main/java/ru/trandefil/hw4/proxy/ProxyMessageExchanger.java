package ru.trandefil.hw4.proxy;

import ru.trandefil.hw4.Message;
import ru.trandefil.hw4.MessageExchanger;
import ru.trandefil.hw4.utils.MessageExchangerUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ProxyMessageExchanger implements InvocationHandler {

    private MessageExchanger messageExchanger;

    public ProxyMessageExchanger(MessageExchanger messageExchanger) {
        this.messageExchanger = messageExchanger;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String annotationName = Arrays.stream(method.getDeclaredAnnotations())
                .map(annotation -> annotation.annotationType().getSimpleName())
                .findFirst()
                .orElse(null);
        if (annotationName == null) return method.invoke(messageExchanger, args);
        switch (annotationName) {
            case "Send":
                MessageExchangerUtils.hideAuthorName(MessageExchangerUtils.encryptMessageText((Message) args[0]));
                break;
            case "Get":
                MessageExchangerUtils.hideAuthorName(MessageExchangerUtils.decryptMessageText((Message) args[0]));
                break;
        }
        return method.invoke(messageExchanger, args);
    }
}
