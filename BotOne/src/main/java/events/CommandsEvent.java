package events;


import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class CommandsEvent extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getMessage().getContentDisplay().equals("!commands")) {
            event.getChannel().sendMessage( "Список всех моих команд:"
                    + "\n" + "!rules    -   список правил, которые важно соблюдать."
                    + "\n" + "!info     -   получить основную информацию, если вы только присоединились к серверу."
                    + "\n" + "!penalty  -   узнать как получить наказание и что делать после его получения."
                    + "\n" + "!roles    -   получить информацию о ролях на данном сервере."
                    + "\n" + "!clear    -   удалить несколько последних сообщений из чата."
                    + "\n" + "!play     -   включить аудиовоспроизведение."
            ).submit();
        }

        if (event.getMessage().getContentDisplay().equals("!rules")) {
            event.getChannel().sendMessage( "Чтобы избежать проблем с общением на данном сервере, достаточно соблюдать несколько правил:"
                            + "\n" + "1) На сервере запрещенно использование нецензурной лексики и матерной брани."
                            + "\n" + "2) Не нужно флудить в чатах, ваш вопрос обязательно увидят :)"
                            + "\n" + "3) Никакой рекламы :)"
                            + "\n" +"Соблюдая эти простые правила, вы не столкнетесь с проблемами на данном сервере. Приятного общения!"
            ).submit();
        }

        if (event.getMessage().getContentDisplay().equals("!info")) {
            event.getChannel().sendMessage( "Привет! Я специальный бот, который наблюдает за обстановкой на сервере."
                    + "\n" + "Если вы только что присоединились на данный сервер, то вам следует ознакомиться с правилами сервера, " +
                    "написав в чате !rules, а также !commands, чтобы ознакомиться и с другими моими функциями."
            ).submit();
        }

        if (event.getMessage().getContentDisplay().equals("!penalty")) {
            event.getChannel().sendMessage( "Информация о наказании."
                    + "\n" + "Если вы нарушили что-то из списка правил (!rules в чат), то справедливо получите наказание"
                    + "\n" + "Наказание - отключение возможности писать в текстовый чат, а также общаться в голосвых чатах " +
                    "(однако участник с ролью страшей, чем студент, может включить вам возможность общения в голосвом чате)."
                    + "\n" + "Наказание длится 30 минут, затем вам возвращаются все возможности общения, однако не забывайте " +
                    "о возможности получить наказание повторно!"
            ).submit();
        }

        if (event.getMessage().getContentDisplay().equals("!roles")) {
            event.getChannel().sendMessage( "Информация о ролях."
                    + "\n" + "Как только вы присоединились к серверу, вам автоматически выдается роль «Студент», которая " +
                    "гарантирует вам свободное общение на сервере."
                    + "\n" + "Также существует роль «Преподаватель», которая выдается уже лично администратором данного сервера." +
                    "Обладатели данной роли, получают возможность банить/удалять с сервера, возвращать право говорить в голосовых" +
                    " каналах участникам с наказанием."
            ).submit();
        }
    }
}