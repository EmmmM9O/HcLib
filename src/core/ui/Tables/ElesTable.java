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
    public void near(Player p, T data, Elements ui) {
        ElesRun.get(p,data,ui);
    }

    public ElesTable(String text, ButtonRun run){
        super(text);ElesRun=run;
    }
}
