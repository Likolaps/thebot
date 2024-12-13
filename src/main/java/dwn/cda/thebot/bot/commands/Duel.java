package dwn.cda.thebot.bot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.awt.*;
import java.util.Random;

public class Duel {
    /*
    *   userDefier
    *   userQuiDefie
    *   resultat
    *   fonction qui fait le 50/50 et qui retourne le resultat
    * */


    public static void handleDuelCommand(SlashCommandInteractionEvent event) {
        Member member = event.getMember(); // celui qui va défier
        Member opponent = event.getOption("opponent").getAsMember();

        Member winner = shuffle(member,opponent);


        event.reply("Le gagnant est : " + winner.getEffectiveName()).setEphemeral(true).queue();
    }

    public static Member shuffle (Member member, Member opponent) {
        Random random = new Random();
        boolean result = random.nextBoolean();
        if (result == false) {
            return opponent;
        } else {
            return member;
        }
    }

}