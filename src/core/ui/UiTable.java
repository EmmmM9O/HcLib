package core.ui;


import core.funcs.GetSFunc;
import core.ui.MenuUi;
import mindustry.gen.Player;

import java.util.Map;

public class UiTable {
    public GetSFunc<Player> Message;
    public boolean row=false;
    public UiTable(String name){
        Message=(player -> name);
    }
    public UiTable(GetSFunc<Player> run){
        Message=run;
    }
    public boolean show(Player p, Map<String,? extends Object> data){
        return true;
    }
    public void run(Player p, Map<String,? extends Object> data,Elements ui){

    }
    public void near(Player p,Map<String,? extends Object> data,Elements ui){

    }
    public boolean close=false;
}


