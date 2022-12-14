package core.ui.Tables;


import core.Data;
import core.funcs.ButtonRun;
import core.ui.Elements;
import core.ui.UiTable;
import mindustry.gen.Player;

import java.util.Map;

public class ElesTable<T> extends UiTable<T>{

    @Override
    public boolean show(Player p, T data) {
        return false;
    }
    public ButtonRun<T> ElesRun;

    @Override
    public T near(Player p, T data, Elements ui) {
        data=super.near(p,data,ui);
        data=ElesRun.get(p,data,ui);
        return data;
    }

    public ElesTable(String text, ButtonRun run){
        super(text);ElesRun=run;
    }
}
