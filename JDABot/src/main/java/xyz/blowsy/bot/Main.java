package xyz.blowsy.bot;

import xyz.blowsy.bot.listeners.MessageEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args) {
        JDA jda;
        JDABuilder jdaBuilder = JDABuilder.createDefault(Constants.TOKEN);
        jdaBuilder.addEventListeners(new MessageEvent());
        jdaBuilder.setStatus(OnlineStatus.IDLE).setActivity(Activity.playing("with my toys"));
        try {
            jda = jdaBuilder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

}
