package ws.l10n.core;

import java.util.Locale;

/**
 * @author Anton Mokshyn
 */
public class SimpleMessageBundleContext implements MessageBundleContext {

    private MessageBundle messageBundle;

    public SimpleMessageBundleContext(MessageBundle messageBundle) {
        this.messageBundle = messageBundle;
    }

    public void setMessageBundle(MessageBundle messageBundle) {
        this.messageBundle = messageBundle;
    }

    public String getMessage(String code, Locale locale) {
        return getMessage(code, locale, null);
    }

    public String getMessage(String code, Locale locale, String defaultMessage) {

        Locale defaultLocale = messageBundle.getDefaultLocale();

        MessageMap messageMap = messageBundle.getMessages().get(locale);
        if (messageMap == null) {
            messageMap = messageBundle.getMessages().get(defaultLocale);
        }

        return messageMap != null ? messageMap.getMessage(code) : defaultMessage;

    }
}
