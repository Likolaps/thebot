package dwn.cda.thebot.bot.entities;

import com.fasterxml.jackson.databind.ObjectMapper;
import dwn.cda.thebot.ThebotApplication;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.springframework.boot.jackson.JsonComponent;

import java.io.Console;
import java.io.File;
import java.io.IOException;

public class Player {

    private String id;
    private Integer xp;

/**
 * Constructor with a {@link SlashCommandInteractionEvent} as parameter
 */
    public Player(SlashCommandInteractionEvent event) {

        this.id = event.getUser().getId();

        //check if player exist or not
        //if not create a new player
        //else fetch the player from the db

        Player player = this.getOrCreatePlayerFromDB(this.id);

        this.xp = player.xp;

    }

    public Player(String id, Integer xp){
        this.id = id;
        this.xp = xp;
    }

    public Integer getLevel(){
        // calcul par rapport a l'experience total
        return 0;
    }


    public String getName(){
        return id;
    }




    public void ShowPlayerStats(SlashCommandInteractionEvent event) {

        // affichage des stats

        MessageEmbed embed = new EmbedBuilder()
                .setTitle("Player Stats")
                .addField("Player", event.getJDA().getUserById(this.id).getAsMention(), false)
                .addField("Level", String.valueOf(this.getLevel()), true)
                .addField("XP", String.valueOf(xp), true)
                .build();


        event.replyEmbeds(embed).queue();


    }


    private Player getOrCreatePlayerFromDB(String id) {
        //fetch from dj.json file

        File file = new File(ThebotApplication.databaseurl);

        ObjectMapper mapper = new ObjectMapper();
        try {
            Player player = mapper.readValue(ThebotApplication.databaseurl, Player.class);

            return player;


        } catch (Exception e) {
            // create Player
            try{
                Player player = new Player(id, 0);
                mapper.writeValue(file, player);
                return player;
            }
            catch (Exception e2){
                System.out.println("Error while creating player");
                return null;
            }
        }

    }


    private void savePlayer() {
        //save to dj.json file
        File file = new File(ThebotApplication.databaseurl);

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(file, this);
        } catch (IOException e) {
            System.out.println("Error while saving player");
        }
    }





}
