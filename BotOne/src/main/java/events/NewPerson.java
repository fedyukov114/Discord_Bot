package events;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

// In progress...
public class NewPerson extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        /*Role student = event.getGuild().getRoleById("827502828259508277");
        event.getGuild().addRoleToMember(event.getMember().getUser().getId(), student).complete();*/

        Guild guild = event.getGuild();
        Member user = event.getMember();
        Member Bot = guild.getSelfMember();
        Role role = guild.getRolesByName("Student", true).get(0);
        guild.addRoleToMember(user, role).complete();
    }
}