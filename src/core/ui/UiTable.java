package core.ui;


import core.Data;
import core.funcs.GetSFunc;
import core.ui.MenuUi;
import mindustry.gen.Player;

import java.util.Map;

public class UiTable <T>{
    public GetSFunc<Player> Message;
    public boolean row=false;
    public UiTable(String name){
        Message=(player -> name);
    }
    public UiTable(GetSFunc<Player> run){
        Message=run;
    }
    public boolean show(Player p, T data){
        return true;
    }
    public  T run(Player p,T data, Elements ui){
        return data;
    }
    public T near(Player p,T data,Elements ui){
        return data;
    }
    public boolean close=false;
}


