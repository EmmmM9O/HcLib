package core;

import arc.*;
import arc.util.*;
import core.funcs.ButtonRun;
import core.funcs.IntButton;
import core.ui.Elements;
import core.ui.MenuUi;
import core.ui.Tables.ElesTable;
import mindustry.game.EventType;
import mindustry.game.EventType.*;

import mindustry.gen.Player;
import mindustry.mod.*;

import java.util.HashMap;
import java.util.Map;


public class mainMod extends Mod{

    public mainMod(){
        Log.info("Loaded HcLib");
        //listen for game load event
        Events.on(ServerLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                loadContent();

            });
        });
    }

    @Override
    public void loadContent(){
        var ui=new <Integer>MenuUi("TEST","test2");
        ui.elements.text("test");
        ui.elements.button("add", new IntButton() {
            @Override
            public void get(Player p, Integer data, Elements ui) {
                if(equals(data)) data=0;
                data++;
                Log.info(data);
            }
        }, true);
        ui.elements.add(new ElesTable("none",((p, data, ui1) -> {
            ui1.text("test2");
            ui1.text(data.toString());
        })));
        ui.elements.row();
        ui.elements.button("close",((p, data, ui1) -> {}),true);

        Log.info("Loading some example content.");
        Events.on(EventType.PlayerChatEvent.class,event -> {
            var m=event.message;var p=event.player;
            ui.show(p,0);
        });

    }

}
