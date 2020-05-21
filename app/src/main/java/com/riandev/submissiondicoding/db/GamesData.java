package com.riandev.submissiondicoding.db;

import com.riandev.submissiondicoding.R;
import com.riandev.submissiondicoding.model.Game;

import java.util.ArrayList;

public class GamesData {
    private static String[] gameTitles = {
            "Assassin Creed Odyssey",
            "Final Fantasy VII Remake",
            "Kingdom Hearts III",
            "Code Vein",
            "Horizon Zero Dawn",
            "God of War",
            "Overcooked 2",
            "Dragon Ball Z Kakarot",
            "Persona 5 The Royal",
            "Monster Hunter World Iceborn"
    };

    private static String[] gameDetails = {
            "Assassin's Creed Odyssey is an action role-playing video game developed by Ubisoft " +
                    "Quebec and published by Ubisoft. It is the eleventh major installment, and " +
                    "21st overall, in the Assassin's Creed series and the successor to 2017's " +
                    "Assassin's Creed Origins.",
            "Final Fantasy VII Remake is an action role-playing game developed and published by " +
                    "Square Enix, released for PlayStation 4 on April 10, 2020. It is the first " +
                    "in a planned series of games remaking the 1997 PlayStation game Final " +
                    "Fantasy VII.",
            "Kingdom Hearts III is a 2019 action role-playing game developed and published by " +
                    "Square Enix for the PlayStation 4 and Xbox One. It is the twelfth " +
                    "installment in the Kingdom Hearts series, and serves as a conclusion of " +
                    "the \"Dark Seeker Saga\" story arc that began with the original game.",
            "Code Vein is an action role-playing game developed and published by Bandai Namco " +
                    "Entertainment. It was released for PlayStation 4, Xbox One, and Microsoft " +
                    "Windows on September 27, 2019. The game sold over a million copies by " +
                    "February 2020, but received mixed reviews from critics.",
            "Horizon Zero Dawn is an action role-playing game developed by Guerrilla Games and " +
                    "published by Sony Interactive Entertainment. The plot follows Aloy, a " +
                    "hunter in a world overrun by machines, who sets out to uncover her past.",
            "God of War is an action-adventure game franchise created by David Jaffe at Sony's " +
                    "Santa Monica Studio. It began in 2005 on the PlayStation 2 video game " +
                    "console, and has become a flagship title for the PlayStation brand, " +
                    "consisting of eight games across multiple platforms.",
            "Overcooked 2 is a cooperative cooking simulation video game developed by Team17 " +
                    "alongside Ghost Town Games, and published by Team17. The sequel to " +
                    "Overcooked!, it was released for Microsoft Windows, Nintendo Switch, " +
                    "PlayStation 4 and Xbox One in August 2018.",
            "Dragon Ball Z Kakarot currently follows the main story of the Dragon Ball Z " +
                    "series, and according to Bandai Namco Entertainment's website with some " +
                    "new added moments.[10] The game is broken up into sagas beginning in the " +
                    "first saga known as the Saiyan saga, followed by the Frieza saga, Cell " +
                    "Saga, and Majin Buu saga respectively.",
            "Persona 5 Royal, alternatively known as P5R and called Persona 5: The Royal in " +
                    "Japan, is an enhanced port of Persona 5 released exclusively for " +
                    "the PlayStation 4.",
            "Monster Hunter: World’s adventures reach new heights in “Monster Hunter World: " +
                    "Iceborne. With new monsters, new locales, new quests, new weapon combos, " +
                    "and so much more, Iceborne expands the possibilities of Monster Hunter: " +
                    "World’s vast, breathtaking universe."
    };

    private static int[] gamePictures = {
            R.drawable.ac_odyssey,
            R.drawable.ff7_remake,
            R.drawable.kd3,
            R.drawable.code_vein,
            R.drawable.horizon_zero,
            R.drawable.god_of_war,
            R.drawable.overcooked_2,
            R.drawable.kakarot,
            R.drawable.persona,
            R.drawable.mhw
    };

    private static double[] gameRatings = {
            8.2,
            8.9,
            8.7,
            8.9,
            8.2,
            8.9,
            8.2,
            9.0,
            8.2,
            6.0
    };

    private static String[] gameGenres = {
            "Action RPG, Open World",
            "Action RPG, Turn-Based Action",
            "Action RPG",
            "Action RPG",
            "Action RPG, Open World",
            "Action",
            "Arcade",
            "Action RPG, Open World",
            "Turn-Based, RPG",
            "MMORPG, Action, Open World"
    };

    private static String[] gamePlatforms = {
            "PC/PS4/XBOX",
            "PS4",
            "PC/PS4/XBOX",
            "PC/PS4/XBOX",
            "PS4",
            "PS4",
            "PC/PS4/XBOX/Switch",
            "PC/PS4/XBOX",
            "PC/PS4/XBOX",
            "PC/PS4"
    };

    private static double[] gamePrices = {
            59.99,
            59.99,
            59.99,
            35.99,
            49.99,
            54.99,
            24.99,
            34.99,
            79.99,
            39.99
    };

    public static ArrayList<Game> getListData(){
        ArrayList<Game> list = new  ArrayList<>();
        for (int position = 0; position < gameTitles.length; position++){
            Game game = new Game();
            game.setTitle(gameTitles[position]);
            game.setDesc(gameDetails[position]);
            game.setPicture(gamePictures[position]);
            game.setRating(gameRatings[position]);
            game.setGenres(gameGenres[position]);
            game.setPlatform(gamePlatforms[position]);
            game.setPrice(gamePrices[position]);
            list.add(game);
        }
        return list;
    }
}
