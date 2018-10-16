import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dark_Trainer on 16/10/2018.
 */
public class DarkBot extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            if(update.getMessage().getText().contains("/llamarXiaoFeo@darktrainer_bot") || update.getMessage().getText().contains("/llamarXiaoFeo")){
                // Set variables
                long chat_id = update.getMessage().getChatId();

                SendMessage message = new SendMessage() // Create a message object object
                        .setChatId(chat_id)
                        .setText("Xiao eres feo");
                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }else if(update.getMessage().getText().contains("/submitId@darktrainer_bot") || update.getMessage().getText().contains("/submitId")){
                // Set variables
                long chat_id = update.getMessage().getChatId();
                String textMsg = update.getMessage().getText();
                textMsg = textMsg.substring(textMsg.indexOf(" "));

                SendMessage message = new SendMessage() // Create a message object object
                        .setChatId(chat_id)
                        .setText(textMsg);
                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }else if(update.getMessage().getText().contains("/report@darktrainer_bot") || update.getMessage().getText().contains("/report")){
                // Set variables
                long chat_id = update.getMessage().getChatId();

                SendMessage message = new SendMessage() // Create a message object object
                        .setChatId(chat_id)
                        .setText("report kalash noob feeder");
                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getBotUsername() {
        return InicializarDatos.mapProp.get("botName");
    }

    @Override
    public String getBotToken() {
        return InicializarDatos.mapProp.get("apiKey");
    }
}
