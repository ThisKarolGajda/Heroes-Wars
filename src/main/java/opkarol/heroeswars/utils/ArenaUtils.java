package opkarol.heroeswars.utils;

import net.md_5.bungee.api.chat.*;
import opkarol.heroeswars.game.arena.Arena;

public class ArenaUtils {

    public static TextComponent getArenaInformation(Arena arena){
        TextComponent message = new TextComponent("[Edit bounds]");
        TextComponent message2 = new TextComponent("[Edit spawns]");
        TextComponent main = new TextComponent(ColorUtils.formatText("""
                Arena Name: %arena_name%
                Are currently played: %current_playing%
                Max players: %max_players%
                Current Players: %current_players%
                Bounds: %bound1_location% - %bound1_location%\040""".replace("%bound2_location%", String.valueOf(arena.getBound2())).replace("%bound1_location%", String.valueOf(arena.getBound1())).replace("%max_players%", String.valueOf(arena.getMaxPlayers())).replace("%arena_name%", arena.getArenaName()).replace("%current_playing%", String.valueOf(arena.isCurrentPlaying())).replace("%current_players%", arena.getCurrentPlayersName())));
        main.addExtra(message);
        main.addExtra(("\n" +
                       "Location of Spawns: %spawn1_location% - %spawn2_location%\040").replace("%spawn2_location%", String.valueOf(arena.getSpawn2())).replace("%spawn1_location%", String.valueOf(arena.getSpawn1())));
        main.addExtra(message2);
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder( "Click me!" ).create()));
        message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/arenaeditor " + arena.getArenaName() + " bound"));
        message2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder( "Click me!" ).create()));
        message2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/arenaeditor " + arena.getArenaName() + " spawn"));
        return main;
    }
}
