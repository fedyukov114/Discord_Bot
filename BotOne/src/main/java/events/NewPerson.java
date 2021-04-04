package events;



import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


// Нужно реализовать: При подключении нового пользователя к гильдии необходимо выдавать
// пользователю роль студент, чтобы у него был весь необходимый функционал.
// Поскольку по умолчанию у пользователя не будет никакого функционала. Это необходимо для
// реализации "наказания" за бан-слова.
public class NewPerson extends ListenerAdapter {
    @Override
    public void onGuildJoin(@NotNull GuildJoinEvent event) {

    }
}
