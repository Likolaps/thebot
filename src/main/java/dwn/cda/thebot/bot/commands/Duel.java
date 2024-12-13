package dwn.cda.thebot.bot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class Duel {
    /*
    *   userDefier
    *   userQuiDefie
    *   resultat
    *   fonction qui fait le 50/50 et qui retourne le resultat
    * */

    public void handleDuelCommand(SlashCommandInteractionEvent event) {
            User user = event.getUser();

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.addField("Nom", user.getName(),false);
        embedBuilder.addField("Prenom", user.getAsMention(),false);
        embedBuilder.addField("ID", user.getId(),false);

        event.replyEmbeds(embedBuilder.build()).queue();
    }


}