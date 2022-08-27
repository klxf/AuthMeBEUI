package fang.authmebeui;

import fr.xephi.authme.api.v3.AuthMeApi;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import org.geysermc.cumulus.form.*;
import org.geysermc.floodgate.api.FloodgateApi;
import org.geysermc.floodgate.api.player.FloodgatePlayer;

public class EventListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        // If player is Java Edition player, don't send form
        if (!FloodgateApi.getInstance().isFloodgatePlayer(e.getPlayer().getUniqueId())) {
            return;
        }

        Player player = e.getPlayer();
        FloodgatePlayer bePlayer = FloodgateApi.getInstance().getPlayer(player.getUniqueId());

        if (!AuthMeApi.getInstance().isRegistered(player.getName())) {
            // If player isn't registered
            CustomForm.Builder regForm = CustomForm.builder();
            regForm = regForm.title(Util.getText("text.reg_title"));
            regForm = regForm.input(Util.getText("texts.input_title"), Util.getText("texts.input_placeholder"));
            regForm = regForm.validResultHandler(response -> {
                String pass = response.asInput();
                if (!pass.isEmpty()){
                    AuthMeApi.getInstance().forceRegister(player, pass);
                } else {
                    player.kickPlayer(Util.getText("text.close"));
                }
            });
            regForm = regForm.closedResultHandler(response -> player.kickPlayer(Util.getText("text.close")));

            // Send form
            bePlayer.sendForm(regForm.build());
        } else {
            if (!AuthMeApi.getInstance().isAuthenticated(player)) {
                // If player isn't authenticated
                CustomForm.Builder loginForm = CustomForm.builder();
                loginForm = loginForm.title(Util.getText("texts.login_title"));
                loginForm = loginForm.input(Util.getText("texts.input_title"), Util.getText("texts.input_placeholder"));
                loginForm = loginForm.validResultHandler(response -> {
                    String pass = response.asInput();
                    if (AuthMeApi.getInstance().checkPassword(player.getName(), pass)) {
                        AuthMeApi.getInstance().forceLogin(player);
                    } else {
                        player.kickPlayer(Util.getText("texts.wrongpass"));
                    }
                });
                loginForm = loginForm.closedResultHandler(response -> player.kickPlayer(Util.getText("texts.close")));

                // Send form
                bePlayer.sendForm(loginForm.build());
            }
        }
    }
}
