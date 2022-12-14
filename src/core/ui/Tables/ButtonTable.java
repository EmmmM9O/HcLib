package core.ui.Tables;

import core.Data;
import core.ui.Elements;
import core.ui.UiTable;
import core.funcs.ButtonRun;
import mindustry.gen.Player;

import java.util.Map;

public class ButtonTable <T>extends UiTable<T> {
    public ButtonRun<T> Run;
    public  ButtonTable(String m, ButtonRun<T> run,boolean c){
        super(m);
        Run=run;
        close=c;
    }

    @Override
    public T run(Player p, T data, Elements ui) {
        data=super.run(p, data, ui);
        data=Run.get(p,data,ui);
        return data;
    }
}
