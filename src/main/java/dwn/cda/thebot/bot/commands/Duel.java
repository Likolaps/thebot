package dwn.cda.thebot.bot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class Duel {
    /*
    *   userDefier
    *   userQuiDefie
    *   resultat
    *   fonction qui fait le 50/50 et qui retourne le resultat
    * */

    public void handleDuelCommand(SlashCommandInteractionEvent event) {

        event.reply("duel dans la fonction").queue();
    }


}
