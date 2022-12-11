package core;

import arc.*;
import arc.util.*;
import core.ui.MenuUi;
import mindustry.game.EventType;
import mindustry.game.EventType.*;

import mindustry.mod.*;


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
        var ui=new MenuUi("TEST","test2");
        ui.elements.text("test");
        ui.elements.button("close",((p, data, ui1) -> {}),true);
        Log.info("Loading some example content.");
        Events.on(EventType.PlayerChatEvent.class,event -> {
            var m=event.message;var p=event.player;
            ui.show(p,new Object());
        });

    }

}
