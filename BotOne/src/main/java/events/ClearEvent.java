package events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

public class ClearEvent extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        // Take message. Try to find regex in message. If we find, then we split message
        // to take the number of messages to delete.
        String message = event.getMessage().getContentDisplay();
        String regex = "!clear.*";
        boolean result = Pattern.matches(regex, message);
        if(result) {
            String[] splitedMessage = event.getMessage().getContentDisplay().split(" ");
            int quantity = Integer.parseInt(splitedMessage[1]);

            event.getChannel().getHistory().retrievePast(quantity).queue(
                    m -> event.getGuild()
                            .getTextChannelById(event.getChannel().getId())
                            .deleteMessages(m).queue()
            );
        }
    }
}
