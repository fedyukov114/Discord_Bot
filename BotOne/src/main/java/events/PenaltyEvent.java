package events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PenaltyEvent extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getMessage().getContentDisplay().equals("Привет бот")) {
            event.getChannel().sendMessage("Ну здраствуй, друг").submit();
        }

        String messageByMember = event.getMessage().getContentDisplay();
        messageByMember = messageByMember.replaceAll("\\s+","");

        String regex = ".*[дД][уУyY][рРpP].*";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(messageByMember);
        boolean result = matcher.matches();
        if (result) {
            String MessageId = event.getChannel().getLatestMessageId();
            event.getChannel().deleteMessageById(MessageId).submit();
        }
    }
}
