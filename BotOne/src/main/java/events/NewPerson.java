package events;


import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


// Нужно реализовать: При подключении нового пользователя к гильдии необходимо выдавать
// пользователю роль студент, чтобы у него был весь необходимый функционал. Так как по началу он отсутствует.
// Это необходимо для реализации "наказания" за бан-слова.
public class NewPerson extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        /*Role student = event.getGuild().getRoleById("827502828259508277");
        event.getGuild().addRoleToMember(event.getMember().getUser().getId(), student).complete();*/


        
        // КАКАЯ ТО ЗАЛУПА, НИХУЯ НЕ РАБОТАЕТ.
        /* ЛИБО ДАЛЬШЕ ПИДОРИТЬ ЭТУ ТЕМУ, ЛИБО ЗАБИТЬ ХУЙ
        * ЕСЛИ ПИДОРИМ ДАЛЬШЕ, ТО ПОЙТИ ПИДОРИТЬ ДОКУМЕНТАЦИ/СПИЗДИТЬ КУСОК У ДРУГОГО БОТА КОТОРЫЙ ДЕЛАЕТ ТЕЖЕ ФУНКЦИИ
        * ЕСЛИ ЗАБИТЬ ХУЙ, ТО НИХУЯ НЕ БУДЕТ КИДАТЬ В БАН НА ПИСЬМО
        * ЛИБО ПРОСТО НАКИДЫВАТЬ НОВЫЕ РОЛИ КОГДА ЧЕЛ ПИШЕТ ХУЙНЮ И КОГДА ОН АПАЕТ 3 РОЛЬ, ПОСЛЕ ОЧЕРЕДНОГО МАТА КИКНУТЬ ЕГО НАХУЙ С СЕРВАКА*/


        Guild guild = event.getGuild();
        Member user = event.getMember();
        Member Bot = guild.getSelfMember();
        Role role = guild.getRolesByName("Student", true).get(0);
        guild.addRoleToMember(user, role).complete();


    }
}