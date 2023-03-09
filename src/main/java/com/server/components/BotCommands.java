package com.server.components;

import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.List;

public interface BotCommands {
    List<BotCommand> LIST_OF_COMMANDS = List.of(
            new BotCommand("/start", "Старт"),
            new BotCommand("/help", "Помощь"),
            new BotCommand("/allBooks", "Получить все книги")
    );

    String HELP_TEXT = "Этот бот поможет вам посчитать количество сообщений в чате:\n\n" +
            "/start - Стартануть\n" +
            "/help - Меню помощи\n" +
            "/allBooks - получиь все книги";
}
