package xyz.blowsy.bot.listeners;

import xyz.blowsy.bot.Commands;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageEvent extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getChannelType() != ChannelType.TEXT) {
            return;
        }
        Commands.execute(e);
    }

}
