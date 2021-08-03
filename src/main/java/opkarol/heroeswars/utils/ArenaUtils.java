package opkarol.heroeswars.utils;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import opkarol.heroeswars.game.arena.Arena;

public class ArenaUtils {

    public static StringBuilder getArenaInformation(Arena arena){
        TextComponent message = new TextComponent("Set bounds");
        return new StringBuilder().append(ColorUtils.formatText("""
        Arena Name: %arena_name%
        Are currently played: %current_playing%
        Max players: %max_players%
        Current Players: %current_players%
        Bounds: %bound1_location% - %bound1_location%
        Location of Spawns: %spawn1_location% - %spawn2_location%
        """).replace("%spawn2_location%", String.valueOf(arena.getSpawn2())).replace("%spawn1_location%", String.valueOf(arena.getSpawn1())).replace("%bound2_location%", String.valueOf(arena.getBound2())).replace("%bound1_location%", String.valueOf(arena.getBound1())).replace("%max_players%", String.valueOf(arena.getMaxPlayers())).replace("%arena_name%", arena.getArenaName()).replace("%current_playing%", String.valueOf(arena.isCurrentPlaying())).replace("%current_players%", arena.getCurrentPlayersName()));
    }
}
