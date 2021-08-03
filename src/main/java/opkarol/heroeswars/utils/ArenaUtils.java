package opkarol.heroeswars.utils;

import net.md_5.bungee.api.chat.*;
import opkarol.heroeswars.game.arena.Arena;
import org.jetbrains.annotations.Nullable;

public class ArenaUtils {

    public static TextComponent getArenaInformation(Arena arena){
        TextComponent message, message2, main;

        message = new TextComponent("[Edit bounds]");
        message2 = new TextComponent("[Edit spawns]");
        main = new TextComponent(ColorUtils.formatText("""
                Arena Name: %arena_name%
                Are currently played: %current_playing%
                Max players: %max_players%
                Current Players: %current_players%
                Bounds: %bound1_location% - %bound2_location%\040""".replace("%bound2_location%", String.valueOf(arena.getBound2())).replace("%bound1_location%", String.valueOf(arena.getBound1())).replace("%max_players%", String.valueOf(arena.getMaxPlayers())).replace("%arena_name%", arena.getArenaName()).replace("%current_playing%", String.valueOf(arena.isCurrentPlaying())).replace("%current_players%", arena.getCurrentPlayersName())));
        main.addExtra(message);
        main.addExtra(("\n" +
                       "Location of Spawns: %spawn1_location% - %spawn2_location%\040").replace("%spawn2_location%", String.valueOf(arena.getSpawn2())).replace("%spawn1_location%", String.valueOf(arena.getSpawn1())));
        main.addExtra(message2);

        setHoverEvent(message);
        setRunCommandClickEvent(message, "/arenaeditor " + arena.getArenaName() + " bound");
        setHoverEvent(message2);
        setRunCommandClickEvent(message2, "/arenaeditor " + arena.getArenaName() + " spawn");
        return main;
    }

    @Nullable
    public static void setHoverEvent(TextComponent textComponent, String message){
        textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(message).create()));
    }

    @Nullable
    public static void setHoverEvent(TextComponent textComponent){
        textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click me!").create()));
    }

    @Nullable
    public static void setRunCommandClickEvent(TextComponent textComponent, String command){
        textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command));
    }
}
