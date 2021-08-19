package xyz.blowsy.bot;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Commands {

    public static void execute(MessageReceivedEvent e) {
        if (e.getAuthor().isBot()) {
            return;
        }
        String msg = e.getMessage().getContentRaw();
        if (!msg.startsWith(Constants.PREFIX)) {
            return;
        }
        CommandArg args = new CommandArg(msg);
        if (!args.getState()) {
            return;
        }
        if (args.getLength() == 0) {
            Utils.sendMessage("This is an example Discord bot made with JDA.", e.getChannel());
            return;
        }
        switch (args.getArgs()[0].toLowerCase()) {
            case "hello":
                Utils.sendMessage("Hey! :wave:", e.getChannel());
                break;
            case "say":
                if (args.getLength() == 1) {
                    Utils.sendMessage("Please input a valid message!", e.getChannel());
                    return;
                } else if (args.getLength() == 2) {
                    Utils.sendMessage(args.getArgs()[1], e.getChannel());
                } else {
                    Utils.sendMessage(args.getArgString().replaceFirst(args.getArgs()[0] + " ", ""), e.getChannel());
                }
                break;
            case "disable":
                if (!Utils.hasAdminPerms(e)) {
                    Utils.sendMessage("You do not have permission.", e.getChannel());
                    return;
                }
                Utils.sendMessage("Disabling bot...", e.getChannel());
                try {
                    Thread.sleep(1000);
                    System.exit(0);
                } catch (InterruptedException er) {
                    Utils.sendMessage("There was an error.", e.getChannel());
                }
                break;
            default:
                Utils.sendMessage("Invalid command.", e.getChannel());
                break;
        }
    }

    public static class CommandArg {

        private boolean success;
        private String arg;
        private String args[];
        private int length;

        public CommandArg(String msg) {
            arg = msg.replaceFirst(Constants.PREFIX, "");
            if (arg.length() > 0 && !arg.startsWith(" ")) {
                success = false;
            } else {
                arg = arg.replaceFirst(" ", "");
                args = arg.split(" ");
                length = arg.length() > 0 ? (arg.contains(" ") ? args.length : 1) : 0;
                success = true;
            }
        }

        public boolean getState() { return success; }
        public String getArgString() { return arg; }
        public String[] getArgs() { return args; }
        public int getLength() { return length; }

    }

}
