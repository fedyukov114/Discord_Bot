import events.*;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class App extends ListenerAdapter{
    public static void main(String[] args) throws LoginException {
        JDABuilder.createLight("ODI2ODA5NDc5NDQxOTQwNTIw.YGR4VQ.byeHtNbyGPCAUhI0hNMNkpiJLZs", GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES)
                .addEventListeners(new App()).setActivity(Activity.watching("Удаляю плохие слова :)"))
                .addEventListeners(new PenaltyEvent())
                .addEventListeners(new CommandsEvent())
                .addEventListeners(new ClearEvent())
                .build();
    }
}