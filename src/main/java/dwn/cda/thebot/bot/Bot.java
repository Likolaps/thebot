package dwn.cda.thebot.bot;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class Bot extends ListenerAdapter {
    private Guild guild;

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        guild = event.getGuild();
        guild.updateCommands()
                .addCommands(Commands.slash("hello", "Say Hello"))
                .addCommands(Commands.slash("duel", "Duel qq")
                        .addOptions(new OptionData(OptionType.USER, "opponent", "User à défier", true)))
                .queue();
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        switch (event.getName()) {
            case "hello":
                event.reply("Hello World").queue();
                break;
            case "duel":
                event.reply("duel").queue();
                break;
            default:
                event.reply("I'm a teapot").setEphemeral(true).queue();
        }
    }
}
