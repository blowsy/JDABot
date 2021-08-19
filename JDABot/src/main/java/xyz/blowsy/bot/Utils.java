package xyz.blowsy.bot;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Utils {

    public static void sendMessage(String text, MessageChannel channel) {
        if (text == null || text.isEmpty()) return;
        channel.sendMessage(text).queue();
    }

    public static boolean hasAdminPerms(MessageReceivedEvent e) {
        return e.getMember().hasPermission(Permission.ADMINISTRATOR);
    }

}
