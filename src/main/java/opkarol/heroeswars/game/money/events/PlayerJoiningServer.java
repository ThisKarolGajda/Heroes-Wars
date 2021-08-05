package opkarol.heroeswars.game.money.events;

import opkarol.heroeswars.utils.MoneyUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerJoiningServer extends MoneyUtils implements Listener {


    @EventHandler
    public void playerJoiningServerEvent(@NotNull PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(!playerBankAccountExists(player.getUniqueId())) {
            setDefaultMoney(player.getUniqueId());
        }

    }
}
