package events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class HelloEvent extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getMessage().getContentDisplay().equals("Привет бот")) {
            event.getChannel().sendMessage("Ну здраствуй, друг").submit();
        }

        // List of words, that must be deleted
        // Нужно доработать: увеличить список бан-слов
        String[] MustDeleteWords = {"Дурак"};

        // Break the sentence into words. Write all words to array. Then we look for this word in our
        // MustDeleteWords-list.
        // If we find this word (ignoring the register), we take id of message and delete him
        // Нужно доработать: этот метод удаляет бан-слово из списка, если человек его написал, то бот лишает его роли
        // студента на 5 минут (условно)
        String[] message = event.getMessage().getContentDisplay().split(" ");
        for (int i = 0; i < message.length; i++) {
            for (int j = 0; j < MustDeleteWords.length; j++) {
                if (message[i].equalsIgnoreCase(MustDeleteWords[j])) {
                    String MessageId = event.getChannel().getLatestMessageId();
                    event.getChannel().deleteMessageById(MessageId).submit();
                }
            }
        }

        // Версия с удалением бан-слова (т.е. когда у нас 1 слово в предложении).
        /*String word = event.getMessage().getContentDisplay();
        for (int i = 0; i < MustDeleteWords.length; i++) {
            if (word.equalsIgnoreCase(MustDeleteWords[i])) {
                String MessageId = event.getChannel().getLatestMessageId();
                event.getChannel().deleteMessageById(MessageId).submit();
            }
        }*/
    }
}
