package core;


import core.funcs.GetSFunc;
import mindustry.gen.Player;

public class UiTable {
    public GetSFunc<Player> Message;
    public boolean row=false;
    public UiTable(String name){
        Message=(player -> name);
    }
    public UiTable(GetSFunc<Player> run){
        Message=run;
    }
    public boolean show(Player p,Object data){
        return true;
    }
    public void run(Player p,Object data,MenuUi ui){

    }
    public boolean close=false;
}


