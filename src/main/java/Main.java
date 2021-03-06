import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;

/**
 * Created by Dark_Trainer on 16/10/2018.
 */
public class Main {
    public static void main(String[] args) {

        InicializarDatos init = new InicializarDatos();
        // Initialize Api Context
        ApiContextInitializer.init();
        // Instantiate Telegram Bots API
        TelegramBotsApi botsApi = new TelegramBotsApi();

        // Register our bot
        try {
            botsApi.registerBot(new DarkBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        System.out.println("Bot up");
    }
}
