package core;

import arc.*;
import arc.util.*;
import mindustry.game.EventType;
import mindustry.game.EventType.*;

import mindustry.mod.*;


public class mainMod extends Mod{

    public mainMod(){
        Log.info("Loaded HcLib");

        //listen for game load event
        Events.on(EventType.ServerLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                loadContent();
            });
        });
    }

    @Override
    public void loadContent(){
        var ui=new MenuUi("TEST","test2");
        ui.text("test");
        Log.info("Loading some example content.");
        Events.on(EventType.PlayerChatEvent.class,event -> {
            
            var m=event.message;var p=event.player;
            Log.info("one message");
            ui.show(p,new Object());
        });

    }

}
