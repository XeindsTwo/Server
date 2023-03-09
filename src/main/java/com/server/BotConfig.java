package com.server;

import lombok.Data;
import lombok.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Configuration
@Data
@PropertySource("application.properties")
public class Main {
    public static void main(String[] args) throws TelegramApiException {
        @Value("${bot.name}") private String botName;
        @Value("${bot.token}") private String botToken;
        @Value("${bot.chatId}") private String chatId;
    }
}
