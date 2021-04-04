/*import events.HelloEvent;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;


public class App extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        /*if (args.length == 0){
            System.out.println("You have to provide a token as first arg");
            System.exit(1);
        }
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = "ODI2ODA5NDc5NDQxOTQwNTIw.YGR4VQ.5nYosCmVvg3ER6Ie6xBPN5bBIZo";
        builder.setToken(token);
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.setActivity(Activity.playing("Play with java kekWait..."));
        builder.addEventListeners(new App());
        builder.build();

        builder.addEventListeners(new App());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if (event.isFromType(ChannelType.PRIVATE)){
            System.out.printf("[PM] %s: %s\n", event.getAuthor().getName(),
                                    event.getMessage().getContentDisplay());
        }
        else {
            System.out.printf("[%s][%s] %s: %s\n", event.getGuild().getName(),
                                event.getTextChannel().getName(),event.getMember().getEffectiveName(),
                                event.getMessage().getContentDisplay());
        }
    }
} */

import events.HelloEvent;
import events.CommandsEvent;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class App extends ListenerAdapter{
    public static void main(String[] args) throws LoginException {
        JDABuilder.createLight("ODI2ODA5NDc5NDQxOTQwNTIw.YGR4VQ.5nYosCmVvg3ER6Ie6xBPN5bBIZo", GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES)
                .addEventListeners(new App()).setActivity(Activity.playing("Удаляю слова: лох, тупица, дурак и блядина :)"))
                .addEventListeners(new HelloEvent())
                .addEventListeners(new CommandsEvent())
               // .addEventListeners(new NewPerson())
                .build();
    }
}