package dwn.cda.thebot.bot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.awt.*;

public class Duel {
    /*
    *   userDefier
    *   userQuiDefie
    *   resultat
    *   fonction qui fait le 50/50 et qui retourne le resultat
    * */

    public static void handleDuelCommand(SlashCommandInteractionEvent event) {
        Member member = event.getMember(); // celui qui va défier

        event.reply("ID :"+member.getId() + " Name "  +  member.getEffectiveName()).setEphemeral(true).queue();
    }


}